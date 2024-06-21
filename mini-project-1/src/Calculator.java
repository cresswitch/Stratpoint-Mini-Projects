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

    // function to handle operator input
    public static String handleOp(String str, Scanner scanner){
        boolean valid = false;

        while(!valid){
            try{
                if(str.equals("+") || str.equals("-")
                        || str.equals("*") || str.equals("/")){
                    valid = true;
                }
                else{
                    throw new Exception();
                }
            } catch(Exception e){
                System.out.println("Invalid operation, try again:");
                str = scanner.nextLine();
            }
        }

        return str;
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
            System.out.println("Enter operator: ");
            operator = handleOp(scanner.nextLine(), scanner);

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
                    boolean valid = false;
                    while(!valid){
                        try{
                            result = arg1 / arg2;
                            if(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
                                throw new ArithmeticException();
                            }
                            else{
                                valid = true;
                            }
                        } catch(ArithmeticException e){
                            System.out.println("Error, cannot divide by 0. Enter new divisor: ");
                            arg2 = handleInput(scanner.nextLine(), scanner);
                        }
                    }
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