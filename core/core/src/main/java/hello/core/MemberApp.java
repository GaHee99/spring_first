package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    //단축키 : psvm
    //매일 main 메소드로 확인하는 것은 좋은 방법이 아님
    //그래서 JUIT 이라는 프레임워크를 사용
    public static void main(String[] args) {
        //맴버 서비스라는 인터페이스를 사용하고, 구현체는 MemberServiceImpl
        MemberService memberService = new MemberServiceImpl();
        //그냥 아이디를 1로하면 컴파일 오류난다 (1L : Long)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findeMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = "+ findeMember.getName());

    }
}
