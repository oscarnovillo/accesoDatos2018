/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "Items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;
    private String name;
    private String company;
    private double price;
    @JoinColumn(name = "idItem", referencedColumnName = "idItem", insertable = false, updatable = false)
    @OneToMany(fetch=FetchType.EAGER)
    private Set<Purchase> purchases;

    
    
    public Item() {
    }

    public Item(int idItem, String name, String company, double price) {
        this.idItem = idItem;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public Item(String name, String company, double price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return idItem + " " + name + " " + price + "€";
    }
    
    public String toStringTextFile() {
        return idItem + ";" + name + ";" + company + ";" + price;
    }

    public String toStringVisual() {
        return "ID: " + idItem + "  Name: " + name + "  Company: " + company + " Price: " + price;
    }

}
