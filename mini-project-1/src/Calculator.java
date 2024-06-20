// Written by: Beatriz Franco
// Java Learning Modules Week 1a
// Accepts: first argument, operator, second argument
// Returns: arithmetic result
// Can catch: invalid number inputs, invalid operators, division by 0
// Cannot catch: overflow

// Scanner for input
import java.util.Scanner;

public class Calculator {
    // function to handle possible invalid numbers and prompt for correct ones
    public static double handleInput(String str, Scanner scanner){
        double out = 0;
        boolean valid = false;

        // use number format to catch invalid inputs
        while(!valid){
            try{
                out = Double.parseDouble(str);
                valid = true;
            } catch(NumberFormatException e){
                System.out.println("Invalid number input, try again: ");
                str = scanner.nextLine();
            }
        }

        return out;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        double arg1;
        double arg2;
        double result = 0;
        String operator = "";

        System.out.println("Enter first number: ");
        arg1 = handleInput(scanner.nextLine(), scanner);

        while(cont){
            while(!operator.equals("+") && !operator.equals("-")
                    && !operator.equals("*") && !operator.equals("/")){
                System.out.println("Enter operator (+, -, *, /)");
                operator = scanner.nextLine();
                if(!operator.equals("+") && !operator.equals("-")
                        && !operator.equals("*") && !operator.equals("/")){
                    System.out.println("Invalid operation, try again:");
                }
            }

            System.out.println("Enter second number: ");
            arg2 = handleInput(scanner.nextLine(), scanner);

            switch (operator){
                case "+":
                    result = arg1 + arg2;
                    break;
                case "-":
                    result = arg1 - arg2;
                    break;
                case "*":
                    result = arg1 * arg2;
                    break;
                case "/":
                    while(arg2 == 0){
                        System.out.println("Error, cannot divide by 0. Enter new divisor: ");
                        arg2 = handleInput(scanner.nextLine(), scanner);
                    }
                    result = arg1 / arg2;
                    break;
            }

            System.out.println("= " + Double.toString(result));

            System.out.println("Enter 'p' to do another operation with this result, 'n' for a new operation, or anything else to quit.");

            switch(scanner.nextLine()){
                case "p":
                    arg1 = result;
                    break;
                case "n":
                    System.out.println("Enter first number: ");
                    arg1 = handleInput(scanner.nextLine(), scanner);
                    break;
                default:
                    cont = false;
                    break;
            }
        }
    }
}