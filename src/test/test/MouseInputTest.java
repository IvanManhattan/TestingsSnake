package test.test;

import com.JavaGame.MouseInput;
import org.junit.Assert;
import org.junit.Test;

public class MouseInputTest {
    @Test
    public void isNotNull() {
        Assert.assertNotNull(MouseInput.getInstance());
    }
}