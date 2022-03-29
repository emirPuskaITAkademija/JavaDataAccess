package one.dao;

import one.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * //                StringBuilder sb = new StringBuilder();
 * //                sb.append(person.getNationalIdentificationNumber());
 * //                sb.append(";");
 * //                sb.append(person.getName());
 * //                sb.append(";");
 * //                sb.append(person.getSurname());
 * //                sb.append(";");
 * //                sb.append(person.getAge());
 * <p>
 * //                String personLineFormat = person.getNationalIdentificationNumber()+
 * //                        ";"+
 * //                        person.getName()+
 * //                        ";"+
 * //                        person.getSurname()+
 * //                        ";"+
 * //                        person.getAge();
 * <p>
 * Storage for elements is TXT fajl.
 */
public class PersonFileDao implements Dao<Person> {

    public static final String FILE_NAME = "persons.txt";

    @Override
    public void write(List<Person> persons) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             PrintWriter out = new PrintWriter(fileWriter);) {
            for (Person person : persons) {
                StringJoiner sj = new StringJoiner(";");
                sj.add(person.getNationalIdentificationNumber());
                sj.add(person.getName());
                sj.add(person.getSurname());
                sj.add(person.getAge() + "");
                out.println(sj);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Person> read() {
        List<Person> personList = new ArrayList<>();
        //FileReader, BufferedReader
        try (FileReader fileReader = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fileReader)) {
            //br -> readLine -> ili line text ili null kad dođe do EOF
            String line;
            while ((line = br.readLine()) != null) {
                //nin;name;surname;age
                String[] lineFields = line.split(";");
                String nin = lineFields[0];
                String name = lineFields[1];
                String surname = lineFields[2];
                int age = Integer.parseInt(lineFields[3]);
                Person person = new Person(nin, name, surname, age);
                personList.add(person);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return personList;
    }
}
