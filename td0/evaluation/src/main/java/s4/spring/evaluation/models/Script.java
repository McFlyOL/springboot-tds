package s4.spring.evaluation.models;

import javax.persistence.*;

import java.util.List;

@Entity
public class Script {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String title;
    private String description;
    private String content;
    private String creationDate;

    @ManyToOne(targetEntity = Language.class)
	private Language language;
	
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "script")
    private List<History> histories;
    
    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public Script() {
    }

    public Script(int id, String title, String description, String content, String creationDate, Language language, User user, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.creationDate = creationDate;
        this.language = language;
        this.user = user;
        this.category=category;
    }

    public Script(String title, String description, String content, String creationDate, Language language, User user, Category category) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.creationDate = creationDate;
        this.language = language;
        this.user = user;
        this.category=category;
    }

    public Script(String title, String description, String content, String creationDate) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.creationDate = creationDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<History> getHistories() {
        return this.histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public Script id(int id) {
        this.id = id;
        return this;
    }

    public Script title(String title) {
        this.title = title;
        return this;
    }

    public Script description(String description) {
        this.description = description;
        return this;
    }

    public Script content(String content) {
        this.content = content;
        return this;
    }

    public Script creationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Script language(Language language) {
        this.language = language;
        return this;
    }

    public Script user(User user) {
        this.user = user;
        return this;
    }

    public Script histories(List<History> histories) {
        this.histories = histories;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", content='" + getContent() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", language='" + getLanguage() + "'" +
            ", user='" + getUser() + "'" +
            ", histories='" + getHistories() + "'" +
            "}";
    }

    

}