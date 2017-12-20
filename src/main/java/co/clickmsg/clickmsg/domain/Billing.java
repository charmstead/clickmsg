/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.joda.time.DateTime;

/**
 *
 * @author tomide
 */
@Entity
public class Billing extends BaseAuditableModel{
    
    @OneToOne
    private User user;
    
    private String tier;
    
    private DateTime paymentDate;
    
    private DateTime dueDate;
    
    private Long durationLeft;
    
    private BigDecimal fee;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }



    public void setDurationLeft(Long durationLeft) {
        
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
    
    
        
}
