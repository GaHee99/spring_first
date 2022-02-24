package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    //주문을 만드는 class
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //맴버를 찾고
        Member member = memberRepository.findById(memberId);
        //맴버를 넘기고 (discount얼마나 해야하는지)
        //단일 체계 원칙을 잘 지킨것이다.
        //할인쪽은 order에서 관여하지 않고 , 걍 discount class를 이용하여 할인값을 반환만 받음
        //할인쪽에 문제가 생기면 할인쪽만 고치며 돼서 유지보수 쉽다. (주문까지 고칠 필요는 없다)
        int discountPrice = discountPolicy.discount(member,itemPrice);


        // public Order(Long memberId, String itemName, int itemPrice, int discountPrice)
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
