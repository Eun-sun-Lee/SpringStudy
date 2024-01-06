package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 들어올 시 해당 method 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // data를 hello!! 라고 넘김.
        return "hello"; // 랜더링할 화면으로 hello.html 리턴
    }

    @GetMapping("hello-mvc") // MVC 방식
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") // API 방식
    @ResponseBody // http 통신 프로토콜에서 body 부에 return할 data를 직접 넣어줌.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // 위의 helloMvc와 차이 : view 필요 없이 data(문자)가 그대로 내려감.
    }

    @GetMapping("hello-api") // API 방식
    @ResponseBody // 기본으로 json 타입으로 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello { // HelloController.Hello 이런식으로 쓸 수 O
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
