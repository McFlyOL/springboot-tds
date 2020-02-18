package s4.spring.td3.entities;
 
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
 
@Entity
public class Groupe  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
    private String name;
    private String email;
    private String aliases;

    @ManyToOne
    private Organization organization;
    
    @ManyToMany
    @JoinTable(name = "user_group")
    private List<User> users;

    public Groupe() {
    }

    public Groupe(int id, String name, String email, String aliases, Organization organization, List<User> users) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.aliases = aliases;
        this.organization = organization;
        this.users = users;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAliases() {
        return this.aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Groupe id(int id) {
        this.id = id;
        return this;
    }

    public Groupe name(String name) {
        this.name = name;
        return this;
    }

    public Groupe email(String email) {
        this.email = email;
        return this;
    }

    public Groupe aliases(String aliases) {
        this.aliases = aliases;
        return this;
    }

    public Groupe organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Groupe users(List<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Groupe)) {
            return false;
        }
        Groupe groupe = (Groupe) o;
        return id == groupe.id && Objects.equals(name, groupe.name) && Objects.equals(email, groupe.email) && Objects.equals(aliases, groupe.aliases) && Objects.equals(organization, groupe.organization) && Objects.equals(users, groupe.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, aliases, organization, users);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", aliases='" + getAliases() + "'" +
            ", organization='" + getOrganization() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }
    
}