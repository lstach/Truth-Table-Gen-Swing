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
            ArrayList<String> rpnTokens = shunter.shunt(split);


            int num = shunter.countOperands(infixTokens);
            boolean[][] matrix = shunter.generateRows(num);

            System.out.println("Number of operands: " + num);
            for (int row = 0; row < matrix.length; row++){
                for (int col = 0; col < matrix[row].length; col++){
                    System.out.print(matrix[row][col] + " ");
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
