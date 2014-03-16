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
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPasswordHash", query = "SELECT u FROM Users u WHERE u.passwordHash = :passwordHash"),
    @NamedQuery(name = "Users.findByType", query = "SELECT u FROM Users u WHERE u.type = :type"),
    @NamedQuery(name = "Users.findByFName", query = "SELECT u FROM Users u WHERE u.fName = :fName"),
    @NamedQuery(name = "Users.findByLName", query = "SELECT u FROM Users u WHERE u.lName = :lName")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false,insertable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String passwordHash;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String type;
    @Basic(optional = false)
    @Column(name = "f_name", nullable = false, length = 50)
    private String fName;
    @Basic(optional = false)
    @Column(name = "l_name", nullable = false, length = 50)
    private String lName;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String username, String passwordHash, String type, String fName, String lName) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.type = type;
        this.fName = fName;
        this.lName = lName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Users[ userId=" + userId + " ]";
    }
    
}
