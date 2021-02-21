package fr.topaidi.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    
    private String description;
    
    private String image;
    
    private Date createdAt;
    
    private int top;
    
    private int flop;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    
    @OneToOne
    private Category category;
    
    public Long getId() {
		return id;
	}

	public void setNom(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getFlop() {
		return flop;
	}

	public void setFlop(int flop) {
		this.flop = flop;
	}

	public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Users getUser() {
        return user;
    }
    
    public void setUser(Users user) {
        this.user = user;
    }
    
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getSubDescription() {
    	return this.description.substring(0,100) + "...";
    }
    
}