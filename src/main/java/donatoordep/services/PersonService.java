package donatoordep.services;

import donatoordep.entities.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {

    @Override
    public Person createPerson(Person person) {
        person.setId(new AtomicLong().incrementAndGet());
        return person;
    }
}
