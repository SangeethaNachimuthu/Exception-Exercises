package lexicon;


import java.util.InputMismatchException;

public class Main {

    void main() {

        //Exercise 1
        divideTwoNumbers();

        //Exercise 2
        checkNumber();
    }

    public static void divideTwoNumbers() {

        int a = Integer.parseInt(IO.readln("Enter number a: "));
        int b = Integer.parseInt(IO.readln("Enter number b: "));

        try {
            int c = a / b;
            IO.println("The result is " + c);
        } catch (ArithmeticException e) {
            IO.println("Can't divide by zero.");
        }
    }

    public static void checkNumber() {

        try {
            int x = Integer.parseInt(IO.readln("Enter a number: "));

            if (x < 1 || x > 100) {
                throw new OutOfRangeException("Number is out of range (1-100).");
            }
            IO.println("Number is within the range.");
        }
        catch (NumberFormatException e) {
            IO.println("Not a number, please enter a number.");
        }
        catch (OutOfRangeException e) {
            IO.println(e.getMessage());
        }

    }
}
