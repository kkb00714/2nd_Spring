package spring.spring_lec.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.spring_lec.test2.MemberService;

@Controller
public class MemberController {
    @GetMapping("/")
    // 기존에 있던 정적인 / 루트는 무시됨
    public String home() {
        return "home";
    }

}
