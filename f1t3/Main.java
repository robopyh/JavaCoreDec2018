public class Main {

    public void calculateFunctionValues(int a, int b, int h) {
        System.out.println("    x   |   F(x)    ");
        System.out.println("--------|-----------");
        for (; a <= b; a += h) {
            double value = Math.tan(2 * a) - 3;
            System.out.println("    " + a + "   |   " + value + "   ");
        }
    }

    public static void main(String[] args) {
        new Main().calculateFunctionValues(2, 15, 3);
    }
}
