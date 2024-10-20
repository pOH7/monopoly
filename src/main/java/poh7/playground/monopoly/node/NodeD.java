package poh7.playground.monopoly.node;

import poh7.playground.monopoly.domain.Node;
import poh7.playground.monopoly.domain.Player;

/**
 * @author zhanglei
 * @version 10/20/24
 */
public class NodeD implements Node {
    @Override
    public String type() {
        return "D";
    }

    @Override
    public void onLandPlayer(Player player) {
        player.moveToFirstNode();
    }

    @Override
    public String toString() {
        return "Node D, move to first node";
    }
}
