import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {

    JLabel lblDisplay;
    JButton btnHelp;
    JButton btnGo;
    JTextField txtEntry;
    JPanel headerPanel;
    JPanel mainPanel;

    MyFrame() {

        this.setTitle("Truth Table Generator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //makes close-button work. not sure if needed
        this.setLayout((new BorderLayout()));
        this.setSize(750, 520);

        //instantiates header and main content panels
        headerPanel = new JPanel(); //these need to be made global
        mainPanel = new JPanel();

        //adds content to header panel
        //TODO: organize headerPanel to ensure entry is centered and extends with app window

        headerPanel.setBackground(Color.pink);
        headerPanel.setLayout(new FlowLayout());
        headerPanel.setPreferredSize(new Dimension(10, 75));

        lblDisplay = new JLabel();
        lblDisplay.setText("Enter a formula:");
        lblDisplay.setFont(new Font("Verdana", lblDisplay.getFont().getStyle(), 15));

        btnHelp = new JButton();
        btnHelp.setText("?");
        btnHelp.addActionListener(this);

        txtEntry = new JTextField();
        txtEntry.setColumns(30);

        btnGo = new JButton();
        btnGo.setText("GO!");
        btnGo.addActionListener(this);

        headerPanel.add(lblDisplay);
        headerPanel.add(btnHelp);
        headerPanel.add(txtEntry);
        headerPanel.add(btnGo);

        mainPanel.setBackground(Color.yellow);


        this.add(headerPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);

        this.setVisible(true); //ALWAYS put this at the end. otherwise the application will appear blank on startup.
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHelp) {
            new HelpFrame();
        } else if (e.getSource() == btnGo) {
            ParseInput();
            //calculate formula
        }

    }

    public void ParseInput() {

        mainPanel.removeAll(); //clears all components from mainPanel before re-populating it with truth table

        /*tasks:
        1. check for parentheses
        2. check for variables
        3. check for operators
         */

        ArrayList<String> validVars = new ArrayList<>();
        ArrayList<String> validOperators = new ArrayList<>();

        validVars.add("a");
        validVars.add("b");
        validVars.add("c");
        validVars.add("d");

        validVars.add("e");
        validVars.add("g");
        validVars.add("h");
        validVars.add("i");

        validVars.add("j");
        validVars.add("k");
        validVars.add("l");
        validVars.add("m");

        validVars.add("n");
        validVars.add("o");
        validVars.add("p");
        validVars.add("q");

        validVars.add("r");
        validVars.add("s");
        validVars.add("u");
        validVars.add("v");

        validVars.add("w");
        //validVars.add("x");
        validVars.add("y");
        validVars.add("z");

        validOperators.add("/\\");
        validOperators.add("\\/");
        validOperators.add("->");
        validOperators.add("<->");
        validOperators.add("!");
        validOperators.add("xor");

        //hashmap where key is variable letter and value is boolean, boolean is true
        //if corresponding letter has been counted and false if not?
        //HashMap<String, Boolean> varMap = new HashMap<>();

        String strInput = txtEntry.getText().toLowerCase();
        //strInput.replaceAll("\\s", "");
        ArrayList<String> inputVars = new ArrayList<>();

        for (int i = 0; i < strInput.length(); i++) {
            String currentStr = strInput.substring(i, i + 1); //gets character at current index
            if (validVars.contains(currentStr)) { //check if given character is a valid variable
                if (!inputVars.contains(currentStr)) { //checks if already in list of input variables
                    inputVars.add(currentStr); //adds given variable if not already in list (avoids double-counting)
                }
            }
        }

        int numUniqueVariables = inputVars.size();

        int columns = numUniqueVariables + 1;
        int rows = (int) Math.pow(2, numUniqueVariables) + 1;

        if (strInput.contains("/\\")) {

        }

        if (strInput.contains("/\\")) {

        }

        if (strInput.contains("/\\")) {

        }

        if (strInput.contains("/\\")) {

        }


        GridLayout truthGrid = new GridLayout(rows, columns);

        System.out.println("Grid dimensions: " + truthGrid.getRows() + "rows, " + truthGrid.getColumns() + "columns");

        for (int i = 0; i < inputVars.size(); i++) {
            JLabel label = new JLabel();
            label.setText(inputVars.get(i));
            //System.out.println(inputVars.get(i));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            mainPanel.add(label);
        }


        //Evaluate eval = new Evaluate();

        //System.out.println(eval.and(true, false));

        mainPanel.setLayout(truthGrid);
        this.setVisible(true);
    }
}
