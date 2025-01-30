package sherin.onlinecart.mycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import sherin.onlinecart.mycart.model.Customer;
import sherin.onlinecart.mycart.service.CustomerService;

@Controller
public class GuestController {
    @GetMapping("/")
    public String home() {
        return "guest/home";
    }

    @GetMapping("/login")
    public String login() {
        return "guest/login";
    }

    @PostMapping("/login")
    public String loginCheck(@RequestParam String userName, @RequestParam String password, Model model,
            HttpServletRequest req) {
        // System.out.println(userName + ", " + password);
        Customer c = service.loginCheck(userName, password);
        if (c != null) {
            HttpSession session = req.getSession();
            session.setAttribute("uid", c.getId());
            session.setAttribute("name", c.getUserName());
            session.setAttribute("type", c.getUserType());
            return "redirect:/" + c.getUserType();
            // System.out.println(c.getUserType());
        } else {
            model.addAttribute("msg", "Invalid User Name or Password");
        }
        return "guest/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        // session.removeAttribute("uid");
        session.invalidate();
        return "redirect:/login";
    }

    @Autowired
    private CustomerService service;
}
