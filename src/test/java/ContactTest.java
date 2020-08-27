import org.junit.BeforeClass;
import org.junit.Test;
import testgroup.phoneBook.model.Contact;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ContactTest {
    private static Contact contact;

    @BeforeClass
    public static void createNewContact(){
        contact = new Contact();
    }

    @Test
    public void contactSetterOfNameShouldSetsProperly() throws NoSuchFieldException, IllegalAccessException {
        contact.setName("Name");
        Field field = contact.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Fields didn't match", field.get(contact), "Name");
    }

    @Test
    public void contactGetterOfNameShouldGetsValue() throws NoSuchFieldException, IllegalAccessException {
        Field field = contact.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(contact, "Name");
        String result = contact.getName();

        assertEquals("field wasn't retrieved properly", result, "Name");
    }

    @Test
    public void contactSetterOfNumberShouldSetsProperly() throws NoSuchFieldException, IllegalAccessException {
        contact.setNumber(1000);
        Field field = contact.getClass().getDeclaredField("number");
        field.setAccessible(true);

        assertEquals("Fields didn't match", field.get(contact), 1000l);
    }

    @Test
    public void contactGetterOfNumberShouldGetsValue() throws NoSuchFieldException, IllegalAccessException {
        Field field = contact.getClass().getDeclaredField("number");
        field.setAccessible(true);
        field.set(contact, 1000l);
        long result = contact.getNumber();

        assertEquals("field wasn't retrieved properly", result, 1000l);
    }
}
