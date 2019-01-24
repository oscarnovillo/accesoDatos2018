/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;


import dao.utilities.HibernateUtil;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.Month;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import model.Customer;
import model.Item;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import java.util.List;
import model.Purchase;
import model.Review;

/**
 *
 * @author oscar
 */
public class Main {

  public static void main(String[] args) {

    System.setProperty("log4j.configurationFile", "log4j2.xml");

    // Create session
    Session session = HibernateUtil.getSessionFactory().openSession();
    // Open session

    Customer i = session.get(Customer.class, 1);

    // Commit
    // session.getTransaction().commit();
    session.close();

    try {
      i.setIdCustomer(29);
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.delete(i);
      session.getTransaction().commit();
    } catch (PersistenceException e) {
      if (e.getCause() instanceof ConstraintViolationException ) {
        System.out.println("integriry");
      } else if (e instanceof OptimisticLockException) {
        System.out.println("No existe");
      } else {
        LoggerFactory.getLogger(Main.class).error(null, e);
      }
    } finally {
      session.close();
    }

    session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("delete from Customer where idCustomer = :id");
    query.setParameter("id", 1);
    try {
      session.beginTransaction();
      int filas = query.executeUpdate();
      System.out.println("filas borradas" + filas);
      session.getTransaction().commit();

    } catch (ConstraintViolationException e) {
      session.getTransaction().rollback();
      System.out.println("violacion de integriddad");
    } finally {
      session.close();
    }


    
i.setIdCustomer(1);
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createNativeQuery("select i.* from Items i inner join Purchases p on p.idItem = i.idItem where p.idCustomer = :id group by i.idItem").addEntity(Item.class);
        query.setParameter("id", i.getIdCustomer());

        List<Item> lista = query.list();
        lista.forEach((p) -> {
            System.out.println(p);
        });

        session.close();

        //Devolver varios objetos
     /*   session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("select i from Purchase as p inner join p.item as i where p.customer = :id and p.date < :date");
        query.setParameter("id", i.getIdCustomer());
        query.setParameter("date", LocalDate.now());

        List<Item> lista2 = query.list();

        lista2 = query.list();
        lista2.forEach((p) -> {
            System.out.println(p);
        });

        session.close();
       */
        
     session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery("from Purchase as p where p.date = :date");
        query.setParameter("date", LocalDate.of(2018,11,11));

        List<Purchase> lista2 = query.list();

        lista2 = query.list();
        lista2.forEach((p) -> {
            System.out.println(p);
        });

        session.close();
            
          session = HibernateUtil.getSessionFactory().openSession();
    // Open session

    Purchase p = session.get(Purchase.class, 1);

    // Commit
    // session.getTransaction().commit();
    
  //p.getItem().getName();
    
  //Item item = session.get(Item.class,p.getItem().getIdItem());  
        session.close();
        
        
        session = HibernateUtil.getSessionFactory().openSession();
        Item item = session.get(Item.class,p.getItem().getIdItem());  
        session.close();
    System.out.println(item);
        

        session = HibernateUtil.getSessionFactory().openSession();

        query = session.createQuery("from Review");

        List<Review> listar = query.list();
        listar.forEach((pi) -> {
            System.out.println(pi);
        });

        session.close();

        session = HibernateUtil.getSessionFactory().openSession();

        query = session.createQuery("delete from Review as r where r.purchase in (select idPurchase FROM Purchase p where p.customer.idCustomer = :id )");
        query.setParameter("id", 20);

        session.beginTransaction();

         int filas = query.executeUpdate();
        System.out.println(filas);
        session.getTransaction().commit();
        session.close();
     
  }
}
