package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String printAllUser(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @GetMapping("/remove")
    public String deleteById(@RequestParam(value = "id", required = false) long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/find")
    public String findUserById(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", List.of(userService.findUserById(id)));
        return "user";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam(value = "id", required = false) long id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "update";
    }
    @PostMapping("/update")
    public String updateUser(@Valid User user){
       userService.updateUser(user);
       return "redirect:/users";
    }
}
