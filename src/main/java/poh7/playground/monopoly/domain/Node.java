package poh7.playground.monopoly.domain;

/**
 * @author zhanglei
 * @version 10/20/24
 */
public interface Node {
    String type();

    default void onLandPlayer(Player player) {}

    default Player withPlayer(Player player) {
        return player;
    }
}
