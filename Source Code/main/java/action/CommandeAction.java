package action;

import java.io.FileInputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ArticlDao;
import dao.CommandDao;
import entity.Article;
import entity.Article_stock;
import entity.Command;
import metier.ArticleM;
import util.HibernateUtil;

public class CommandeAction extends ActionSupport implements SessionAware, ModelDriven {
	 	private Command commande = new Command();
	    private List<Command> commandes = new ArrayList<>();
	    private Map<String, Object> session;
	    SessionFactory sessionFactory;
	    
	    public List<Command> getCommandes() {
	        return commandes;
	    }

	    public void setCommandes(List<Command> commandes) {
	        this.commandes = commandes;
	    }
	    
	  //fonction qui retourne la liste de commande dans la page Commands.jsp
	    public String listCommades()
	    {
	    	if (session.get("user") == null) {
	            return "403";
	        }
	    	
	    	  sessionFactory=HibernateUtil.getSessionFactory();
	    	  CommandDao CmdL = new  CommandDao(sessionFactory);
	          commandes=CmdL.findAll();
	          return SUCCESS;
	    }
	    
	  //fonction qui ajoute la commande depuis la page ArticlePage
	    public String addCommande() {
	    	if (session.get("user") == null) {
	            return "403";
	        }

	        sessionFactory = HibernateUtil.getSessionFactory();
	        long millis = System.currentTimeMillis();  
	        commande.setDateCmd(new Date(millis));
	        
	        CommandDao CmdD=new CommandDao(sessionFactory);
	        Configuration cfg=new Configuration();
	        cfg.configure("gstock.cfg.xml");
	    	SessionFactory sessionFactoryS = cfg.buildSessionFactory();
	    	ArticlDao ArtS = new  ArticlDao(sessionFactoryS);
	    	Article_stock aStock=ArtS.getArtStockbyCode(commande.getCodeArt());
	    	aStock.setQteArt(aStock.getQteArt()-commande.getQteCmd());
	        commande.setPrixTotal(aStock.getPrixArt()*commande.getQteCmd());
	    	CmdD.save(commande);
	    	ArtS.update(aStock);
	        
	        return SUCCESS;
	    }
	    
	    
	  //fonction qui supprimer la commande de page commands.jsp
	    public String deleteCmd() {
	    	if (session.get("user") == null) {
	            return "403";
	        }
	    	 sessionFactory = HibernateUtil.getSessionFactory();
	    	 CommandDao CmdD=new CommandDao(sessionFactory);
	    	 Command c=CmdD.getCmdbyCode(commande.getCodeCmd());
		        CmdD.delete(c);
		        return SUCCESS;
	    	
	    }
	    
	  //fonction qui supprimer tous les commandes dans la page commands.jsp
	    public String deleteAllCmd()
	    {
	    	if (session.get("user") == null) {
	            return "403";
	        }
	    	 sessionFactory = HibernateUtil.getSessionFactory();
	    	 CommandDao CmdD=new CommandDao(sessionFactory);
	    	 CmdD.deleteAll();
	    	 return SUCCESS;
	    }
	    
	   
	    public Command getModel() {
	        return commande;
	    }
	    public void setSession(Map<String, Object> map) {
	        this.session = map;
	    }

	    public Map<String, Object> getSessionMap() {
	        return session;
	    }
}
