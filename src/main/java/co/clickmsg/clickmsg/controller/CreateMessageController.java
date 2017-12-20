/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.controller;

import co.clickmsg.clickmsg.controller.util.Common;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tomide
 */
@Controller
@RequestMapping(value = {"/create_message"})
public class CreateMessageController {
    
    @GetMapping
    public String home(Model model){
        
        
         model.addAttribute("page", "create_message");
        return Common.DASHBOARD;
    }
    
}
