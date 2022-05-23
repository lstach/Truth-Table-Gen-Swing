import java.util.ArrayList;
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

            String[] infixTokens = input.split(" ");



            ArrayList<String> rpnTokens = shunter.shunt(infixTokens);

            for (int i = 0; i < rpnTokens.size(); i++){
                System.out.println(rpnTokens.get(i));
            }


            boolean answer = shunter.calculate(rpnTokens);

            System.out.println("Evaluates to: " + answer);


        }

        //new MyFrame();
    }
}
