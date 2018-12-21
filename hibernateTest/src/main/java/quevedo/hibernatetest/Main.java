/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.hibernatetest;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

/**
 *
 * @author oscar
 */
public class Main {

  public static void main(String[] args) {

    Ingredient i = getIngredient(13);
    borrarIngrediente(i);
  }

  private static Ingredient getIngredient(int id) {
    // Create session
    Session session = HibernateUtil.getSessionFactory().openSession();
    // Open session
    session.beginTransaction();

    Ingredient i = session.get(Ingredient.class, id);
    
    // Commit
    session.getTransaction().commit();

    session.close();
    return i;
  }

  private static void borrarIngrediente(Ingredient i) {

    // Create session
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      // Open session
      session.beginTransaction();

      session.delete(i);
      // Commit
      session.getTransaction().commit();

    } catch (ConstraintViolationException e) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      session.close();
    }

  }

  
  
  private static void borrarPotion() {

    // Create session
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      // Open session
      session.beginTransaction();
      Potion po = session.get(Potion.class,51);
      
      for (IngredientPotion ip:po.getIngredientPotionSet())
          session.delete(ip);
      
      session.delete(po);
      // Commit
      session.getTransaction().commit();

    } catch (ConstraintViolationException e) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
    } finally {
      session.close();
    }

  }

  private static void addEntityAlone() {
    Potion po = new Potion(1,"jj", "fff", new Date(), 0);

    // Create session
    Session session = HibernateUtil.getSessionFactory().openSession();
    // Open session
    session.beginTransaction();
    // Save employee
    session.save(po);
    // Commit
    session.getTransaction().commit();

    session.close();
    System.out.println("Potion Id =" + po.getId());
  }

  private static void addNuevoNM() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.getTransaction().begin();
      Potion po = session.get(Potion.class, 51);
      Ingredient i = session.get(Ingredient.class, 10);
      IngredientPotionPK id = new IngredientPotionPK(i.getId(), po.getId());
      IngredientPotion ip = new IngredientPotion(id, 20, "FFF", 2, 1);
      po.setNumberIngredients(po.getNumberIngredients() + 1);
      session.update(po);
      session.save(ip);
      session.getTransaction().commit();
    } catch (Exception e) {
      session.getTransaction().rollback();
      System.out.println(e);

    } finally {
      session.close();
    }
  }

  private static void getById() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    // Open session
    session.beginTransaction();
    //XXX begin();

    // con load es LAZY, con get EAGER
    Potion potion = session.get(Potion.class, 6);

    // Commit
    session.getTransaction().commit();
    session.close();
    System.out.println(potion.getName());
  }

  private static void selectAll() {
    // select *
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Potions");
    //query.setParameter("id", "255");
    List<Potion> list = query.list();
    list.forEach((p) -> {
      System.out.println(p);
    });
    session.close();
  }

  private static void salvarNuevoElemento() {
    Potion po = new Potion(1,"Lucia", "fff", new Date(), 0);
    Ingredient i = new Ingredient(1,"pelo murcielado", "largito mejpr");
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.getTransaction().begin();
      session.save(i);
      session.save(po);
      IngredientPotionPK id = new IngredientPotionPK(i.getId(), po.getId());
      IngredientPotion ip = new IngredientPotion(id, 20, "FFF", 1, 1);
      po.setNumberIngredients(po.getNumberIngredients() + 1);
      session.update(po);
      session.save(ip);
      session.getTransaction().commit();
    } catch (Exception e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
  }

}