package s4.spring.evaluation.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;

	@OneToMany
	private List<Script> scripts;
	
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
	
	public Category() {
		scripts=new ArrayList<>();
	}


}