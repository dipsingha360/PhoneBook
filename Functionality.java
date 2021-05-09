package PhoneBook;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Functionality extends JFrame{
    protected JPanel mainPanel;
    private JButton buttonNew;
    private JButton buttonSave;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextField textNotes;
    private JTextField textDOB;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel labelAge;
    private JList displayList;
    private ArrayList<Person> people;
    private DefaultListModel displayListModel;



// Constructors
    public Functionality() {
        super("Phone Book");

        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.people = new ArrayList<Person>();
        this.displayListModel = new DefaultListModel();
        this.displayList.setModel(displayListModel);

        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        displayList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int personNumber = displayList.getSelectedIndex();
                if(personNumber >=0) {
                    Person a = people.get(personNumber);
                    displayListModel.addElement(a.getName());
                    textName.setText(a.getName());
                    textPhone.setText(a.getPhoneNumber());
                    textEmail.setText(a.getEmail());
                    textNotes.setText(a.getNote());
                    textDOB.setText(a.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
            }
        });

    }

    public void refreshDisplayList () {
        displayListModel.removeAllElements();
        System.out.println("Removing all people from list.");

        for(Person a : people) {
            System.out.println("Adding person to list : " + a.getName());
            displayListModel.addElement(a.getName());

        }
    }

    public void addPerson(Person a) {
        people.add(a);
        refreshDisplayList();
    }

}
