/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author Laura
 */

@Document
public class Purchase {


    @Id
    private int idPurchase;


    private Customer customer;

    private int iditem;
    private String nombreitem;

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
      

   
    private LocalDate date;

    public Purchase() {
    }

    public Purchase(int idPurchase,  int idItem, LocalDate date) {
        this.idPurchase = idPurchase;
        
        
        this.date = date;
    }



    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

  

  

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID: " + idPurchase + "  Customer: " + "  Item: " +  "  Date: " + date;
    }

    public String toStringForClientInfo() {
        return "ID: " + idPurchase + "  Item: " +   "  Date: " + date + "\n";
    }

    public String toStringTexto() {
        return idPurchase + ";" + ";" +   ";" + date;
    }
}
