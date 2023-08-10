package com.donatoordep;

import donatoordep.entities.Person;
import donatoordep.services.IPersonService;
import donatoordep.services.PersonService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    Person person;
    IPersonService service;

    @BeforeEach
    void setup() {
        person = new Person("Pedro", 17, "pedro@gmail.com", "Male");
        service = new PersonService();
    }

    @Order(1)
    @Test
    @DisplayName("When Create a Person With Success, Should Return a Person Object")
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        // When / Act- Inicia a execução do cenário.
        Person actual = service.createPerson(person);

        // Then / Assert - Avaliação do resultado, verifica se corresponde ao esperado.
        assertNotNull(actual, () -> "The createPerson() Should not have returned null!");
    }

    @Order(2)
    @Test
    @DisplayName("When Create a Person With Success, Should Contains Email In Returned Person Object")
    void testCreatePerson_WhenSuccess_ShouldContainsEmailInReturnedPersonObject() {
        // When / Act- Inicia a execução do cenário.
        Person actual = service.createPerson(person);

        // Then / Assert - Avaliação do resultado, verifica se corresponde ao esperado.
        assertEquals(person.getEmail(), actual.getEmail(),
                () -> "The email is different!");
    }

    @Order(3)
    @Test
    @DisplayName("When Create a Person With Success, Should Valid Fields In Returned Person Object")
    void testCreatePerson_WhenSuccess_ShouldContainsFieldsInReturnedPersonObject() {
        // When / Act- Inicia a execução do cenário.
        Person actual = service.createPerson(person);

        // Then / Assert - Avaliação do resultado, verifica se corresponde ao esperado.
        assertEquals(person.getAge(), actual.getAge(), () -> "The age is different");
        assertNotNull(person.getId(), () -> "The id is null");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is different");
        assertEquals(person.getGender(), actual.getGender(), () -> "The gender is different");
        assertEquals(person.getName(), actual.getName(), () -> "The name is different");
    }
}
