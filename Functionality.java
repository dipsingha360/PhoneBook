package PhoneBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Functionality extends JFrame{
    protected JPanel mainPanel;
    private JButton buttonNew;
    private JButton buttonSave;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel labelAge;
    private JTextField textDateOfBirth;

    public Functionality() {
        super("Phone Book");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
