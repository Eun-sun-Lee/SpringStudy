package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장 시 저장된 회원 반환
    Optional<Member> findById(Long id); // 저장소에서 id로 회원 찾기
    Optional<Member> findByName(String name); // Optional : Null 시 Null을 그대로 반환하는게 아닌 optional로 감싸서 반환
    List<Member> findAll(); // 전체 회원 리턴
}
