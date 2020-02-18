package s4.spring.td3.entities;
 
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
    private String name;
    private String domain;
    private String aliases;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="organization")
    private List<Groupe> groupes;

    private String organizationsettings;

    public Organization(){
        
    }
    public Organization( String nom,  String domaine,  String alias)
    {
        this.name = nom;
        this.domain = domaine;
        this.aliases = alias;
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

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAliases() {
        return this.aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public List<Groupe> getGroupes() {
        return this.groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public String getOrganizationsettings() {
        return this.organizationsettings;
    }

    public void setOrganizationsettings(String organizationsettings) {
        this.organizationsettings = organizationsettings;
    }

    public Organization id(int id) {
        this.id = id;
        return this;
    }

    public Organization name(String name) {
        this.name = name;
        return this;
    }

    public Organization domain(String domain) {
        this.domain = domain;
        return this;
    }

    public Organization aliases(String aliases) {
        this.aliases = aliases;
        return this;
    }

    public Organization groupes(List<Groupe> groupes) {
        this.groupes = groupes;
        return this;
    }

    public Organization organizationsettings(String organizationsettings) {
        this.organizationsettings = organizationsettings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) o;
        return id == organization.id && Objects.equals(name, organization.name) && Objects.equals(domain, organization.domain) && Objects.equals(aliases, organization.aliases) && Objects.equals(groupes, organization.groupes) && Objects.equals(organizationsettings, organization.organizationsettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, domain, aliases, groupes, organizationsettings);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", domain='" + getDomain() + "'" +
            ", aliases='" + getAliases() + "'" +
            ", groupes='" + getGroupes() + "'" +
            ", organizationsettings='" + getOrganizationsettings() + "'" +
            "}";
    }

}