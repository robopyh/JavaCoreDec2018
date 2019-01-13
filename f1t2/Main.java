public class Main {

    private double calculateSequenceElement(int n) {
        return 1 / ((n + 1.0) * (n + 1.0));
    }

    public double findSequenceMinElement(double bound) {
        int n = 1;
        double sequenceElement = calculateSequenceElement(n);

        while (sequenceElement >= bound) {
            System.out.println(sequenceElement);
            sequenceElement = calculateSequenceElement(++n);
        }
        System.out.println("Min element: " + calculateSequenceElement(n));
        return calculateSequenceElement(n);
    }

    public static void main(String[] args) {
        new Main().findSequenceMinElement(0.001);
    }
}
