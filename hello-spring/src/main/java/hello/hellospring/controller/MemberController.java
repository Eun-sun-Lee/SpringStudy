package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링 빈 관리 -> 스프링 컨테이너에 memberController 객체 생성하여 넣어둠.
public class MemberController {
    // 스프링이 관리 -> 스프링 컨테이너에 등록하고 사용하자 !
    private final MemberService memberService;

    @Autowired // DI -> memberController 생성시 스프링 빈에 등록된 memberService 객체와 연결시켜줌.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);
        return "redirect:/"; // home 화면으로 redirect
    }

    @GetMapping("/members")
    public String List(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // 멤버의 리스트 자체를 model에 담아 화면으로 넘김.
        return "members/memberList";
    }
}
