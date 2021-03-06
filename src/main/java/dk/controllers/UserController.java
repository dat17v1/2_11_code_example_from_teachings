package dk.controllers;

import dk.models.entities.User;
import dk.models.repositories.IUserRepository;
import dk.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by clbo on 27/09/2017.
 */

@Controller
public class UserController {

    
    @Autowired
    IUserRepository userRepository = new UserRepository();

    // Read All
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", userRepository.readAll());
        return "index";
    }

    // Read One
    @GetMapping("/details")
    public String details(@RequestParam("id") String userId, Model model){

        int intId = Integer.parseInt(userId);
        model.addAttribute("user", userRepository.read(intId));
        return "details";
    }

    // Create
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user){
        userRepository.create(user);
        return "redirect:/";
    }

    // Update
    @GetMapping("/update")
    public String update(@RequestParam("id") String userId, Model model){
        int intId = Integer.parseInt(userId);
        model.addAttribute("user", userRepository.read(intId));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user){
        userRepository.update(user);
        return "redirect:/";
    }

    // Delete
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String userId, Model model){
        int intId = Integer.parseInt(userId);
        userRepository.delete(intId);
        return "redirect:/";
    }
}
