package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDao;
import entity.User;
import metier.UserSignUp;
import util.HibernateUtil;

public class UserUp extends ActionSupport implements ModelDriven,SessionAware{
	
	 private User user = new User();
	 private Map<String, Object> session;
	 private UserSignUp NewUser = new UserSignUp();
	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserSignUp getNewUser() {
		return NewUser;
	}

	public void setNewUser(UserSignUp newUser) {
		NewUser = newUser;
	}
	
	
	//Fonction de Enregistrer l'utilisateur
	public String execute() throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        UserDao userD = new UserDao(sessionFactory);

        if (NewUser.getUsername() == null || NewUser.getPassword() == null|| NewUser.getEmail() == null)
        {	
        	addFieldError("Vide", "Remplire tous les champs");
            return "fail";
        }

        if (NewUser.getPassword().equals(NewUser.getPasswordConfirm())) {
            user.setEmail(NewUser.getEmail());
            user.setUsername(NewUser.getUsername());
            user.setPassword(NewUser.getPassword());
            if (!userD.contains(NewUser)) {
                userD.save(user);
                return "newuser";
            }
            else {
            	addFieldError("Existe", "Username ou Email deja Existe");
            }
        }
        else addFieldError("password", "les mots de passe ne correspondent pas");
        return "fail";
    }
	
	//Fonction de modifier les information de user
	public String Modifier() {
		if (session.get("user") == null) {
            return "403";
        }
    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        UserDao userD = new UserDao(sessionFactory);
        	User userN = (User) session.get("user");
        	System.out.println(userN.getId());
        	userN.setEmail(NewUser.getEmail());
        	userN.setUsername(NewUser.getUsername());
        	userN.setPassword(NewUser.getPassword());
                userD.update(userN);        
            return SUCCESS;
        }
	
	
    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.session = sessionMap;
    }

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return NewUser;
	}

}
