public class Main {

    /**
     * Returns a double that represents a maximum sum:  max(a[1] + a[2n], a[2] + a[2n-1], ..., a[n] + a[n+1]).
     * The array argument must be even length.
     *
     * @param realNumbers even length double array
     * @return maximum sum
     * @throws IllegalArgumentException it'll be thrown if input array would be odd length
     */
    public static double findMaxSum(double[] realNumbers) throws IllegalArgumentException{
        double max = 0;
        int length = realNumbers.length;

        if (length % 2 != 0) {
            throw new IllegalArgumentException("Array length must be even. Current length: " + length);
        }

        for (int i = 0; i < length / 2; i++) {
            if (realNumbers[i] + realNumbers[length - 1 - i] > max) {
                max = realNumbers[i] + realNumbers[length - 1 - i];
            }
        }
        return max;
    }
}


