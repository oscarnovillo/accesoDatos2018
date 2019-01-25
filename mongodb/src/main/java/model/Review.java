/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author dam2
 */

public class Review implements Serializable {


    private int idReview;
    private int rating;
    private String title;
    private String description;
    private String date;

    private Purchase purchase;

    private int customerId;

    private int itemId;
    
    private int idPurchase;

    public Review() {
    }

    public Review(int idReview,int rating, String title, String description, int customerId, int itemId, int purchaseId) {
        this.idReview = idReview;
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.date = LocalDate.now().toString();
        this.customerId = customerId;
        this.itemId = itemId;
        this.idPurchase = purchaseId;
    }

    public Review(int idReview, int rating, String title, String description, String date, int purchaseId) {
        this.idReview = idReview;
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.date = date;
        this.idPurchase = purchaseId;
    }
    
    
    public Review(int rating, String title, String description, int customerId, int itemId, int purchaseId) {

        this.rating = rating;
        this.title = title;
        this.description = description;
        this.date = LocalDate.now().toString();
        this.customerId = customerId;
        this.itemId = itemId;
        this.idPurchase = purchaseId;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getItem() {
        return itemId;
    }

    public void setItem(int item) {
        this.itemId = item;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }
    
    

    @Override
    public String toString() {
        return "No. " + idReview + "\nRating: " + rating + "\nTitle: " + title + "\nComment: " + description + "\nDate: " + date + "  Purchase no. " + idPurchase;
    }

    public String toStringVisual() {
        return "No. " + idReview + "  Item: " + itemId + "  Rating: " + rating + "\nTitle: " + title + "\nComment: " + description + "\nDate: " + date + "\n____________________________________________________________\n";
    }

    public String toStringTexto() {
        return idReview + ":" + rating + ":" + title + ":" + description + ":" + date + ":" + customerId + ":" + itemId + ":" + idPurchase;
    }

}
