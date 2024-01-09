package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired // DI -> memberService 생성시 스프링 빈에 등록된 memberRepository 객체와 연결시켜줌.
    public MemberService(MemberRepository memberRepository) { // 직접 생성 X, 외부에서ㄴㄷ주입
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름이 있는 중복 회원 검증
        memberRepository.findByName(member.getName()) // 리턴값 : optional 객체
                .ifPresent(m -> { // null이 아닌 값이 있다면 (optional 안에 객체 존재)
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // param으로 온 id에 해당하는 객체 반한
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}