package de.softunivers.javaee7.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayoubfalah
 */
@Entity
@Table(name = "ITEM")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemno", query = "SELECT i FROM Item i WHERE i.itemno = :itemno"),
    @NamedQuery(name = "Item.findByUnitprice", query = "SELECT i FROM Item i WHERE i.unitprice = :unitprice")})
@XmlRootElement
public class Item implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Item_name")
    private String itemname;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Item_no")
    private Integer itemno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Unit_price")
    private Float unitprice;

    public Item() {
    }

    public Item(Integer itemno) {
        this.itemno = itemno;
    }

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;
    }

    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemno != null ? itemno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemno == null && other.itemno != null) || (this.itemno != null && !this.itemno.equals(other.itemno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ itemno=" + itemno +", unitprice=" + unitprice + " ]";
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    
}
