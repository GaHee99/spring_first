package hello.core.member;

//memberService의 구현체이다.
public class MemberServiceImpl implements MemberService{

    //추상화에만 의존한다
    private final MemberRepository memberRepository ;

    //생성자를 통해서, Repository객체 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
