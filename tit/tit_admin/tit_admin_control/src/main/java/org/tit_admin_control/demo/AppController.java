package org.tit_admin_control.demo;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppController{

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "home";
    }
}
