package testgroup.phoneBook.service;

import testgroup.phoneBook.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> allContacts();
    List<Contact> searchContacts(String keyword);
    void add(Contact contact);
    void delete(Contact contact);
    void edit(Contact contact);
    Contact getById(int id);
}
