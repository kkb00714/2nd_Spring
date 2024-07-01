package spring.spring_lec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "내가 진짜 들어가는 데이터임!");
        // attributeName이 key, attriuteValue가 value
        return "hello";
    }

    @GetMapping("hellostatic")
    public String hellostatic(Model model) {
        return "statictest";
    }


}
