package poh7.playground.monopoly.node;

import poh7.playground.monopoly.domain.Node;
import poh7.playground.monopoly.domain.Player;

/**
 * @author zhanglei
 * @version 10/20/24
 */
public class NodeE implements Node {
    @Override
    public String type() {
        return "E";
    }

    @Override
    public void onLandPlayer(Player player) {
        player.moveToPreviousNodeWithSameType();
    }

    @Override
    public String toString() {
        return "Node E, move to previous node E";
    }
}
