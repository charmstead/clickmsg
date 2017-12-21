/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.service;

import co.clickmsg.clickmsg.domain.JsonMessage;
import java.util.List;

/**
 *
 * @author tomide
 */
public interface JsonMessageService {
    
    public void save(JsonMessage jsonMessage);
    
    public List<JsonMessage> findAll();
    
    public List<JsonMessage> findByUserEmail(String email);
}
