package poh7.playground.monopoly.domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import java.util.Random;

/**
 * @author zhanglei
 * @version 10/20/24
 */
public class Dice {
    private Random random = new Random();

    public int roll(@Validated @Range(min = 1, max = 6) int max) {
        return random.nextInt(max) + 1;
    }
}
