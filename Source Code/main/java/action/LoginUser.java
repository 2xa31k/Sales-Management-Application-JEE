package action;


import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDao;
import entity.User;
import util.HibernateUtil;

import java.util.Map;
import java.util.Optional;

public class LoginUser extends ActionSupport implements   ModelDriven<User>,SessionAware {

    private User user = new User();

    private Map<String, Object> session;
    SessionFactory sessionFactory;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //Fonction qui permet l'utilisateur a se connecter
    public String loginU() {
    	
        sessionFactory=HibernateUtil.getSessionFactory();
        UserDao userD = new UserDao(sessionFactory);
        Optional<User> userOpt = userD.getUserByCredentials(user.getEmail(), user.getPassword());
        if(!userOpt.isPresent()) {
        	addFieldError("Error", "Email/MotDePass Combination erreur");
        	return SUCCESS;
        }
        else {
            User userDb = userOpt.get();
            session.put("user", userOpt.get());
            user.setId(userDb.getId());
            user.setUsername(userDb.getUsername());
            user.setEmail(userDb.getEmail());
            return LOGIN;
        }
    	
    }
       
    //Fonction de deconnexion
    public String logout() {
    	if (session.containsKey("user"))
        session.remove("user");

        return "logout";
    }

    @Override
    public User getModel() {
        return user;
    }

    public Map<String, Object> getSessionMap() {
        return session;
    }

    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
