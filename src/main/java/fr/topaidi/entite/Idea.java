package fr.topaidi.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String description;
    private String image;
    private Date createdAt;
    
    @OneToOne
    private Category category;
    
    public Users getUser() {
        return user;
    }
    
    public void setUser(Users user) {
        this.user = user;
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

 

    public Date getCreatedAt() {
        return createdAt;
    }

 

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

 

    public Category getCategory() {
        return category;
    }

 

    public void setCategory(Category category) {
        this.category = category;
    }
}