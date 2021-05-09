package PhoneBook;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        Functionality functionality = new Functionality();
        functionality.setVisible(true);

        Person p1 = new Person(" "," "," "," "," ");
        functionality.addPerson(p1);


    }
}
