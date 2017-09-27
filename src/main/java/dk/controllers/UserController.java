package dk.controllers;

import dk.models.entities.User;
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


    // Read All
    @GetMapping("/")
    public String index(){
        return "index";
    }

    // Create
    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(Model model){
        return "index";
    }


    // READ
    @GetMapping("/details")
    public String details(@RequestParam("id") String userId, Model model){
        return "details";
    }

    // Update
    @GetMapping("/update")
    public String update(@RequestParam("id") String userId, Model model){
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute User user){
        return "redirect:/";
    }

    // Delete
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String userId, Model model){
        return "redirect:/";
    }
}
