package s4.spring.td0.models;

public class Element{
    private String nom;
    private int evaluation;
    
    public Element(String nom, int evaluation){
        this.nom=nom;
        this.evaluation=evaluation;
    }
    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public int getEvaluation(){
        return this.evaluation;
    }

    public void setEvaluation(int evaluation){
        this.evaluation=evaluation;
    }

    public boolean equals(String nom)
    {
        if(this.nom.equals(nom))
            return true;
        else
            return false;
    }

    
}