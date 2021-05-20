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
    private JList displayList;
    private ArrayList<Person> people;
    private DefaultListModel displayListModel;


// Constructors
    public Functionality() {
        super("Phone Book");

        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setBounds(100,100,450,500);
        this.setLocation(700,380);
        this.setVisible(true);
        this.people = new ArrayList<Person>();
        this.displayListModel = new DefaultListModel();
        this.displayList.setModel(displayListModel);
        buttonSave.setEnabled(false);

        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Person a = new Person(
                            textName.getText(),
                            textPhone.getText(),
                            textEmail.getText(),
                            textNotes.getText(),
                            textDOB.getText()
                    );
                    people.add(a);
                    refreshDisplayList();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int personNumber = displayList.getSelectedIndex();
                if(personNumber>=0) {
                    Person a = people.get(personNumber);
                    a.setName(textName.getText());
                    a.setPhoneNumber(textPhone.getText());
                    a.setEmail(textEmail.getText());
                    a.setNote(textNotes.getText());
                    a.setDateOfBirth(textDOB.getText());
                    refreshDisplayList();
                }

            }
        });

        displayList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int personNumber = displayList.getSelectedIndex();
                if(personNumber >=0) {
                    Person a = people.get(personNumber);
                    textName.setText(a.getName());
                    textPhone.setText(a.getPhoneNumber());
                    textEmail.setText(a.getEmail());
                    textNotes.setText(a.getNote());
                    textDOB.setText(a.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    buttonSave.setEnabled(true);
                } else {
                    buttonSave.setEnabled(false);
                }
            }
        });

    }

// Refresh display list  by this method

    public void refreshDisplayList () {
        displayListModel.removeAllElements();
        System.out.println("Removing all people from list.");

        for(Person a : people) {
            System.out.println("Adding person to list : " + a.getName());
            displayListModel.addElement(a.getName());

        }
    }

// add person by this method
    public void addPerson(Person a) {
        people.add(a);
        refreshDisplayList();
    }

}
