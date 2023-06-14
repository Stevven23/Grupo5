/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.librarymanager.model;

import java.io.Serializable;

/**
 *
 * @author Oswaldo Tipan
 */
public class Book implements Serializable {
    
    public static int id;
    public static int publicationYear;
    public static String title;
    public static String author;
    public static String editorial;
    public static String publicationCity;
    
    public static void Book(int id, int publicationYear, String title, String author, String editorial, String publicationCity){
        Book.id = id;
        Book.publicationYear = publicationYear;
        Book.editorial = editorial;
        Book.author = author;
        Book.title = title;
        Book.publicationCity = publicationCity;
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
