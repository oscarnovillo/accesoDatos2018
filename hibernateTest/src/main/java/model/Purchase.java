/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "Purchases")
public class Purchase {

    @Id
    @GeneratedValue
    private int idPurchase;
    private int idCustomer;
    @JoinColumn(name = "idItem", referencedColumnName = "idItem", insertable = false, updatable = false)
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Item item;

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
      

    private int idItem; 
    
    private LocalDate date;

    public Purchase() {
    }

    public Purchase(int idPurchase, int idCustomer, int idItem, LocalDate date) {
        this.idPurchase = idPurchase;
        this.idCustomer = idCustomer;
        this.idItem = idItem;
        this.date = date;
    }

    public Purchase(int customer, int item, LocalDate date) {
        this(0, customer, item, date);
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int customer) {
        this.idCustomer = customer;
    }

    public int getIdItem() {
        return this.idItem;
    }

    public void setIdItem(int item) {
        this.idItem = item;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID: " + idPurchase + "  Customer: " + idCustomer + "  Item: " +idItem+  "  Date: " + date;
    }

    public String toStringForClientInfo() {
        return "ID: " + idPurchase + "  Item: " +   "  Date: " + date + "\n";
    }

    public String toStringTexto() {
        return idPurchase + ";" + idCustomer + ";" +   ";" + date;
    }
}
