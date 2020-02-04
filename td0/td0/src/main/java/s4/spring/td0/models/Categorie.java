package s4.spring.td0.models;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private String libelle;
    private ArrayList<Element> list_items;

    public Categorie(String libelle)
    {
        this.libelle = libelle;
        list_items = new ArrayList<Element>();
    }

    public boolean equals(String nom)
    {
        if(this.libelle.equals(nom))
            return true;
        else
            return false;
    }

    public String getLibelle()
    {
        return this.libelle;
    }

    public List<Element> getList()
    {
        return list_items;
    }

    public void ajouter(Element element)
    {
        list_items.add(element);
    }

    public void delete(Element element)
    {
        list_items.remove(element);
    }

    public Element getElement(String nom)
    {
        for (Element element : list_items) {
            if(element.equals(nom))
                return element;
        }
        return null;
    }


}