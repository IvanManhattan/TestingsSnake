package test.test;

import com.JavaGame.Frame;
import com.JavaGame.MouseInput;
import com.JavaGame.Score;
import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {
    @Test
    public void isScoreUp () {
        Score.increaseScore(1);
        Assert.assertEquals(1, Score.getScore());
    }
    @Test
    public void isNotNull() {
        Assert.assertNotNull(Score.getInstanceScore());
    }

}


