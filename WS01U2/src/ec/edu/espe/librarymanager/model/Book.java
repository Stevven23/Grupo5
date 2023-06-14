
package ec.edu.espe.librarymanager.model;

import java.io.Serializable;

/**
 *
 * @author Oswaldo Tipan
 */
public class Book implements Serializable {
    
    private int id;
    private int publicationYear;
    private String title;
    private String author;
    private String editorial;
    private String publicationCity;
    
    public Book(int id, int publicationYear, String title, String author, String editorial, String publicationCity){
        this.id = id;
        this.publicationYear = publicationYear;
        this.editorial = editorial;
        this.author = author;
        this.title = title;
        this.publicationCity = publicationCity;
    }
    public void displayBookDetails() {
        System.out.println("Book Details:");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Editorial: " + editorial);
        System.out.println("Publication City: " + publicationCity);
    }
    
    public int getId(){
        return id;
    }
  
    public int getpublicationYear(){
        return publicationYear;
    }
    
    public String getTittle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getEditorial(){
        return editorial;
    }
    
    public String getPublicationCity(){
        return publicationCity;
    }
}
