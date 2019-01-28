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


public class Purchase {


    

    private int iditem;
    private String nombreitem;

    public Purchase(int iditem, String nombreitem, LocalDate date) {
        this.iditem = iditem;
        this.nombreitem = nombreitem;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" + "iditem=" + iditem + ", nombreitem=" + nombreitem + ", date=" + date + '}';
    }
    private LocalDate date;

    public Purchase() {
    }
    
    
    
    
    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getNombreitem() {
        return nombreitem;
    }

    public void setNombreitem(String nombreitem) {
        this.nombreitem = nombreitem;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

   
}
