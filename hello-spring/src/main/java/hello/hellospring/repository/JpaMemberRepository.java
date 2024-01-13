package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; // JPA는 EntityManager로 모든게 동작

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    // JPA -> 저장, PK 조회, 삭제, 업데이트 등은 자동으로 됨.
    @Override
    public Member save(Member member) {
        em.persist(member); // JPA가 DB에 알아서 query 날려 객체 저장해줌. (Id도 자동생성)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // 조회할 type, 식별자(Pk)
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny(); // name을 하나만 찾으므로 findAny를 통해 반환
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // JPQL (객체(entity)를 대상으로 query를 날림, table 대상 X)
                .getResultList();
    }
}
