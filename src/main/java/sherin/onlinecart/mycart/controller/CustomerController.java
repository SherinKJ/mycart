package sherin.onlinecart.mycart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("")
    public String home(Model model, HttpSession session) {
        // System.out.println(session.getAttribute("name"));
        // model.addAttribute("data", service.read());
        return "admin/home";
    }
}
