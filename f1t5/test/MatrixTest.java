import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MatrixTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    SymmetricUnitMatrix symmetricUnitMatrix = new SymmetricUnitMatrix();
    @Test
    public void oneElementTest() {
        symmetricUnitMatrix.createMatrix(1);
        Assert.assertEquals(symmetricUnitMatrix.getMatrix(), new int[][]{{1}});
    }

    @Test
    public void zeroDimensionTest() {
        symmetricUnitMatrix.createMatrix(0);
        exception.expect(IllegalArgumentException.class);
        symmetricUnitMatrix.getMatrix();
    }

    @Test
    public void negativeDimensionTest() {
        symmetricUnitMatrix.createMatrix(-5);
        exception.expect(IllegalArgumentException.class);
        symmetricUnitMatrix.getMatrix();
    }

    @Test
    public void oddTest() {
        symmetricUnitMatrix.createMatrix(5);
        Assert.assertEquals(symmetricUnitMatrix.getMatrix(), new int[][]{{1,0,0,0,1}, {0,1,0,1,0}, {0,0,1,0,0}, {0,1,0,1,0}, {1,0,0,0,1}});
    }

    @Test
    public void evenTest() {
        symmetricUnitMatrix.createMatrix(4);
        Assert.assertEquals(symmetricUnitMatrix.getMatrix(), new int[][]{{1,0,0,1}, {0,1,1,0}, {0,1,1,0}, {1,0,0,1}});
    }
}

