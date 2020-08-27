package testgroup.phoneBook.dao;

import testgroup.phoneBook.model.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> allContacts();
    List<Contact> searchContacts(String keyword);
    void add(Contact contact);
    void delete(Contact contact);
    void edit(Contact contact);
    Contact getById(int id);
}
