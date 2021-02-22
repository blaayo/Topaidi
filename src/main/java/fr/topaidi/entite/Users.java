package fr.topaidi.entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String fName;
    private String lName;
    private String password;
    private Date createdAt = new Date();

    
    @OneToMany(mappedBy = "user")
    private List<Commentaires> commentaires = new ArrayList<Commentaires>();
    
    @OneToMany(mappedBy = "user")
    private List<Idea> idees = new ArrayList<Idea>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    public String getNom() {
        return fName + ' ' + lName;
    }

    public void setNom(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

    public Date getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}