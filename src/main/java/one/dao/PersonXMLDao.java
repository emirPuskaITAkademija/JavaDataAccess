package one.dao;

import one.model.Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonXMLDao implements Dao<Person> {

    static final String FILE_NAME = "persons.xml";

    @Override
    public void write(List<Person> persons) {
        try (FileOutputStream fous = new FileOutputStream(FILE_NAME);
             XMLEncoder encoder = new XMLEncoder(fous)) {
            encoder.writeObject(persons);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Person> read() {
        try (FileInputStream fin = new FileInputStream(FILE_NAME);
             XMLDecoder decoder = new XMLDecoder(fin)) {
            ArrayList<Person> personArrayList = (ArrayList<Person>) decoder.readObject();
            return personArrayList;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
