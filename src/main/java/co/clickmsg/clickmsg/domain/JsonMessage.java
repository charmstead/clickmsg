/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.domain;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author tomide
 */
@Entity
public class JsonMessage extends BaseAuditableModel{
    
    private String name;
    
    private String jsonMessage;
    
    @ManyToOne
    private User user;

    public String getJsonMessage() {
        return jsonMessage;
    }

    public void setJsonMessage(String jsonMessage) {
        this.jsonMessage = jsonMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
