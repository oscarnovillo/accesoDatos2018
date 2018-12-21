/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.hibernatetest;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "ingredients")
@NamedQueries({
  @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
  , @NamedQuery(name = "Ingredient.findById", query = "SELECT i FROM Ingredient i WHERE i.id = :id")
  , @NamedQuery(name = "Ingredient.findByName", query = "SELECT i FROM Ingredient i WHERE i.name = :name")
  , @NamedQuery(name = "Ingredient.findByDescription", query = "SELECT i FROM Ingredient i WHERE i.description = :description")})
public class Ingredient implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "description")
  private String description;
  @OneToMany( mappedBy = "ingredient")
  private Set<IngredientPotion> ingredientPotionSet;

  public Ingredient() {
  }

  public Ingredient(Integer id) {
    this.id = id;
  }

  public Ingredient(Integer id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
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
    if (!(object instanceof Ingredient)) {
      return false;
    }
    Ingredient other = (Ingredient) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "quevedo.hibernatetest.Ingredient[ id=" + id + " ]";
  }
  
}
