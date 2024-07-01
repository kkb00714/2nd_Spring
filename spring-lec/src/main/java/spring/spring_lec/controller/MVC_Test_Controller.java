package spring.spring_lec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVC_Test_Controller {

    @GetMapping("hiMVC")
    // hiMVC?name=값 형식으로 값을 넣어야 함. required 를 true로 했기 때문.
    public String hiMVC(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "mvctest";
    }
}
