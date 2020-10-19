package data;

import domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryPersonRepository implements PersonRepository {

    private List<Person> persons = new ArrayList<>();

    @Override
    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }
}
