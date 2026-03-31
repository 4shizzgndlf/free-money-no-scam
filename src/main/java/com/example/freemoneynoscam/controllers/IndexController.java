package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.models.Email;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class IndexController {
    private ValidateEmailService service = new ValidateEmailService();

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<Email> allEmails = service.getAllEmails();
        mav.addObject("emails", allEmails);
        return mav;
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm) {
        System.out.println(dataFromForm.getParameter("email"));
        String email = dataFromForm.getParameter("email");
        boolean success = service.saveEmail(email);
        if (success) {
            return "redirect:/success";
        } else {
            return "redirect:/failure";
        }
    }

    @GetMapping("/success")
    public ModelAndView success() {
        ModelAndView mav = new ModelAndView("success");
        List<Email> allEmails = service.getAllEmails();
        mav.addObject("emails", allEmails);
        return mav;
    }

    @GetMapping("/failure")
    public String failure() {
        return "failure";
    }
}
