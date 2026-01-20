package lexicon;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    void main() {

        //Exercise 1 and 5
        //divideTwoNumbers();

        //Exercise 2
        //checkNumber();

        //Exercise 3
        //depositAndWithdrawal();

        //Exercise 4
        //readAFile();

        //Exercise 6
        String email = IO.readln("Enter Email: ");
        checkEmailAddress(email);

    }

    public static void divideTwoNumbers() {

        int a = Integer.parseInt(IO.readln("Enter number a: "));
        int b = Integer.parseInt(IO.readln("Enter number b: "));
        int c = 0;
        try {
            c = a / b;
            IO.println("The result is " + c);
        } catch (ArithmeticException e) {
            IO.println("Can't divide by zero.");
            c = -1;
        } finally {
            if (c != -1) {
                IO.println("This is finally block. Division of " + a + " by " + b + " is " + c);
            } else {
                IO.println("This is finally block and Can't divide by zero.");
            }
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

    public void depositAndWithdrawal() {
        BankAccount account1 = new BankAccount(1234, 1000);
        IO.println(account1);
        try {
            account1.deposit(100);
            IO.println(account1);
            account1.withdrawal(200);
            IO.println(account1);
        }
        catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            IO.println("Error: " + e);
        }
    }

    public void readAFile() {

        try {
            List<String> names = Files.readAllLines(Path.of("dir/names.txt"));
            IO.println(names);
            try {
                for (String s : names) {
                    int a = Integer.parseInt(s);
                    IO.println(a);
                }
                /*int a = Integer.parseInt(names.toString());
                IO.println(a);*/
            }
            catch (NumberFormatException e) {
                IO.println("Invalid format to convert into Integer.");
            }
        }
        catch (NoSuchFileException e) {
            IO.println("File not found.");
        }
        catch (IOException e) {
            IO.println("File not found or Invalid path.");
        }
    }

    public void checkEmailAddress(String email) {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Not a valid email address.");
        }
        System.out.println("Yes, valid Email.");
    }
}
