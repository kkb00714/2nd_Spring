package spring.spring_lec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class API_Test_Controller {


    @GetMapping("hiapi")
    @ResponseBody
    public String hiapi(@RequestParam(value = "word", required = true) String word) {
        return "하고싶은 말은 : " + word;
    }

    @GetMapping("helloapi")
    @ResponseBody
    // 기본적으로 객체를 반환하고 ResponseBody로 받아오면 JSON으로 반환함
    public Word helloapi(@RequestParam("sentence") String sentence) {
        Word word = new Word();
        word.setWord(sentence);
        return word;
    }

//
//    1. 톰캣 내장 서버에서 해당 컨트롤러를 찾음
//    2. @ResponseBody 어노테이션이 붙어있음을 발견
//    3. http 응답에 그대로 그 응답을 넘김 (문자의 경우 문자를 넘기고,
//       객체의 경우 객체를 Json 방식으로 만들어서 넘김)
//    4. 객체를 보고 HttpMessageConverter가 동작
//       => 문자열의 경우 StringConverter가, 객체의 경우 JsonConverter가 동작
//    5. 바꾼 데이터를 웹 브라우저에 응답해줌
//

    static class Word {
        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }
}
