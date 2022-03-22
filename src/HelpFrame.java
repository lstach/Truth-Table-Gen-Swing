import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame {

    JLabel lblDisplay;

    HelpFrame() {

        String strDisplay = "This program generates truth tables for propositional logic formulas.  " +
                "Below is a chart that displays what you must enter and the corresponding logic symbol." +
                "  Variables must be letters A-Z.";

        this.setTitle("Help");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout((new BorderLayout()));
        this.setSize(400, 300);

        Panel headerPanel = new Panel();
        Panel mainPanel = new Panel();

        //defines headerPanel attributes
        headerPanel.setPreferredSize(new Dimension(0, 100));
        //headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JTextArea textArea = new JTextArea();
        textArea.setText(strDisplay);

        //textArea.setLineWrap(true);


        headerPanel.add(textArea);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
