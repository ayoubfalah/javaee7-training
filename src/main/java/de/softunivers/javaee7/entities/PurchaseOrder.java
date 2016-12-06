package de.softunivers.javaee7.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ayoubfalah
 */
@Entity
@Table(name = "PURCHASE_ORDER")
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findByOrderno", query = "SELECT p FROM PurchaseOrder p WHERE p.orderno = :orderno"),
    @NamedQuery(name = "PurchaseOrder.findByOrddate", query = "SELECT p FROM PurchaseOrder p WHERE p.orddate = :orddate"),
    @NamedQuery(name = "PurchaseOrder.findByOrdamt", query = "SELECT p FROM PurchaseOrder p WHERE p.ordamt = :ordamt")})
@XmlRootElement
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Order_no")
    private Integer orderno;
    @Column(name = "Ord_date")
    @Temporal(TemporalType.DATE)
    private Date orddate;
    @Column(name = "Ord_amt")
    private Float ordamt;
    @JoinColumn(name = "Cust_no", referencedColumnName = "Cust_no")
    @ManyToOne
    private Customer custno;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer orderno) {
        this.orderno = orderno;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Date getOrddate() {
        return orddate;
    }

    public void setOrddate(Date orddate) {
        this.orddate = orddate;
    }

    public Float getOrdamt() {
        return ordamt;
    }

    public void setOrdamt(Float ordamt) {
        this.ordamt = ordamt;
    }

    public Customer getCustno() {
        return custno;
    }

    public void setCustno(Customer custno) {
        this.custno = custno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderno != null ? orderno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.orderno == null && other.orderno != null) || (this.orderno != null && !this.orderno.equals(other.orderno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.softunivers.javaee7.entities.PurchaseOrder[ orderno=" + orderno + " ]";
    }
    
}
