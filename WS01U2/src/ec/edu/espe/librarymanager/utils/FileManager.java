
package ec.edu.espe.librarymanager.utils;

import ec.edu.espe.librarymanager.model.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Oswaldo Tipan
 */
public class FileManager {
    
    public static ArrayList<Object> bookArrayList = new ArrayList<>();
    
    
    public static void askForData() throws IOException{
        
        Scanner dataIn = new Scanner(System.in);
        
        System.out.println("Insert the id of the Book: ");
        int id = dataIn.nextInt();
        dataIn.nextLine();
        System.out.println("Insert the Title of the Book: ");
        String title = dataIn.nextLine();
        System.out.println("Insert the Author of the Book: ");
        String author = dataIn.next();
        System.out.println("Insert the Publication Year of the Book: ");
        int publicationYear = dataIn.nextInt();
        System.out.println("Insert the Editorial of the Book: ");
        String editorial = dataIn.next();
        System.out.println("Insert the Publication City of the Book: ");
        String publicationCity = dataIn.next();
        
        addBook(id, publicationYear, title, author, editorial, publicationCity);
        
    }
    
    public static void addBook(int id, int publicationYear, String title, String author, String editorial, String publicationCity) throws IOException{
        
        Book book = new Book(id, publicationYear, title, author, editorial, publicationCity);
        bookArrayList.add(book);
        
       try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("book.dat"))){
           outputStream.writeObject(bookArrayList);
          System.out.println("El objeto ha sido guardado en objecto.dat");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
    }
    
}
