/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author instance-pc
 */
@Entity
@Table(catalog = "dbee2c60445cce484dbb44a2e900d2777e", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
    @NamedQuery(name = "Vendor.findByVendorId", query = "SELECT v FROM Vendor v WHERE v.vendorId = :vendorId"),
    @NamedQuery(name = "Vendor.findByName", query = "SELECT v FROM Vendor v WHERE v.name = :name"),
    @NamedQuery(name = "Vendor.findByCvr", query = "SELECT v FROM Vendor v WHERE v.cvr = :cvr"),
    @NamedQuery(name = "Vendor.findByAddress", query = "SELECT v FROM Vendor v WHERE v.address = :address"),
    @NamedQuery(name = "Vendor.findByPostalCode", query = "SELECT v FROM Vendor v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "Vendor.findByPhone", query = "SELECT v FROM Vendor v WHERE v.phone = :phone"),
    @NamedQuery(name = "Vendor.findByActive", query = "SELECT v FROM Vendor v WHERE v.active = :active")})
public class Vendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vendor_id", nullable = false,insertable = false)
    private Integer vendorId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String cvr;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String address;
    @Basic(optional = false)
    @Column(name = "postal_code", nullable = false)
    private int postalCode;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String phone;
    @Basic(optional = false)
    @Column(nullable = false)
    private short active;
    @OneToMany(mappedBy = "vendorId")
    private Collection<Product> productCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendor1")
    private Vendor vendor;
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Vendor vendor1;

    public Vendor() {
    }

    public Vendor(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Vendor(Integer vendorId, String name, String cvr, String address, int postalCode, String phone, short active) {
        this.vendorId = vendorId;
        this.name = name;
        this.cvr = cvr;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.active = active;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Vendor getVendor1() {
        return vendor1;
    }

    public void setVendor1(Vendor vendor1) {
        this.vendor1 = vendor1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendorId == null && other.vendorId != null) || (this.vendorId != null && !this.vendorId.equals(other.vendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Vendor[ vendorId=" + vendorId + " ]";
    }
    
}
