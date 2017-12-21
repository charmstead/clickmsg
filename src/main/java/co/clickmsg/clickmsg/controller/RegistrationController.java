/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.controller;

import co.clickmsg.clickmsg.controller.util.Common;
import co.clickmsg.clickmsg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tomide
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    
    private Logger log = LoggerFactory.getLogger(RegistrationController.class);
    
    @Autowired
    private UserService userService;
    
    
    @GetMapping("")
    public String regPage(Model model){
        
        model.addAttribute("page", "login");
        return Common.LAYOUT;
    }
    
}
