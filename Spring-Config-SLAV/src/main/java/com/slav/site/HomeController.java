package com.slav.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public View home(Map<String, Object> model) {

        model.put("dashboardUrl", "dashboard");
        return new RedirectView("/{dashboardUrl}", true);
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Map<String, Object> model) {

        model.put("text", "This is a model attribute.");
        model.put("date", Instant.now());

        return "home/dashboard";
    }

    @RequestMapping(value = "/user/home", method = RequestMethod.GET)
    @ModelAttribute("currentUser")
    public User userHome() {

        User user = new User();
        user.setUserId(123412316421L);
        user.setUsername("adam");
        user.setName("Adam Jensen");

        return user;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("userId") long userId) {

        User user = new User();
        user.setUserId(userId);
        user.setUsername("john");
        user.setName("John Doe");

        return user;
    }
}

