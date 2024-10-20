package poh7.playground.monopoly;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import poh7.playground.monopoly.domain.Dice;
import poh7.playground.monopoly.domain.GameBoard;
import poh7.playground.monopoly.domain.Player;
import poh7.playground.monopoly.node.*;

@SpringBootApplication
public class MonopolyApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MonopolyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        GameBoard gameBoard =
                new GameBoard()
                        .addNode(new NodeE())
                        .addNode(new NodeA())
                        .addNode(new NodeA())
                        .addNode(new NodeB())
                        .addNode(new NodeC())
                        .addNode(new NodeA())
                        .addNode(new NodeA())
                        .addNode(new NodeB())
                        .addNode(new NodeC())
                        .addNode(new NodeD())
                        .addNode(new NodeA())
                        .addNode(new NodeE())
                        .addNode(new NodeD())
                        .addNode(new NodeA())
                        .addNode(new NodeE())
                        .addNode(new NodeA())
                        .addDice(new Dice())
                        .addPlayer(new Player("甲"))
                        .addPlayer(new Player("乙"))
                        .addPlayer(new Player("丙"));
        gameBoard.start();
    }
}
