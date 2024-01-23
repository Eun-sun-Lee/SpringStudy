package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // static이기 때문에 new memberRepository()를 통해 많이 생성되어도 하나만 생성 및 사용
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){ // 생성자
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); // store에 있는 모든 값들을 꺼내 새로운 ArrayList에 담아 리턴 (store에 있는 list 형태의 값 자체를 보호(변경 방지)하기 위해 새로운 ArrayList로 리턴)
    }

    public void clearStore(){
        store.clear();
    }
}
