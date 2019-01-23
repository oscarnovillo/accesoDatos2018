/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.function.Consumer;
import org.bson.Document;

/**
 *
 * @author oscar
 */
public class Main {

    
    
    // Fetch all the documents from the mongo collection.

    private static void getAllDocuments(MongoCollection<Document> col) {

        
 

        // Performing a read operation on the collection.

        FindIterable<Document> fi = col.find();

        MongoCursor<Document> cursor = fi.iterator();

        try {

            while(cursor.hasNext()) {

                System.out.println(cursor.next().toJson());

          }

        } finally {

            cursor.close();

        }

    }

 

    
    
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://oscar:YIpRRecZrUoOLmFX@cluster0-w4glh.mongodb.net/test?retryWrites=true"));
        
        mongoClient.listDatabaseNames()
                .forEach((Consumer<String>) System.out::println);
        
        
        MongoDatabase db = mongoClient.getDatabase("Test");
        
        MongoCollection<Document> coll = db.getCollection("test");

        getAllDocuments(coll);

        db.listCollectionNames().forEach((Consumer<String>) System.out::println);
    }

}
