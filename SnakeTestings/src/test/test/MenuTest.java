
import com.JavaGame.Menu;
import org.junit.Assert;
import org.junit.Test;

public class MenuTest {
    @Test
    public void isNotNull() {
        Assert.assertNotNull(Menu.getInstance());
    }
}