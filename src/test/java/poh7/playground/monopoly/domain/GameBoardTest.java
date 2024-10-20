package poh7.playground.monopoly.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import poh7.playground.monopoly.node.NodeA;
import poh7.playground.monopoly.node.NodeB;

/**
 * @author zhanglei
 * @version 10/20/24
 */
class GameBoardTest {

    @Test
    void getPosition() {
        GameBoard gameBoard =
                new GameBoard()
                        .addNode(new NodeA())
                        .addNode(new NodeA())
                        .addNode(new NodeA())
                        .addNode(new NodeA());
        assertEquals(4, gameBoard.getPosition(2, 2));
        assertEquals(4, gameBoard.getPosition(2, 3));
        assertEquals(4, gameBoard.getPosition(3, 1));
        assertEquals(4, gameBoard.getPosition(3, 2));
        assertEquals(4, gameBoard.getPosition(4, 1));

        assertEquals(1, gameBoard.getPosition(2, -2));
        assertEquals(1, gameBoard.getPosition(2, -3));
        assertEquals(2, gameBoard.getPosition(3, -1));
        assertEquals(1, gameBoard.getPosition(3, -2));
        assertEquals(3, gameBoard.getPosition(4, -1));
    }

    @Test
    void getPreviousPositionByType() {
        GameBoard gameBoard =
                new GameBoard()
                        .addNode(new NodeA())
                        .addNode(new NodeB())
                        .addNode(new NodeA())
                        .addNode(new NodeB());
        assertEquals(1, gameBoard.getPreviousPositionByType(1));
        assertEquals(2, gameBoard.getPreviousPositionByType(2));
        assertEquals(1, gameBoard.getPreviousPositionByType(3));
        assertEquals(2, gameBoard.getPreviousPositionByType(4));
    }
}
