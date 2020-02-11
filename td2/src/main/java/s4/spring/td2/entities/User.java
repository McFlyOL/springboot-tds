package s4.spring.td2.entities;
 
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
 
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String suspended;

    @ManyToOne
    private Organization organization;

    @ManyToMany(mappedBy="users")
    private List<Groupe> groupes;


    public User() {
    }

    public User(int id, String firstname, String lastname, String email, String password, String suspended, Organization organization, List<Groupe> groupes) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.suspended = suspended;
        this.organization = organization;
        this.groupes = groupes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSuspended() {
        return this.suspended;
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Groupe> getGroupes() {
        return this.groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public User lastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User suspended(String suspended) {
        this.suspended = suspended;
        return this;
    }

    public User organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public User groupes(List<Groupe> groupes) {
        this.groupes = groupes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(suspended, user.suspended) && Objects.equals(organization, user.organization) && Objects.equals(groupes, user.groupes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password, suspended, organization, groupes);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", suspended='" + getSuspended() + "'" +
            ", organization='" + getOrganization() + "'" +
            ", groupes='" + getGroupes() + "'" +
            "}";
    }

}