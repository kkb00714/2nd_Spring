package spring.spring_lec.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.spring_lec.test2.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired
    // 생성자에 @Autowired가 있으면 스프링이 연간된 객체를 스프링 컨테이너에서 찾아 넣어줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
