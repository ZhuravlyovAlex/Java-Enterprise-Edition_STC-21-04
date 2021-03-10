package lesson03.task03.model;

import lesson03.task03.PersonGeneratorWithBubbleSort;
import lesson03.task03.PersonLinkedList;
import lesson03.task03.PersonList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonListTest {
    private PersonList personList;

    @Before
    public void setUp() throws Exception {
        personList = new PersonGeneratorWithBubbleSort(); //new PersonLinkedList();
        for (int i = 0; i < 100; i++) {
            personList.add(new Person(30, Sex.MAN,"Борис"));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, personList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(personList.removeAt(5));
        assertEquals(99, personList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Person person = new Person(30, Sex.MAN, "Борис");
        personList.add(person);
        assertEquals(101, personList.size());
        assertTrue(personList.remove(person));
        assertEquals(100, personList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Person person = new Person(30,Sex.WOMAN, "Борис");
        assertFalse(personList.remove(person));
        assertEquals(100, personList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        personList.clear();
        assertEquals(0, personList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        personList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Person person = personList.get(0);
        assertEquals("Борис", person.getName());
    }
}