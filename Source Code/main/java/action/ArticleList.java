package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ArticlDao;
import entity.Article;
import metier.ArticleM;
import util.HibernateUtil;

public class ArticleList extends ActionSupport implements SessionAware, ModelDriven {
private Article art=new Article();
private List<ArticleM> ArticleList=new ArrayList<ArticleM>();
private Map<String, Object> session;
SessionFactory sessionFactory;



public Article getArt() {
	return art;
}
public void setArt(Article art) {
	this.art = art;
}
public List<ArticleM> getArticleList() {
	return ArticleList;
}
public void setArticleList(List<ArticleM> articleList) {
	ArticleList = articleList;
}


//Fonction pour lister les articles dans la page articles
public String listArticles()
{
	if (session.get("user") == null) {
        return "403";
    }
	
	  sessionFactory=HibernateUtil.getSessionFactory();
	  ArticlDao ArtL = new  ArticlDao(sessionFactory);
      List<Article> ArtList=ArtL.getAllArticles();
      ArtList.forEach(al->{
    	  Configuration cfg=new Configuration();
		    cfg.configure("gstock.cfg.xml");
		SessionFactory sessionFactoryS = cfg.buildSessionFactory();
		ArticlDao ArtS = new  ArticlDao(sessionFactoryS);
		int q=ArtS.getQtebyCode(al.getCodeArt());
    	  ArticleM am=new ArticleM(al.getCodeArt(),al.getNomArt(),al.getDescArt(),al.getPrixArt(),q,al.getImage());
    	  ArticleList.add(am);
      });
      return SUCCESS;
}


//fonction qui retourne Article dans la page ArticlePage
public String viewArticle()
{
	if (session.get("user") == null) {
        return "403";
    }
	sessionFactory=HibernateUtil.getSessionFactory();
	ArticlDao ArtL = new  ArticlDao(sessionFactory);
	Article a=ArtL.getArtbyCode(art.getCodeArt());
	 Configuration cfg=new Configuration();
	    cfg.configure("gstock.cfg.xml");
	SessionFactory sessionFactoryS = cfg.buildSessionFactory();
	ArticlDao ArtS = new  ArticlDao(sessionFactoryS);
	int q=ArtS.getQtebyCode(a.getCodeArt());
	 ArticleM am=new ArticleM(a.getCodeArt(),a.getNomArt(),a.getDescArt(),a.getPrixArt(),q,a.getImage()	);
	 ArticleList.add(am);
	return SUCCESS;
}

public Article getModel() {
    return art;
}


public void setSession(Map<String, Object> map) {
    session = map;
}
}
