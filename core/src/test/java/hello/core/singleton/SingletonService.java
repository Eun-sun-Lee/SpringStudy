package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    // 자기 자신을 내부에 private으로 하나 가지는데, static -> 클래스 level에 올라가기 때문에 하나만 존재하게 됨.
    // 1. 자바가 뜰 때 : static 영역의 new SingletonService()를 자기 자신 객체를 생성해서 인스턴스 참조에 넣어놓음.
    // 인스턴스의 참조를 꺼낼 수 있는 방법은 return instance로만 가능

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        // 외부에서 객체 생성을 막기 위해 private으로 생성자를 만듦.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
