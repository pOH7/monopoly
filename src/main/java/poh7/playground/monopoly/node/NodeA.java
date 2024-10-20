package poh7.playground.monopoly.node;

import poh7.playground.monopoly.domain.Node;

/**
 * @author zhanglei
 * @version 10/20/24
 */
public class NodeA implements Node {
    @Override
    public String type() {
        return "A";
    }

    @Override
    public String toString() {
        return "Node A";
    }
}
