package poh7.playground.monopoly.domain;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhanglei
 * @version 10/20/24
 */
@Slf4j
public class GameBoard {
    private List<Node> nodes = new ArrayList<>();
    private Dice dice;
    private List<Player> players = new ArrayList<>();

    public GameBoard addNode(Node node) {
        if (nodes.isEmpty()) {
            nodes.add(new FirstNode(node));
        } else {
            nodes.add(node);
        }
        return this;
    }

    public GameBoard addDice(Dice dice) {
        this.dice = dice;
        return this;
    }

    public GameBoard addPlayer(Player player) {
        players.add(player);
        return this;
    }

    public void start() {
        nodes.add(new LastNode(nodes.remove(nodes.size() - 1)));

        for (Player player : players) {
            player.setGameBoard(this);
            player.setDice(dice);
        }

        // choose order
        Collections.shuffle(players);

        int round = 0;
        int maxRound = 100;
        while (round++ < maxRound && !players.stream().allMatch(Player::isFinished)) {
            log.info("Round {}", round);
            for (Player player : players) {
                if (player.isFinished()) {
                    log.info("Player {} is finished", player.getName());
                    continue;
                }

                // roll dice
                int steps = nodes.get(player.getPosition() - 1).withPlayer(player).rollDice();
                if (steps == 0) {
                    continue;
                }

                // move the player
                player.moveForward(steps);

                // do the action on the node
                int pos = 0;
                do {
                    pos = player.getPosition();
                    Node node = nodes.get(pos - 1);
                    node.onLandPlayer(player);
                } while (player.getPosition() != pos);

                // kick out other players
                for (Player p : players) {
                    if (p != player
                            && p.getPosition() != 1
                            && p.getPosition() != nodes.size()
                            && p.getPosition() == player.getPosition()) {
                        p.moveToFirstNode();
                    }
                }
            }
        }
    }

    public int getPosition(int position, int steps) {
        return Math.min(nodes.size(), Math.max(1, position + steps));
    }

    public int getPreviousPositionByType(int position) {
        String type = nodes.get(position - 1).type();
        for (int pos = position - 1; pos >= 1; pos--) {
            if (nodes.get(pos - 1).type().equals(type)) {
                return pos;
            }
        }
        // if not found, return the current position
        return position;
    }

    public Node getNode(int position) {
        return nodes.get(position - 1);
    }
}
