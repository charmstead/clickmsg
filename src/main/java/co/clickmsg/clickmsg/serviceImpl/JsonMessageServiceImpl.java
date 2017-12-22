/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.serviceImpl;

import co.clickmsg.clickmsg.domain.JsonMessage;
import co.clickmsg.clickmsg.domain.User;
import co.clickmsg.clickmsg.repository.JsonMessageRepository;
import co.clickmsg.clickmsg.service.JsonMessageService;
import java.util.List;
import static java.util.Objects.isNull;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author tomide
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class JsonMessageServiceImpl implements JsonMessageService{

    @Autowired
    JsonMessageRepository jsonMessageRepo;
    
    @Autowired
    UserServImpl userServImpl;
    
    @Override
    public void save(JsonMessage jsonMessage) {
        
        String email =SecurityContextHolder.getContext().getAuthentication().getName();
        User user =userServImpl.findByEmail(email);
        
        if(!isNull(user)){
            jsonMessage.setUser(user);
            System.out.println("user id:"+user.getId());
        }
      
        jsonMessageRepo.saveAndFlush(jsonMessage);
    }

    @Override
    public List<JsonMessage> findAll() {
        return jsonMessageRepo.findAll();
    }

    @Override
    public List<JsonMessage> findByUserEmail(String email) {
        return jsonMessageRepo.findByUserEmail(email);
    }
    
}
