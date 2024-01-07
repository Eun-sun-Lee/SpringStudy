package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();


    // class 전체로 test를 돌릴 시 메소드 실행 순서에 의존적이지 않게 하기 위해 메소드 끝날 때마다 레포지토리 clean하게 만듦.
    @AfterEach // 메소드가 끝날 때마다 해당 함수를 실행하게 하기 위한 aunnotation (callback 함수)
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // optional을 사용하면 get()으로 꺼내쓸 수 O
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result); // 예상값, 실제값
        assertThat(member).isEqualTo(result); // member가 result랑 같은지 확인
    }

    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring1");
        repository.save(member2);

//        Optional<Member> byName = repository.findByName("spring1");
        Member result = repository.findByName("spring1").get(); // get()을 통해 optional으로부터 member를 꺼낼 수 O
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
