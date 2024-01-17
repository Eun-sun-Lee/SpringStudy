package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + "price= " + price);
        this.price = price; // 여기가 문제 ! (주문을 한 뒤, 가격을 order에 저장하는게 목적이었음.)
    }

    public int getPrice(){
        return price;
    }
}
