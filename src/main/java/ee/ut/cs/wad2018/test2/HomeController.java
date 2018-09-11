package ee.ut.cs.wad2018.test2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String getTestPage(){
        return "home/index";
    }


}
