import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {


    //TODO: true or false does not work (evaluates to false)

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ShuntingYard shunter = new ShuntingYard();


        String input = "";

        System.out.println("enter");

        while (!input.toLowerCase().equals("quit")){

            input = scanner.nextLine();

            String[] split = input.split(" ");

            /*String.split() method returns a String array, but it's easier to work with ArrayLists. This line
            splits the String and then converts the resulting array to an arraylist.
            */
            ArrayList<String> infixTokens = new ArrayList<>(Arrays.asList(input.split(" ")));

            int numOperands = shunter.countOperands(infixTokens);
            boolean[][] combinations = shunter.generateRows(numOperands);

            for (int row = 0; row < combinations.length; row++){
                for (int col = 0; col < combinations[row].length; col++){
                    System.out.print(combinations[row][col] + " ");
                }
                System.out.println();
            }

            ArrayList<String> rpnTokens = shunter.shunt(split);

            String[] operandArray = new String[numOperands];

            ArrayList<String>[] truthTable = new ArrayList[combinations.length];

            for (int row = 0; row < combinations.length; row++){
                int col = 0;
                //visitedOperands can be made more efficient with a hashmap (index represents index in row, key represents operand)
                ArrayList<String> visitedOperands = new ArrayList<>();
                ArrayList<String> formula = new ArrayList<>();
                for (int i = 0; i < rpnTokens.size(); i++){
                    String token = rpnTokens.get(i);
                    if (shunter.isOperand(token)){
                        if (!visitedOperands.contains(token)){
                            formula.add(Boolean.toString(combinations[row][col]));
                            visitedOperands.add(token);
                            col++;
                        }
                        else{
                            int retrieve = visitedOperands.indexOf(token);
                            formula.add(Boolean.toString(combinations[row][retrieve]));
                        }
                    }
                    else{
                        formula.add(token);
                    }
                }
                truthTable[row] = formula;
            }

            System.out.println();

            for (int row = 0; row < truthTable.length; row++){
                for (int i = 0; i < truthTable[row].size(); i++){
                    System.out.print(truthTable[row].get(i) + " ");
                }
                System.out.println();
            }


            /*
            for (int i = 0; i < rpnTokens.size(); i++){
                System.out.print(rpnTokens.get(i) + " ");
            }

            boolean answer = shunter.calculate(rpnTokens);

            System.out.println("Evaluates to: " + answer);*/
        }

        //new MyFrame();
    }
}
