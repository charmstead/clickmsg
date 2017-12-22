/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class User extends BaseAuditableModel implements Serializable{
    
    
public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
    @Column(unique = true,length = 50)
    private String email;
    
    private String password;
    
    private String[] roles;
    
//    @JsonIgnore
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

    public User setJsonMesage(List<JsonMessage> jsonMesage) {
        this.jsonMesage = jsonMesage;
        return this;
    }


    public Billing getBilling() {
        return billing;
    }

    public User setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public String[] getRoles() {
        return roles;
    }

    public User setRoles(String[] roles) {
        this.roles = roles;
        return this;
    }

    
    
}
