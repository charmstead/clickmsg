/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.config;

import co.clickmsg.clickmsg.domain.User;
import co.clickmsg.clickmsg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author tomide
 */
@Component
public class DatabaseLoader implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public void run(String... strings) throws Exception {
            User user = new User();
            user.setEmail("admin@admin.com")
                .setPassword("123abc")
                .setRoles("admin,user".split(","));
                    
            SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken("admin@admin.com", "123abc",
            AuthorityUtils.createAuthorityList("admin")));
            
            try{
               userRepository.saveAndFlush(user); 
            }
            catch(Exception e){
                
            }
            
            SecurityContextHolder.clearContext();
    }
}