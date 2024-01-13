package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 자동으로 id를 생성해줌.
    private Long id;

//    @Column(name="username") // DB의 컬럼명 "username"과 mapping 됨.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
