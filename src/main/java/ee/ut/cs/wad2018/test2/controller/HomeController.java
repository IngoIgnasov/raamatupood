package ee.ut.cs.wad2018.test2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getTestPage() {
        return "home/index.html";
    }

    @PostMapping(path = "/")
    public String getTestPageBack() {
        return "home/index.html";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "home/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLoginPage() {
        return "home/login.html";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String getAccountPage() {
        return "home/account.html";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "home/contact.html";
    }

    @GetMapping("/raamatpostform")
    public String getRaamatPage() {
        return "home/raamat.html";
    }
    @GetMapping("/raamatMainPage")
    public String getRaamatMainPage(){return "home/raamatMain.html";}
}



