/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.dto;


import co.clickmsg.clickmsg.domain.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author tomide
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto{
    
    
public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
    
    private String email;
    
    private String password;
    
    private List[] roles;
    
   
    private List<JsonMessage> jsonMesage; 
    
    private Billing billing;
    
    

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        
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

    public UserDto setBilling(Billing billing) {
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
