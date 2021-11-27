package test.test;

import com.JavaGame.GameScreen;
import org.junit.Assert;
import org.junit.Test;

public class GameScreenTest {
    @Test
    public void isNotNull() {
        Assert.assertNotNull(GameScreen.getInstance());
    }
}
