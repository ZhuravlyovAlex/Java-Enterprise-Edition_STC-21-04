package lesson03.task03.model;

import lesson03.task03.PersonArrayList;
import lesson03.task03.PersonGeneratorWithBubbleSort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonListTest {
    private PersonArrayList personArrayList;

    @Before
    public void setUp() throws Exception {
        personArrayList = new PersonArrayList();
        for (int i = 0; i < 100; i++) {
            personArrayList.add(new Person(30, Sex.MAN,"Борис"));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, personArrayList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(personArrayList.removeAt(5));
        assertEquals(99, personArrayList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Person person = new Person(30, Sex.MAN, "Борис");
        personArrayList.add(person);
        assertEquals(101, personArrayList.size());
        assertTrue(personArrayList.remove(person));
        assertEquals(100, personArrayList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Person person = new Person(30,Sex.MAN,"Aндрей");
        assertFalse(personArrayList.remove(person));
        assertEquals(100, personArrayList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        personArrayList.clear();
        assertEquals(0, personArrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        personArrayList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Person person = personArrayList.get(0);
        assertEquals("Борис", person.getName());
    }
}