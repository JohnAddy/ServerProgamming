package data;

 

import java.io.Serializable;

 

public class Answer implements Serializable{
    private int id;
    private String name;
    private int pages;
   
    public Answer() {
       
    }
    public Answer(String name, int pages) {
        this.name=name;
        this.pages=pages;
    }
    public Answer(String name, String pages) {
        this.name=name;
        this.setPages(pages);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id) {
        try {
            this.id = Integer.parseInt(id);
        }
        catch(NumberFormatException e) {
            this.id=0;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setPages(String pages) {
        try {
            this.pages = Integer.parseInt(pages);
        }
        catch(NumberFormatException e) {
            this.pages=0;
        }
    }
    public String toString() {
        return this.id+": "+this.name+"/"+this.pages;
    }
}