import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JLabel lblDisplay;
    JButton btnHelp;
    JButton btnGo;
    JTextField txtEntry;

    MyFrame() {

        this.setTitle("Truth Table Generator");
        this.setDefaultCloseOperation(3); //makes close-button work. not sure if needed
        this.setLayout((new BorderLayout()));
        this.setSize(750, 520);

        //instantiates header and main content panels
        JPanel headerPanel = new JPanel();
        JPanel mainPanel = new JPanel();

        //adds content to header panel
        //TODO: organize headerPanel to ensure entry is centered and extends with app window

        headerPanel.setBackground(Color.pink);
        headerPanel.setLayout(new FlowLayout());

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
        JLabel mainLabel = new JLabel();
        mainLabel.setText("Main content will go here.");
        mainPanel.add(mainLabel);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);

        this.setVisible(true); //ALWAYS put this at the end. otherwise the application will appear blank on startup.
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHelp) {
            System.out.println("Help");
        }
    }
}
