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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tomide
 */

@Controller
@RequestMapping("manage_messages")
public class ManageMessage {
    
    @Autowired
    private JsonMessageService jsonMessageService;
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    @GetMapping
    public String getManageMessage(Model model,Principal principal){
        
        String email =principal.getName();
        
        List<JsonMessage> messages = jsonMessageService.findByUserEmail(email);
        
        
        List<JsonMessageDto> dto = new ArrayList<>();
//        
        for(JsonMessage msg : messages){
            
            try {
                if(!isNull(msg)){
                    Object test = mapper.readValue(msg.getMessage(), Object.class);
                    
                    dto.add(new JsonMessageDto(msg.getId(),msg.getName(),test));
                       System.out.println(msg.getId());
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getCause());
            }
            
        }
     
        model.addAttribute("page", "manage_messages");
        
        model.addAttribute("messages", dto);
        return Common.DASHBOARD;
    }
    
    
    @GetMapping("/delete")
    public String deleteMessage(Model model,@RequestParam("id") int id,Principal principal){
        
        jsonMessageService.delete(id, principal.getName());
        
        return "redirect:/manage_messages";
    }
        
     @GetMapping("/edit")
    public String home(Model model,@RequestParam long id){
        
        JsonMessage json = jsonMessageService.findById(id);
        
        JsonMessageDto jsonMessageDto = new JsonMessageDto();
        try {
            Object result = mapper.readValue(json.getMessage(), Object.class);
            jsonMessageDto.setId(id);
            jsonMessageDto.setName(json.getName());
            jsonMessageDto.setMessage(result);
        } catch (IOException ex) {
            Logger.getLogger(ManageMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addAttribute("page", "edit");
        model.addAttribute("message", jsonMessageDto);
        
        return Common.DASHBOARD;
    }
}
