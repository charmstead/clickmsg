/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author tomide
 */
@Entity
@ToString(exclude = "password")
@Data
public class User extends BaseAuditableModel{
    
    
public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    private List[] roles;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<JsonMessage> jsonMesage; 
    
    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "billing_id")
    private Billing billing;
    
    

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        
        this.password = PASSWORD_ENCODER.encode(password);
        return this;
    }

    public List<JsonMessage> getJsonMesage() {
        return jsonMesage;
    }

    public void setJsonMesage(List<JsonMessage> jsonMesage) {
        this.jsonMesage = jsonMesage;
    }


    public Billing getBilling() {
        return billing;
    }

    public User setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public List[] getRoles() {
        return roles;
    }

    public void setRoles(List[] roles) {
        this.roles = roles;
    }

    
    
}
