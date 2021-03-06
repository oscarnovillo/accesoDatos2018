/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author dam2
 */

@Document(collection = "customer")
public class Customer implements Serializable {

    
    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";
 
    
    @Id
    private long idCustomer;
    
    
    private String name;
    private String telephone;
    private String address;
    private String nombreuser;
    private String passwd;
    private TipoUsuario type;
    private Set<Purchase> purchases;

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }


    public Customer() {
        purchases = new HashSet<>();
    }

    public Customer(long idCustomer, String name, String telephone, String address, String nombreuser, String passwd, TipoUsuario type) {
        this();
        this.idCustomer = idCustomer;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.nombreuser = nombreuser;
        this.passwd = passwd;
        this.type = type;
    }

    
    
    public Customer(String name, String telephone, String address, String nombreuser, String passwd, TipoUsuario type) {
        this(0, name, telephone, address, nombreuser, passwd, type);
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public TipoUsuario getType() {
        return type;
    }

    public void setType(TipoUsuario type) {
        this.type = type;
    }


    
    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geTelephone() {
        return telephone;
    }

    public void setTelephone(String phone) {
        this.telephone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  

    public String toStringTexto() {
        return idCustomer + "/" + name + "/" + telephone + "/" + address;
    }

    @Override
    public String toString() {
        
        String text =  "ID: " + idCustomer + "  Name: " + name + "  Phone: " + telephone + "  Address: " + address+"purchases ";
         StringBuilder b = new StringBuilder();
            this.purchases.forEach(b::append);

        
        return text+b.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

}
