/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author instance-pc
 */
@Entity
@Table(catalog = "dbee2c60445cce484dbb44a2e900d2777e", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByFName", query = "SELECT c FROM Customer c WHERE c.fName = :fName"),
    @NamedQuery(name = "Customer.findByLName", query = "SELECT c FROM Customer c WHERE c.lName = :lName"),
    @NamedQuery(name = "Customer.findByUsername", query = "SELECT c FROM Customer c WHERE c.username = :username"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country"),
    @NamedQuery(name = "Customer.findByPostalCode", query = "SELECT c FROM Customer c WHERE c.postalCode = :postalCode"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByOrders", query = "SELECT c FROM Customer c WHERE c.orders = :orders")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "customer_id", nullable = false,insertable = false)
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "f_name", nullable = false, length = 50)
    private String fName;
    @Basic(optional = false)
    @Column(name = "l_name", nullable = false, length = 50)
    private String lName;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String country;
    @Basic(optional = false)
    @Column(name = "postal_code", nullable = false)
    private int postalCode;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String address;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String phone;
    private Integer orders;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer customerId, String fName, String lName, String country, int postalCode, String address, String phone) {
        this.customerId = customerId;
        this.fName = fName;
        this.lName = lName;
        this.country = country;
        this.postalCode = postalCode;
        this.address = address;
        this.phone = phone;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Customer[ customerId=" + customerId + " ]";
    }
    
}
