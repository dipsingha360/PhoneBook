package PhoneBook;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Functionality extends JFrame{
    protected JPanel mainPanel;
    private JButton buttonNew;
    private JButton buttonSave;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextField textNotes;
//    private JTextField textDOB;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JList displayList;
    private JLabel warning;
    private JButton buttonDelete;
    private ArrayList<Person> people;
    private DefaultListModel displayListModel;


// Constructors
    public Functionality() {
        super("Phone Book");

        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setBounds(100,100,500,400);
        this.setLocation(700,380);
        this.setVisible(true);
        this.people = new ArrayList<Person>();
        this.displayListModel = new DefaultListModel();
        this.displayList.setModel(displayListModel);
        buttonSave.setEnabled(false);
        buttonDelete.setEnabled(false);

        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Person a = new Person(
                            textName.getText(),
                            textPhone.getText(),
                            textEmail.getText(),
                            textNotes.getText()
//                            textDOB.getText()
                    );

                    if(textName.getText().trim().isEmpty() && textPhone.getText().trim().isEmpty()) {
                        warning.setText("Name and Phone should not be empty!");
                    } else if(textName.getText().trim().isEmpty()) {
                        warning.setText("Name should not be empty!");
                    } else if(textPhone.getText().trim().isEmpty()) {
                        warning.setText("Phone should not be empty!");
                    }else {
                        people.add(a);
                        warning.setText(" ");
                        refreshDisplayList();
                    }


            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int personNumber = displayList.getSelectedIndex();
                if(textName.getText().trim().isEmpty() && textPhone.getText().trim().isEmpty()) {
                    warning.setText("Name and Phone should not be empty!");
                } else if(textName.getText().trim().isEmpty()) {
                    warning.setText("Name should not be empty!");
                } else if(textPhone.getText().trim().isEmpty()) {
                    warning.setText("Phone should not be empty!");
                }else if(personNumber>=0) {
                    Person a = people.get(personNumber);
                    a.setName(textName.getText());
                    a.setPhoneNumber(textPhone.getText());
                    a.setEmail(textEmail.getText());
                    a.setNote(textNotes.getText());
//                    a.setDateOfBirth(textDOB.getText());
                    warning.setText(" ");
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
//                    textDOB.setText(a.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    buttonSave.setEnabled(true);
                    buttonDelete.setEnabled(true);
                } else {
                    buttonSave.setEnabled(false);
                    buttonDelete.setEnabled(false);
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int personNumber = displayList.getSelectedIndex();
                displayListModel.removeElementAt(personNumber);

                textName.setText(" ");
                textPhone.setText(" ");
                textEmail.setText(" ");
                textNotes.setText(" ");
//        textDOB.setText(" ");


            }
        });
    }

// Refresh display list  by this method

    public void refreshDisplayList () {
        textName.setText(" ");
        textPhone.setText(" ");
        textEmail.setText(" ");
        textNotes.setText(" ");
//        textDOB.setText(" ");
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
