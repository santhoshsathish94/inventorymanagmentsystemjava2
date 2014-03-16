/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByProductIntNo", query = "SELECT p FROM Product p WHERE p.productIntNo = :productIntNo"),
    @NamedQuery(name = "Product.findByCountry", query = "SELECT p FROM Product p WHERE p.country = :country"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findBySize1", query = "SELECT p FROM Product p WHERE p.size1 = :size1"),
    @NamedQuery(name = "Product.findByWeight", query = "SELECT p FROM Product p WHERE p.weight = :weight"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "product_id", nullable = false,insertable = false)
    private Integer productId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String category;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "product_int_no", nullable = false)
    private int productIntNo;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String country;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quantity;
    @Column(length = 50)
    private String size1;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String weight;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id")
    @ManyToOne
    private Vendor vendorId;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String category, String name, int productIntNo, String country, int quantity, String weight, BigDecimal price,Vendor vendorId) {
        this.productId = productId;
        this.category = category;
        this.name = name;
        this.productIntNo = productIntNo;
        this.country = country;
        this.quantity = quantity;
        this.weight = weight;
        this.vendorId = vendorId;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductIntNo() {
        return productIntNo;
    }

    public void setProductIntNo(int productIntNo) {
        this.productIntNo = productIntNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize1() {
        return size1;
    }

    public void setSize1(String size1) {
        this.size1 = size1;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Vendor getVendorId() {
        return vendorId;
    }

    public void setVendorId(Vendor vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Product[ productId=" + productId + " ]";
    }
    
}
