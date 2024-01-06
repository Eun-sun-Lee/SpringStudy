package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 들어올 시 해당 method 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // data를 hello!! 라고 넘김.
        return "hello"; // 랜더링할 화면으로 hello.html 리턴
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
