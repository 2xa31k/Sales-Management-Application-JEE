package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Article;
import entity.Article_stock;
import entity.User;
import util.HibernateUtil;

public class ArticlDao {
	private SessionFactory sessionFactory;
	
	//Constructeur avec Session FActory comme Paramatre
	public ArticlDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	//Constructeur sans parametre
	public ArticlDao()
	{
	}
	
	//Fonction pour avoir tous  les articles depuis la BD
	public List<Article> getAllArticles(){
		Session ss=HibernateUtil.getSessionFactory().openSession();
		Transaction Tx=ss.beginTransaction();
		List<Article> art=ss.createQuery("from Article").list();
		Tx.commit();
		ss.close();
		return art;
	}
	
	//Fonction pour avoir Article depuis sa code
	 public Article getArtbyCode(Integer code) {
	    	Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        Query q = session.createQuery("from Article where codeArt = :code");
	        q.setParameter("code", code);
	       Article a = (Article) q.uniqueResult();
	        if (a != null) {
	            tx.commit();
	            session.close();
	        }
	        return a;
	    }
	 
	//Fonction pour avoir Article_stock depuis sa code
	 public Article_stock getArtStockbyCode(Integer code) {
	    	Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        Query q = session.createQuery("from Article_stock where codeArt = :code");
	        q.setParameter("code", code);
	        Article_stock a = ( Article_stock ) q.uniqueResult();
	        if (a != null) {
	            tx.commit();
	            session.close();
	        }
	        return a;
	    }
	 
	//Fonction pour avoir la quantite de l'Article
	 public int getQtebyCode(Integer code) {
	    	Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        Query q = session.createQuery("from Article_stock where codeArt = :code");
	        q.setParameter("code", code);
	       Article_stock a = ( Article_stock ) q.uniqueResult();
	        if (a != null) {
	            tx.commit();
	            session.close();
	        }
	        return a.getQteArt();
	    }
	 
	//Fonction pour faire mise a jour a l'article
	 public void update(Article_stock articleStock) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.update(articleStock);
	        tx.commit();
	        session.close();
	    }
}
