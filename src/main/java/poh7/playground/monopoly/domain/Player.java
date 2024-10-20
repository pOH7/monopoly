package poh7.playground.monopoly.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglei
 * @version 10/20/24
 */
@Slf4j
@Getter
@Setter
public class Player {
    private String name;

    private GameBoard gameBoard;
    private Dice dice;

    private int position = 1;
    private boolean finished;
    private Map<String, Object> properties = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public int rollDice() {
        int step = dice.roll(6);
        log.info("Player {} roll dice and get {}", name, step);
        return step;
    }

    public void moveForward(int steps) {
        position = gameBoard.getPosition(position, steps);
        log.info("Player {} move to position {}, {}", name, position, gameBoard.getNode(position));
    }

    public void moveBackward(int steps) {
        position = gameBoard.getPosition(position, -steps);
        log.info("Player {} move to position {}, {}", name, position, gameBoard.getNode(position));
    }

    public void moveToPreviousNodeWithSameType() {
        position = gameBoard.getPreviousPositionByType(position);
        log.info("Player {} move to position {}, {}", name, position, gameBoard.getNode(position));
    }

    public void moveToFirstNode() {
        position = 1;
        log.info("Player {} move to position {}, {}", name, position, gameBoard.getNode(position));
    }

    public void finish() {
        finished = true;
        log.info("Player {} is finished", name);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public void removeProperty(String key) {
        properties.remove(key);
    }
}
