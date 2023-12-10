package questionnaire.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class Test {
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(){
        return "home";
    }
}
