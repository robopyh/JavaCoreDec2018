import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MainTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void firstTest() {
        Assert.assertEquals(0, Main.findMaxSum(new double[]{0, 0, 0, 0, 0, 0}), 0.0);

        Assert.assertEquals(0, Main.findMaxSum(new double[]{}), 0.0);

        exception.expect(IllegalArgumentException.class);
        Main.findMaxSum(new double[]{-1.3, 2.2, 5.8, -6.3, 12.0, 8.5, 6.9});

        Assert.assertEquals(14.4, Main.findMaxSum(new double[]{-1.3, 2.2, 5.8, -6.3, 12.0, 8.5}), 0.0);
    }
}

