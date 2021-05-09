package PhoneBook;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        Functionality functionality = new Functionality();
        functionality.setVisible(true);

        Person p1 = new Person("Dip Singha","dipsingha2@gmail.com","01720166868","My naibour Friends","02/05/1999");
        Person p2 = new Person("Tufael Ahmed","tufaelahmed@gmail.com","01720000000","Department Firnd","01/11/1999");
        Person p3 = new Person("Tufael lukman","tufaelahmed@gmail.com","01720000000","Department Firnd","01/11/1999");
        Person p4 = new Person("Tufael fayek","tufaelahmed@gmail.com","01720000000","Department Firnd","01/11/1999");
        functionality.addPerson(p1);
        functionality.addPerson(p2);
//        functionality.addPerson(p3);
//        functionality.addPerson(p4);


    }
}
