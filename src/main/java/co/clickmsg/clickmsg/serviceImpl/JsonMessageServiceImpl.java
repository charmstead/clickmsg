/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.serviceImpl;

import co.clickmsg.clickmsg.domain.JsonMessage;
import co.clickmsg.clickmsg.repository.JsonMessageRepository;
import co.clickmsg.clickmsg.service.JsonMessageService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Override
    public void save(JsonMessage jsonMessage) {
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
