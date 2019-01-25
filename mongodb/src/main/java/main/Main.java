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
import java.time.LocalDate;
import java.util.function.Consumer;
import model.Customer;
import model.CustomerRepository;
import model.Purchase;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

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
        
        MongoTemplate mp = new MongoTemplate(mongoClient,"Test" );
        Customer c = new Customer(4,"jj", "kk", "llll", 0);
        Purchase p = new Purchase(1,1,LocalDate.now());
        c.getPurchases().add(p);
        mp.insert(c);
        
        
        Customer c1 = mp.findById(2, Customer.class);
        
        System.out.println(c1);
        c1.getPurchases().forEach((Consumer<Purchase>) System.out::println);
        
//        MongoRepository<Customer,String> repository = new SimpleMongoRepository<Customer,String>();
        
//        MongoCollection<Document> coll = db.getCollection("test");
//
//        getAllDocuments(coll);
//
//        db.listCollectionNames().forEach((Consumer<String>) System.out::println);
    }

}
