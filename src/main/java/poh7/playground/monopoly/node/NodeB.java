package poh7.playground.monopoly.node;

import poh7.playground.monopoly.domain.Node;
import poh7.playground.monopoly.domain.Player;

/**
 * @author zhanglei
 * @version 10/20/24
 */
public class NodeB implements Node {
    @Override
    public String type() {
        return "B";
    }

    @Override
    public void onLandPlayer(Player player) {
        player.moveBackward(1);
    }

    @Override
    public String toString() {
        return "Node B, move back 1 step";
    }
}
