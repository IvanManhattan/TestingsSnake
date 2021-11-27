package test.test;

import com.JavaGame.Snake;
import org.junit.Assert;
import org.junit.Test;

public class SnakeTest {
    @Test
    public void isNotNull() {
        Assert.assertNotNull(Snake.getInstanceSnake());
    }
}
