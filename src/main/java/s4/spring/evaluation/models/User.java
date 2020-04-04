package s4.spring.evaluation.models;

import javax.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
	private List<Script> scripts;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String suspended;

    public User()
    {

    }

    public User(String name, String password, String email)
    {
        this.firstname=name;
        this.password=password;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSuspended() {
        return suspended;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }
}