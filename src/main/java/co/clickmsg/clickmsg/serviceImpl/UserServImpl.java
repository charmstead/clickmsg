/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.serviceImpl;


import co.clickmsg.clickmsg.domain.JsonMessage;
import co.clickmsg.clickmsg.repository.UserRepository;
import static java.util.Objects.isNull;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.clickmsg.clickmsg.service.UserService;

/**
 *
 * @author tomide
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class UserServImpl implements UserService,UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public co.clickmsg.clickmsg.domain.User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        
        co.clickmsg.clickmsg.domain.User user = userRepo.findByEmail(name);
        return new User(user.getEmail(), user.getPassword(),
        AuthorityUtils.createAuthorityList(user.getRoles()));
    }

    @Override
    public co.clickmsg.clickmsg.domain.User save(co.clickmsg.clickmsg.domain.User user) {
        
       co.clickmsg.clickmsg.domain.User us = userRepo.findByEmail(user.getEmail());
        
       if(isNull(us)){
          return userRepo.saveAndFlush(user);
       }
       
       return null;
    }
    
    
    @Override
    public co.clickmsg.clickmsg.domain.User save(String email,JsonMessage jsonMessage) {
        
        
        co.clickmsg.clickmsg.domain.User user = userRepo.findByEmail(email);
        
        if(!isNull(user)){
            jsonMessage.setUser(user);
            user.getJsonMesage().add(jsonMessage);
           return userRepo.saveAndFlush(user);
        }
        return null;
    }
    
    
}
