package data;

import domain.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> getPersons();
    void addPerson(Person person);

}
