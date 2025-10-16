import static java.lang.Math.round;

public class CelsiusFahrenheit {

    public static int celsiusFahrenheit(int c) {
        return (int) round(c * 9.0 / 5 + 32);
    }

    public static void main(String[] args) {
        System.out.println("Celsius Fahrenheit Converter");
        System.out.println("============================");
        System.out.println("Celsius \t Fahrenheit");

        for (int c = 5; c < 20; c++) {
            System.out.println(c + "\t" + celsiusFahrenheit(c));
        }

    }
}