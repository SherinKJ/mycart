package sherin.onlinecart.mycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sherin.onlinecart.mycart.model.Customer;
import sherin.onlinecart.mycart.service.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("")
    public String home(Model model, HttpSession session) {
        model.addAttribute("session", session);
        model.addAttribute("data", service.read());
        return "admin/home";
    }

    @GetMapping("/create")
    public String create() {
        return "/admin/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Customer customer, Model model) {
        Customer c = service.create(customer);
        if (c == null) {
            model.addAttribute("msg", "Not able to create ! Try later !");
        } else {
            model.addAttribute("msg", c.getName() + " Registered !");
        }
        return "/admin/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        Customer c = service.read(id);
        model.addAttribute("cust", c);
        model.addAttribute("msg", "");
        return "/admin/delete";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Customer c = service.read(id);
        model.addAttribute("cust", c);
        model.addAttribute("msg", "");
        return "/admin/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSave(@ModelAttribute Customer customer, Model model, @PathVariable Long id) {
        customer.setId(id);
        Customer cus = service.update(id, customer);
        if (cus == null) {
            model.addAttribute("msg", "Invalid id ?");
        } else {
            model.addAttribute("msg", cus.getName() + " Updated !");
        }
        model.addAttribute("cust", customer);
        return "admin/edit";
    }

    @PostMapping("/delete/{id}")
    public String deleteMe(Model model, @PathVariable Long id) {
        Customer cus = service.delete(id);
        if (cus == null) {
            model.addAttribute("msg", "Invalid id ?");
        } else {
            return "redirect:/admin";
        }
        return "admin/delete";
    }

    @Autowired
    private CustomerService service;
}
