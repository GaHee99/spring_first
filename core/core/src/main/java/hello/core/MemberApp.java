package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    //단축키 : psvm
    //매일 main 메소드로 확인하는 것은 좋은 방법이 아님
    //그래서 JUIT 이라는 프레임워크를 사용
    public static void main(String[] args) {
        //AppConfig를 만들어야 한다.
      //  AppConfig appConfig = new AppConfig();
       // MemberService memberService = appConfig.memberService();

        //스프링 컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        //그냥 아이디를 1로하면 컴파일 오류난다 (1L : Long)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findeMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = "+ findeMember.getName());

    }
}
