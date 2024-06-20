// Written by: Beatriz Franco
// Java Learning Modules Week 1a Alternative Solution through recursion and regex
// Accepts: arithmetic expression
// Returns: arithmetic result
// Can catch: invalid number inputs, invalid operators, division by 0, invalid parentheses
// Bad error handling through exit calls instead of exceptions
// Cannot catch: overflow
// Fails some test cases due to string handling

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static String handleExpression(String str){
        // checks for non-numeric or non-operator characters
        Pattern p1 = Pattern.compile("[^0-9+*/().-]");
        Matcher m1 = p1.matcher(str);

        if(m1.find()){
            System.out.println("Error with invalid characters");
            System.exit(0);
        }

        // checks for improper parentheses
        if((str.contains(")") && !str.contains("("))
                || (str.contains("(") && !str.contains(")"))
                || (str.indexOf(")") < str.indexOf("("))){
            System.out.println("Error with parentheses");
            System.exit(0);
        }

        // test
        System.out.println(str);

        // recursively take care of expressions within parentheses
        // makes sure that correct sets of expressions are handled
        while(str.contains("(")){
            int a = str.indexOf("(");
            int counter = 0;
            for(int b = a + 1; b < str.length(); b++){
                if(str.substring(b, b+1).contains("(")){
                    counter++;
                }
                else if(str.substring(b, b+1).contains(")") && counter > 0){
                    counter--;
                }
                else if(str.substring(b, b+1).contains(")") && counter == 0){
                    str = str.substring(0,a) + handleExpression(str.substring(a+1,b)) + str.substring(b+1);
                }
            }
        }

        // split into array of final numbers and operators with no more parentheses
        ArrayList<String> arrList = new ArrayList<>();
        int counter = 1;
        while(!str.isEmpty()){
            if(counter < str.length() && str.substring(0, counter).matches(".*[+*/-].*")){
                arrList.add(str.substring(0,counter-1));
                arrList.add(str.substring(counter-1, counter));
                str = str.substring(counter);
                counter = 1;
            }
            else if(counter == str.length()){
                arrList.add(str);
                break;
            }
            else{
                counter++;
            }
        }

        // checks for operators at the start and end of expression
        if(arrList.get(0).matches(".*[+*/-].*") || arrList.get(arrList.size()-1).matches(".*[+*/-].*")){
            System.out.println("Error with placement of operators");
            System.exit(0);
        }

        // checks for operators beside each other
        for(int a = 1; a < arrList.size() - 1; a++){
            if(arrList.get(a).matches(".*[+*/-].*") && arrList.get(a+1).matches(".*[+*/-].*")){
                System.out.println("Error with placement of operators");
                System.exit(0);
            }
        }



        // do all multiplication and division (left to right)
        for(int a = 0; a < arrList.size(); a++){
            if(arrList.get(a).matches(".*[*/].*")){
                if(arrList.get(a).equals("*")){
                    arrList.set(a-1, Double.toString(
                            Double.parseDouble(arrList.get(a-1)) * Double.parseDouble(arrList.get(a+1))
                    ));
                }
                else{
                    if(Double.parseDouble(arrList.get(a+1)) == 0){
                        System.out.println("Error with dividing by zero");
                        System.exit(0);
                    }
                    else{
                        arrList.set(a-1, Double.toString(
                                Double.parseDouble(arrList.get(a-1)) / Double.parseDouble(arrList.get(a+1))
                        ));
                    }
                }

                arrList.remove(a+1);
                arrList.remove(a);
                a -= 2;
            }
        }

        // do all addition and subtraction
        while(arrList.size() > 1){
            if(arrList.get(1).equals("+")){
                arrList.set(0, Double.toString(
                        Double.parseDouble(arrList.get(0)) + Double.parseDouble(arrList.get(2))
                ));
            }
            else{
                arrList.set(0, Double.toString(
                        Double.parseDouble(arrList.get(0)) - Double.parseDouble(arrList.get(2))
                ));
            }
            arrList.remove(2);
            arrList.remove(1);
        }

        return arrList.get(0);
    }

    public static void main(String[] args){
        String expression;
        boolean cont = true;
        Scanner scanner = new Scanner(System.in);

        while(cont){
            System.out.println("Enter expression to evaluate:");
            expression = scanner.nextLine();

            System.out.println("= " + handleExpression(expression));

            System.out.println("Evaluate another expression? (y/n)");
            if (!scanner.nextLine().equals("y")) {
                cont = false;
            }
        }
    }
}