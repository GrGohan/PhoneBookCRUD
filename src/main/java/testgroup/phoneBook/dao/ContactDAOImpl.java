package testgroup.phoneBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.phoneBook.model.Contact;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Contact> allContacts() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Contact").list();
    }

    @Override
    public List<Contact> searchContacts(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Contact where name = :keyword or number = :keyword";
        Query query = session.createQuery(hql);
        query.setParameter("keyword", keyword);

        return query.list();
    }

    @Override
    public void add(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(contact);
    }

    @Override
    public void delete(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(contact);
    }

    @Override
    public void edit(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.update(contact);
    }

    @Override
    public Contact getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Contact.class, id);
    }
}

