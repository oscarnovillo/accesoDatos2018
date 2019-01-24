/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querys;

import dao.utilities.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import model.Purchase;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author oscar
 */
public class PruebaDates {
  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");

    
    Session session = HibernateUtil.getSessionFactory().openSession();
       Query  query = session.createQuery("from Purchase as p where p.date = :date");
       // query.setParameter("date2", LocalDate.of(2018,11,10));
      query.setParameter("date", LocalDateTime.of(2018,11,11,0,0,0));
        List<Purchase> lista2 = query.list();

        lista2 = query.list();
        lista2.forEach((p) -> {
            System.out.println(p);
        });

        session.close();
  }
  
}
