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
            ShuntingYard shunter = new ShuntingYard();
            String tokens[] = txtEntry.getText().split(" ");
            ArrayList<String> output = shunter.shunt(tokens);

            for (String s : output){
                System.out.print(s + " ");
            }
            System.out.println("\n");
            ParseInput();
            //calculate formula
        }
    }

    public void ParseInput() {

        mainPanel.removeAll(); //clears all components from mainPanel before re-populating it with truth table

        this.setVisible(true);
    }
}
