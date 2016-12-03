package de.softunivers.javaee7.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ayoubfalah
 */
@Entity
@Table(name = "CUSTOMER")
// Define some of the most common queries
// Defining a query this way results in a static named query
// Each static named query will be precompild by the persistence provider
// This approach follows the "Don´t Repeat Yourself"(DRY) design pattern
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustno", query = "SELECT c FROM Customer c WHERE c.custno = :custno"),
    @NamedQuery(name = "Customer.findByCustname", query = "SELECT c FROM Customer c WHERE c.custname = :custname"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cust_no")
    private Integer custno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Cust_name")
    private String custname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "City")
    private String city;
    @OneToMany(mappedBy = "custno")
    private Collection<PurchaseOrder> purchaseOrderCollection;

    public Customer() {
    }

    public Customer(Integer custno) {
        this.custno = custno;
    }

    public Customer(Integer custno, String custname, String city) {
        this.custno = custno;
        this.custname = custname;
        this.city = city;
    }

    public Integer getCustno() {
        return custno;
    }

    public void setCustno(Integer custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<PurchaseOrder> getPurchaseOrderCollection() {
        return purchaseOrderCollection;
    }

    public void setPurchaseOrderCollection(Collection<PurchaseOrder> purchaseOrderCollection) {
        this.purchaseOrderCollection = purchaseOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custno != null ? custno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custno == null && other.custno != null) || (this.custno != null && !this.custno.equals(other.custno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ custno=" + custno + ", custname=" + custname + ", city=" + city + " ]";
    }
    
}
