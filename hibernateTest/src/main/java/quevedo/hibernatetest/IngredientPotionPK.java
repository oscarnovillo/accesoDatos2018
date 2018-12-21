/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.hibernatetest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author oscar
 */
@Embeddable
public class IngredientPotionPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "id_ingredient")
  private int idIngredient;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_potion")
  private int idPotion;

  public IngredientPotionPK() {
  }

  public IngredientPotionPK(int idIngredient, int idPotion) {
    this.idIngredient = idIngredient;
    this.idPotion = idPotion;
  }

  public int getIdIngredient() {
    return idIngredient;
  }

  public void setIdIngredient(int idIngredient) {
    this.idIngredient = idIngredient;
  }

  public int getIdPotion() {
    return idPotion;
  }

  public void setIdPotion(int idPotion) {
    this.idPotion = idPotion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) idIngredient;
    hash += (int) idPotion;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof IngredientPotionPK)) {
      return false;
    }
    IngredientPotionPK other = (IngredientPotionPK) object;
    if (this.idIngredient != other.idIngredient) {
      return false;
    }
    if (this.idPotion != other.idPotion) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "quevedo.hibernatetest.IngredientPotionPK[ idIngredient=" + idIngredient + ", idPotion=" + idPotion + " ]";
  }
  
}
