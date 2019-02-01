/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import model.Customer;
import model.DatabaseSequence;
import model.Purchase;
import model.TipoUsuario;
import org.bson.Document;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.query.Update.update;

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

      while (cursor.hasNext()) {

	System.out.println(cursor.next());

      }

    } finally {

      cursor.close();

    }

  }

  public static long generateSequence(String seqName, MongoTemplate mongo) {
    DatabaseSequence counter = mongo.findAndModify(query(where("_id").is(seqName)),
	    new Update().inc("seq", 1), options().returnNew(true).upsert(true),
	    DatabaseSequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : 5;
  }

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://oscar:YIpRRecZrUoOLmFX@cluster0-w4glh.mongodb.net/test?retryWrites=true"));

    for (String s :mongoClient.listDatabaseNames() )
    {
      System.out.println(s);
    }
    
    mongoClient.listDatabaseNames()
	    .forEach((Consumer<String>) System.out::println);

    MongoDatabase db = mongoClient.getDatabase("Test");
    MongoCollection<Document> col = db.getCollection("items");
    Iterator i = col.find().iterator();
    while (i.hasNext()) {
      Document d = (Document) i.next();
      if (null != d.get("date")) {
	LocalDateTime fecha = (
                (Date) d.get("date")).toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
	System.out.println(d.get("name") + " " + fecha);
      }
      if (null != d.get("clientes")) {
	ArrayList<Integer> sub = (ArrayList< Integer>) d.get("clientes");
	sub.get(0);
      }

    }

    Document d = new Document();
    d.put("name", "item2");
    d.put("company", "dfd S.A");
    d.put("price", "25.5");
    d.put("date", LocalDateTime.of(2000, Month.MARCH, 22, 10, 10, 0));
    List<Integer> clientes = new ArrayList<>();
    clientes.add(0);
    d.put("clientes", clientes);

    col.insertOne(d);

    Document buscar = new Document();
    buscar.put("name", "item2");
    Document update = new Document();
    update.put("name", "item2ggg");
    
    Document update1 = new Document();
    update1.put("$set", update);

    col.updateOne(buscar, update1);

    update = new Document();
    update.put("clientes", 9);

    update1 = new Document();
    update1.put("$push", update);

    col.updateMany(buscar, update1);

    getAllDocuments(col);

    /*
        
        
        System.out.println(" CON SPRING ");
        
        MongoTemplate mp = new MongoTemplate(mongoClient, "Test");
        Customer c = new Customer(generateSequence(Customer.SEQUENCE_NAME, mp), "jj", "kk", "llll","a,2,","u",TipoUsuario.USUARIO);
        Purchase p = new Purchase(1,"item", LocalDate.now());
        c.getPurchases().add(p);
        mp.insert(c);
        
          c = new Customer(generateSequence(Customer.SEQUENCE_NAME, mp), "", null, null,"a,2,","u",TipoUsuario.USUARIO);
         p = new Purchase(1,"item cito ", LocalDate.now());
        c.getPurchases().add(p);
        mp.insert(c);

        

        List<Customer> lista = mp.findAll(Customer.class);

        lista.forEach(System.out::println);

        lista = mp.find(query(where("idCustomer").gt(2)), Customer.class);
        lista.forEach(System.out::println);
        mp.updateMulti(query(where("idCustomer").is(2)), update("purchases.1._id",2), Customer.class);
       
//
       lista = mp.find(query(where("purchases.date").gt(LocalDate.of(2001,1,1))), Customer.class);
       
        lista.forEach(System.out::println);
//        lista.forEach(System.out::println);
//        c = mp.findOne(query(where("idCustomer").is(2)), Customer.class);
//        c.getPurchases().add(new Purchase(1,1,LocalDate.of(2000,1,1)));
//        mp.save(c);
//
//       lista = mp.findAll(Customer.class);
//
//        lista.forEach(System.out::println);


//        MongoRepository<Customer,String> repository = new SimpleMongoRepository<Customer,String>();
//        MongoCollection<Document> coll = db.getCollection("test");
//
//        getAllDocuments(coll);
//
//        db.listCollectionNames().forEach((Consumer<String>) System.out::println);
     */
  }

}
