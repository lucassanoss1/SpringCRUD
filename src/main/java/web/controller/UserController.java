package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.servis.UserServis;
import web.servis.UserServisImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserServis userServis;

    public UserController(UserServis userServis) {
        this.userServis = userServis;
    }

    @GetMapping("/users")
    public String printAllUser(Model model) {
        model.addAttribute("user", userServis.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userServis.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addUser(User user, Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @GetMapping("/remove")
    public String deleteById(@RequestParam(value = "id", required = false) long id) {
        userServis.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/find")
    public String findUserById(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", List.of(userServis.findUserById(id)));
        return "user";
    }
}
