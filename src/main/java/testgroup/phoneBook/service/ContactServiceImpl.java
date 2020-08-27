package testgroup.phoneBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.phoneBook.dao.ContactDAO;
import testgroup.phoneBook.model.Contact;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactDAO contactDAO;

    @Autowired
    public void setContactDAO(ContactDAO contactDAO){
        this.contactDAO = contactDAO;
    }

    @Override
    @Transactional
    public List<Contact> allContacts() {
        return contactDAO.allContacts();
    }

    @Override
    @Transactional
    public List<Contact> searchContacts(String keyword) {
        return contactDAO.searchContacts(keyword);
    }

    @Override
    @Transactional
    public void add(Contact contact) {
        contactDAO.add(contact);
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        contactDAO.delete(contact);
    }

    @Override
    @Transactional
    public void edit(Contact contact) {
        contactDAO.edit(contact);
    }

    @Override
    @Transactional
    public Contact getById(int id) {
        return contactDAO.getById(id);
    }

}
