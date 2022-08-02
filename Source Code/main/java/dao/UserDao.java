package dao;

import entity.User;
import metier.UserSignUp;
import util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Optional;
public class UserDao {
    private SessionFactory sessionFactory;
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    //Fonction retourne User depuis email et mot de passe
    public Optional<User> getUserByCredentials(String email, String password) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from User where email = :email and password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        User user = (User) q.uniqueResult();
        if (user != null) {
        	System.out.println("username and password are valid");
            tx.commit();
            session.close();
        }
        return Optional.ofNullable(user);
    }

    // fonction pour enregistrer nouveau user
    public void save(User user) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    //Fonction pour verifier si user est deja existe
    public boolean contains(UserSignUp up) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from User where username = :username OR email = :email ");
        q.setParameter("username", up.getUsername());
        q.setParameter("email", up.getEmail());
        User userDb = (User) q.uniqueResult();
        if (userDb != null) {
            tx.commit();
            session.close();
            return true;
        }
        return false;
    }


    //fonction qui retourne User depuis email
    public User getUserByLogin(String email) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from User where email = :email");
        q.setParameter("email", email);
        User user = (User) q.uniqueResult();
        if (user != null) {
            tx.commit();
            session.close();
        }
        return user;
    }
    
    
  //fonction qui retourne User depuis id
    public User getUserById(int id) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from User where id = :id");
        q.setParameter("id", id);
        User user = (User) q.uniqueResult();
        if (user != null) {
            tx.commit();
            session.close();
        }
        return user;
    }

    
  //fonction qui fait mise a jour a les information de user
    public void update(User user) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }
}
