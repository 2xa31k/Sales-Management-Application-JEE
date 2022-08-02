package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Command;

public class CommandDao {
	private SessionFactory sessionFactory;
	//Constructeur avec Session FActory comme Paramatre

    public CommandDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    //Fonction pour avoir tous les commandes 
    public List<Command> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Command> commandes = session.createQuery("from Command").list();
        tx.commit();
        session.close();
        return commandes;
    }

    // Fonction pour sauvgarder la commande
    public void save(Command commande) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(commande);
        tx.commit();
        session.close();
    }
    
    
    //Fonction pour supprimer commande
    public void delete(Command commande) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(commande);
        tx.commit();
        session.close();
    }
    
    
	//Fonction pour supprimer tous les commandes
    public void deleteAll()
    {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from Command").executeUpdate();
        tx.commit();
        session.close();
    }
    
    
    //Fontion retourne Commande depuis le code
    public Command getCmdbyCode(Integer code) {
    	Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Command where codeCmd = :code");
        q.setParameter("code", code);
       Command c = (Command) q.uniqueResult();
        if (c != null) {
            tx.commit();
            session.close();
        }
        return c;
    }
}
