package s4.spring.evaluation.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

	private String name;
	
	@JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "language")
	private List<Script> scripts;

	public Language(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Script> getScripts() {
		return scripts;
	}

	public void setScripts(List<Script> scripts) {
		this.scripts = scripts;
	}

}