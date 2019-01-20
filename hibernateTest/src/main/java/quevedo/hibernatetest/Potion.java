/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.hibernatetest;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author oscar
 */
@Entity
@Table(name = "potions")
@NamedQueries({
  @NamedQuery(name = "Potion.findAll", query = "SELECT p FROM Potion p")
  , @NamedQuery(name = "Potion.findById", query = "SELECT p FROM Potion p WHERE p.id = :id ")
  , @NamedQuery(name = "Potion.findByName", query = "SELECT p FROM Potion p WHERE p.name = :name")
  , @NamedQuery(name = "Potion.findByDescription", query = "SELECT p FROM Potion p WHERE p.description = :description")
  , @NamedQuery(name = "Potion.findByCreationDate", query = "SELECT p FROM Potion p WHERE p.creationDate = :creationDate")
  , @NamedQuery(name = "Potion.findByNumberIngredients", query = "SELECT p FROM Potion p WHERE p.numberIngredients = :numberIngredients")})
public class Potion implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  
  @Column(name = "description")
  private String description;
  @Basic(optional = false)
  
  @Column(name = "creation_date")
  
  
  private LocalDate creationDate;
  @Basic(optional = false)
 
  @Column(name = "number_ingredients")
  private int numberIngredients;
  @OneToMany( mappedBy = "potion")
  private Set<IngredientPotion> ingredientPotionSet;

  public Potion() {
  }

  public Potion(Integer id) {
    this.id = id;
  }

  public Potion(Integer id, String name, String description, LocalDate creationDate, int numberIngredients) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.creationDate = creationDate;
    this.numberIngredients = numberIngredients;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public int getNumberIngredients() {
    return numberIngredients;
  }

  public void setNumberIngredients(int numberIngredients) {
    this.numberIngredients = numberIngredients;
  }

  public Set<IngredientPotion> getIngredientPotionSet() {
    return ingredientPotionSet;
  }

  public void setIngredientPotionSet(Set<IngredientPotion> ingredientPotionSet) {
    this.ingredientPotionSet = ingredientPotionSet;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Potion)) {
      return false;
    }
    Potion other = (Potion) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "quevedo.hibernatetest.Potion[ id=" + id + creationDate+" ]";
  }
  
}
