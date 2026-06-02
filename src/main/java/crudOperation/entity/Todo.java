package crudOperation.entity;
import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(nullable = false) empty todo will not allowed
    private String content;

    @ManyToOne
//    @OneToMany()
    @JoinColumn(name = "user_id")
    private AppUser user;

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Todo() {
    }

    public Todo(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
