package s4.spring.evaluation.models;

import javax.persistence.*;

import java.util.Date;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private Date date;
    private String content;
    private String comment;

    public Script getScript() {
		return script;
    }
    
	public void setScript(Script script) {
		this.script = script;
    }
    
	@ManyToOne(targetEntity = Script.class)
    private Script script;
    
	public int getId() {
		return id;
    }
    
	public void setId(int id) {
		this.id = id;
    }
    
	public Date getDate() {
		return date;
    }
    
	public void setDate(Date date) {
		this.date = date;
    }
    
	public String getContent() {
		return content;
    }
    
	public void setContent(String content) {
		this.content = content;
    }
    
	public String getComment() {
		return comment;
    }
    
	public void setComment(String comment) {
		this.comment = comment;
	}

}