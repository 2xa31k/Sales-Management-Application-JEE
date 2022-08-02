package entity;

import javax.persistence.*;


@Entity
@Table(name = "user",catalog="gvente")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable = false, nullable = false)
    private Integer id;
	@Column(name="username")
    private String username;
	@Column(name="email")
    private String email;
	@Column(name="password")
    private String password;

	
	//Getter et Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

}