package PhoneBook;

import java.time.LocalDate;
import java.time.Period;
//import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private String note;
//    private LocalDate dateOfBirth;

// Constructors
    public Person(String name, String phoneNumber, String email, String note) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.note = note;
//        this.dateOfBirth = dateOfBirth;
    }

// Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//    }
//    public int getAge() {
//        LocalDate today = LocalDate.now();
//        Period period = Period.between(this.dateOfBirth,today);
//        return period.getYears();
//    }
}
