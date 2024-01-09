package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링 빈 관리 -> 스프링 컨테이너에 memberController 객체 생성하여 넣어둠.
public class MemberController {
    // 스프링이 관리 -> 스프링 컨테이너에 등록하고 사용하자 !
    private final MemberService memberService;

    @Autowired // DI -> memberController 생성시 스프링 빈에 등록된 memberService 객체와 연결시켜줌.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
