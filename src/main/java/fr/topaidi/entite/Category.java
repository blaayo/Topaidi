package fr.topaidi.entite;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Idea> idees = new ArrayList<Idea>();
   
    public Long getId() {
        return id;
    }
   
    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }
}
