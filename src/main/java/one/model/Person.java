package one.model;

import java.io.Serializable;
//    private transient String surname; -> neće biti serijalizovano i file prilikom
//serijalizacije objekta kreiranog po šablonu klse Person
public class Person implements Serializable {

    private String nationalIdentificationNumber;
    private String name;
    private String surname;
    private int age;

    public Person(){

    }

    public Person(String nationalIdentificationNumber,
                  String name, String surname,
                  int age){
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nationalIdentificationNumber='" + nationalIdentificationNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
