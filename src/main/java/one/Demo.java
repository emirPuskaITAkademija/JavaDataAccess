package one;

import one.dao.PersonFileDao;
import one.dao.PersonSerializableDao;
import one.dao.PersonXMLDao;
import one.model.Person;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        PersonFileDao personDao = new PersonFileDao();
        List<Person> personList = personDao.read();
        PersonSerializableDao serializableDao = new PersonSerializableDao();
        List<Person> personList1 = serializableDao.read();
        PersonXMLDao personXMLDao = new PersonXMLDao();
        List<Person> personList2 = personXMLDao.read();
        personList2.forEach(System.out::println);

    }
}
