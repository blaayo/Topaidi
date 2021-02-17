package fr.topaidi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "idea_id")
    private Idea idea;
    // 0 equals to flop and 1 equals to top
    private int vote;
    
    public Users getUser() {
        return user;
    }


    public void setUser(Users user) {
        this.user = user;
    }

 
    public Idea getIdea() {
        return idea;
    }
    
    public void setIdea(Idea idea) {
        this.idea = idea;
    }

 

    public int getVote() {
        return vote;
    }

 

    public void setVote(int vote) {
        this.vote = vote;
    }
}
