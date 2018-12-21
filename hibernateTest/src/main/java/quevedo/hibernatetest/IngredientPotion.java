/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.hibernatetest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "ingredients_potions")
@NamedQueries({
  @NamedQuery(name = "IngredientPotion.findAll", query = "SELECT i FROM IngredientPotion i")
  , @NamedQuery(name = "IngredientPotion.findByIdIngredient", query = "SELECT i FROM IngredientPotion i WHERE i.ingredientPotionPK.idIngredient = :idIngredient")
  , @NamedQuery(name = "IngredientPotion.findByIdPotion", query = "SELECT i FROM IngredientPotion i WHERE i.ingredientPotionPK.idPotion = :idPotion")
  , @NamedQuery(name = "IngredientPotion.findByCantidad", query = "SELECT i FROM IngredientPotion i WHERE i.cantidad = :cantidad")
  , @NamedQuery(name = "IngredientPotion.findByPreparacion", query = "SELECT i FROM IngredientPotion i WHERE i.preparacion = :preparacion")
  , @NamedQuery(name = "IngredientPotion.findByOrden", query = "SELECT i FROM IngredientPotion i WHERE i.orden = :orden")
  , @NamedQuery(name = "IngredientPotion.findByIdIngPot", query = "SELECT i FROM IngredientPotion i WHERE i.idIngPot = :idIngPot")})
public class IngredientPotion implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected IngredientPotionPK ingredientPotionPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "cantidad")
  private int cantidad;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 250)
  @Column(name = "preparacion")
  private String preparacion;
  @Basic(optional = false)
  @NotNull
  @Column(name = "orden")
  private int orden;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_ing_pot")
  private int idIngPot;
  @JoinColumn(name = "id_ingredient", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Ingredient ingredient;
  @JoinColumn(name = "id_potion", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Potion potion;

  public IngredientPotion() {
  }

  public IngredientPotion(IngredientPotionPK ingredientPotionPK) {
    this.ingredientPotionPK = ingredientPotionPK;
  }

  public IngredientPotion(IngredientPotionPK ingredientPotionPK, int cantidad, String preparacion, int orden, int idIngPot) {
    this.ingredientPotionPK = ingredientPotionPK;
    this.cantidad = cantidad;
    this.preparacion = preparacion;
    this.orden = orden;
    this.idIngPot = idIngPot;
  }

  public IngredientPotion(int idIngredient, int idPotion) {
    this.ingredientPotionPK = new IngredientPotionPK(idIngredient, idPotion);
  }

  public IngredientPotionPK getIngredientPotionPK() {
    return ingredientPotionPK;
  }

  public void setIngredientPotionPK(IngredientPotionPK ingredientPotionPK) {
    this.ingredientPotionPK = ingredientPotionPK;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getPreparacion() {
    return preparacion;
  }

  public void setPreparacion(String preparacion) {
    this.preparacion = preparacion;
  }

  public int getOrden() {
    return orden;
  }

  public void setOrden(int orden) {
    this.orden = orden;
  }

  public int getIdIngPot() {
    return idIngPot;
  }

  public void setIdIngPot(int idIngPot) {
    this.idIngPot = idIngPot;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  public Potion getPotion() {
    return potion;
  }

  public void setPotion(Potion potion) {
    this.potion = potion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (ingredientPotionPK != null ? ingredientPotionPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof IngredientPotion)) {
      return false;
    }
    IngredientPotion other = (IngredientPotion) object;
    if ((this.ingredientPotionPK == null && other.ingredientPotionPK != null) || (this.ingredientPotionPK != null && !this.ingredientPotionPK.equals(other.ingredientPotionPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "quevedo.hibernatetest.IngredientPotion[ ingredientPotionPK=" + ingredientPotionPK + " ]";
  }
  
}
