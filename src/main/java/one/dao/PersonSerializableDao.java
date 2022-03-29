package one.dao;

import one.model.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Person p = new Person();
 * write(p);
 * <p>
 * .dat
 * <p>
 * persons.dat
 *
 * <p>
 * Preduvjet korištenja ove DAO implementacije je da koristimo
 * List<Person> elemenata kreiranih po šablonu klase Person i uz to da
 * navedena klasa Person implementira java.io.Serializable.
 * </p>
 */
public class PersonSerializableDao implements Dao<Person> {

    static final String FILE_NAME = "persons.dat";

    /**
     * FileOutputStream outputStream
     * ObjectOutputStream ous
     *
     * @param persons
     */
    @Override
    public void write(List<Person> persons) {
        if(persons == null || persons.isEmpty()){
            return;
        }
        try(OutputStream outputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream ous = new ObjectOutputStream(outputStream)){
            ous.writeObject(persons);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * FileInputStream
     * ObjectInputStream
     *
     *
     * @return persons
     */
    @Override
    public List<Person> read() {
        try(FileInputStream fin = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fin)){
            ArrayList<Person> readedObject = (ArrayList<Person>) ois.readObject();
            return readedObject;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
