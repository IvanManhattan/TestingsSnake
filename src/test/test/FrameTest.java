package test.test;

import com.JavaGame.Frame;
import org.junit.Assert;
import org.junit.Test;

public class FrameTest {
    @Test
    public void isNotNull() {
        Assert.assertNotNull(Frame.getInstance());
    }
}