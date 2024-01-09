package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    // static으로 구현 -> 객체가 아닌 클래스 단위로 붙음.
    private static Map<Long, Member> store = new HashMap<>(); // key, value : id, member 객체으로 메모리에 저장
    private static long sequence = 0L; // 자동으로 key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id를 하나 늘려 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Null을 대비하여 Optional로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // param으로 넘겨받은 name과 같은 member를 리턴 (처음에 찾으면 해당 객체를 반환)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
