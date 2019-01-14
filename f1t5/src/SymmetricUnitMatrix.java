/**
 * Represents a symmetric unit matrix.
 */
public class SymmetricUnitMatrix {
    private int[][] matrix;

    /**
     * Creates a symmetric unit matrix of given dimension.
     * Dimension argument must be positive.
     * @param dimension positive int dimension of the matrix.
     */
    public void createMatrix(int dimension) {
        if (dimension < 1) {
            throw new IllegalArgumentException("Dimension argument must be more than 0");
        }
        matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension / 2; i++) {
            matrix[i][i] = 1;
            matrix[i][dimension - 1 - i] = 1;
            matrix[dimension - 1 - i][i] = 1;
            matrix[dimension - 1 - i][dimension - 1 - i] = 1;
        }
        // odd-dimension matrix has one "1" at M[n/2][n/2]
        if (dimension % 2 != 0) {
            matrix[dimension / 2][dimension / 2] = 1;
        }
    }

    /**
     * @return current matrix
     */
    public int[][] getMatrix(){
        return matrix;
    }
}

