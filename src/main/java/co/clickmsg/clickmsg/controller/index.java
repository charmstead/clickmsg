/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tomide
 */
@Controller
public class index {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);
//
    @RequestMapping("/index")
    public String getLogin(Model model, HttpServletRequest request) {
    
        return "index";
    }
}
