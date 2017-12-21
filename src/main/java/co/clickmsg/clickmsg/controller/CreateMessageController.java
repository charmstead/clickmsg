/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.controller;

import co.clickmsg.clickmsg.controller.util.Common;
import co.clickmsg.clickmsg.domain.JsonMessage;
import co.clickmsg.clickmsg.dto.JsonMessageDto;
import co.clickmsg.clickmsg.service.JsonMessageService;
import co.clickmsg.clickmsg.serviceImpl.UserServImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.Principal;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import co.clickmsg.clickmsg.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 *
 * @author tomide
 */
@Controller
@RequestMapping(value = {"/create_message"})
public class CreateMessageController {
    
    private static final Logger log = LoggerFactory.getLogger(CreateMessageController.class);

    private static final ObjectMapper mapper= new ObjectMapper();
    
    @Autowired
    private UserServImpl userServ;
    
    @Autowired
    private JsonMessageService jsonMessageService;

    @GetMapping
    public String home(Model model){
        
        
         model.addAttribute("page", "create_message");
        return Common.DASHBOARD;
    }

    @PostMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonMessage postForm(@RequestBody String jsonMessage,Principal principal) throws JsonProcessingException{
        
        Authentication user = (Authentication)principal;

        
        Map<String, Object> map = new HashMap<String, Object>();
        
        try {
            map = mapper.readValue(jsonMessage, new TypeReference<HashMap>(){});
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CreateMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JsonMessage jm = new JsonMessage();
        jm.setName((String) map.get("name"));
        jm.setMessage(mapper.writeValueAsString(map.get("message")));
        jm.setId(Long.parseLong(((String) map.get("id")).isEmpty()?"0":((String) map.get("id")).trim()));

        
        
        
       // userServ.save(user.getName(), msg);
        
        System.out.println(map.get("message"));
        
       return jm;
   
    }
    
}
