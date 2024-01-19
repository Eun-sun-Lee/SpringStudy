package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // MemberRepository 타입에 맞는 component를 찾아와서 스프링이 자동으로 의존관계 주입해줌. ac.getBean(MemberRepository.class) 처럼 동작
    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자를 통해 memberRepository의 구현체가 뭐가 들어갈지 결정
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
