package poh7.playground.monopoly.node;

import lombok.extern.slf4j.Slf4j;

import poh7.playground.monopoly.domain.Node;
import poh7.playground.monopoly.domain.Player;

/**
 * @author zhanglei
 * @version 10/20/24
 */
@Slf4j
public class NodeC implements Node {
    @Override
    public String type() {
        return "C";
    }

    @Override
    public void onLandPlayer(Player player) {
        player.setProperty("FirstOnC", true);
    }

    @Override
    public Player withPlayer(Player player) {
        return new Player(player.getName()) {
            @Override
            public int rollDice() {
                int steps = player.rollDice();
                if (player.getProperty("FirstOnC") != null) {
                    steps = 0;
                    log.info("roll dice is nullified");
                    player.removeProperty("FirstOnC");
                }
                return steps;
            }
        };
    }

    @Override
    public String toString() {
        return "Node C, nullify roll dice once";
    }
}
