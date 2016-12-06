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
@Table(name = "WAREHOUSE")
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByWarehouseno", query = "SELECT w FROM Warehouse w WHERE w.warehouseno = :warehouseno"),
    @NamedQuery(name = "Warehouse.findByCity", query = "SELECT w FROM Warehouse w WHERE w.city = :city")})
@XmlRootElement
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Warehouse_no")
    private Integer warehouseno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "City")
    private String city;

    public Warehouse() {
    }

    public Warehouse(Integer warehouseno) {
        this.warehouseno = warehouseno;
    }

    public Warehouse(Integer warehouseno, String city) {
        this.warehouseno = warehouseno;
        this.city = city;
    }

    public Integer getWarehouseno() {
        return warehouseno;
    }

    public void setWarehouseno(Integer warehouseno) {
        this.warehouseno = warehouseno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warehouseno != null ? warehouseno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.warehouseno == null && other.warehouseno != null) || (this.warehouseno != null && !this.warehouseno.equals(other.warehouseno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.softunivers.javaee7.entities.Warehouse[ warehouseno=" + warehouseno + " ]";
    }
    
}
