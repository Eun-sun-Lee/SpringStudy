package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// interface는 다중상속 가능
// JpaRepository를 상속하고 있으면 스프링 데이터 JPA가 해당 인터페이스의 구현체를 자동으로 만든 뒤 스프링 빈으로 등록해줌.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { // <type, pk의 type>

    @Override
    Optional<Member> findByName(String name);
}
