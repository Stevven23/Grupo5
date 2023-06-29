/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.farmsystem.controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import ec.edu.espe.farmsystem.model.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author PabloEZurita
 */
public class BookController {
    private static String uri = "mongodb+srv://pzurita:pzurita@cluster0.ohfzkul.mongodb.net/?retryWrites=true&w=majority";
    
    public static ArrayList<Book> listOfBooks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void addBook(){
        System.out.println("Enter the data of Book:");
        System.out.println("Id: ");
        int id = checkEnteredData();
        System.out.println("Title: ");
        String title = scanner.next();
        System.out.println("Author: ");
        String author = scanner.next();
        System.out.println("Date of publication");
        String dateOfPublication = scanner.next();
        Book book = new Book(id, title, author, dateOfPublication);
        listOfBooks.add(book);
        
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Farm");
            MongoCollection<Document> collection = database.getCollection("Books");
            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", id)
                        .append("title", title)
                        .append("author", author)
                        .append("date of publication", dateOfPublication));
                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
        
    }
    
    public static void updateBook(){
        if (listOfBooks.isEmpty()) {
            System.out.println("No registration books");
        } 
        else {
           System.out.println("Enter the id of book: ");
            int idBook = checkEnteredData()-1;

            if (idBook >= 0 && idBook < listOfBooks.size()) {
                System.out.println("Enter the new data of book: ");
                System.out.println("Title: ");
                String title = scanner.next();
                System.out.println("Author: ");
                String author = scanner.next();
                System.out.println("Date of publication");
                String dateOfPublication = scanner.next();
                Book book = new Book(idBook, title, author, dateOfPublication);
                listOfBooks.add(book);
                System.out.println("Book modify correctly");
            }   
            else {
                System.out.println("Incorrect ID");
            }
        }
    }
    
    public static void showBook(){
        if (listOfBooks.isEmpty()) {
            System.out.println("No registration books");
        } 
        else {
            System.out.println("List of Books");
            for (int i = 0; i < listOfBooks.size(); i++) {
                System.out.println(i+1 + ": " + listOfBooks.get(i));
            }
        }
    }
    
    public static void deletBook(){
        if (listOfBooks.isEmpty()) {
            System.out.println("No registration books");
        } 
        else {
           System.out.println("Enter the id of book: ");
            int idBook = checkEnteredData()-1;

            if (idBook >= 0 && idBook < listOfBooks.size()) {
                listOfBooks.remove(idBook);
                System.out.println("Delet book correctly");
            }   
            else {
            System.out.println("Incorrect ID");
            }
        }
    }
    
    private static int checkEnteredData() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine(); 
                System.out.println("Enter a valid integer number");
            }
        }
    }
}
