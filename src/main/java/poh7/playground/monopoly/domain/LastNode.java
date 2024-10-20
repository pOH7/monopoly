package poh7.playground.monopoly.domain;

import lombok.RequiredArgsConstructor;

/**
 * @author zhanglei
 * @version 10/20/24
 */
@RequiredArgsConstructor
public class LastNode implements Node {
    private final Node node;

    @Override
    public String type() {
        return node.type();
    }

    @Override
    public void onLandPlayer(Player player) {
        player.finish();
    }

    @Override
    public String toString() {
        return "Node " + node.type() + ", last node, finish";
    }
}
