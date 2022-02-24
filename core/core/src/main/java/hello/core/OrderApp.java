package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//Order Test
public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        //맴버를 만들고 회원가입을 시킨다.
        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //public Order createOrder(Long memberId, String itemName, int itemPrice)
        Order order = orderService.createOrder(memberId, "iemA", 10000);

        //order의 tostring이 실행이된다.
        System.out.println("order = " +order);
        System.out.println("order = " +order.calculatePrice());

    }
}
