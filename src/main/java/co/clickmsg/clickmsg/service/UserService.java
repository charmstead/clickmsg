/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.service;

import co.clickmsg.clickmsg.domain.JsonMessage;
import co.clickmsg.clickmsg.domain.User;

/**
 *
 * @author tomide
 */
public interface UserService {
    
    public User findByEmail(String email);
    
    public User save(User user);
    
    public User save(String email,JsonMessage jsonMessage);
}
