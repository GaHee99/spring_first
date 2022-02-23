package hello.core.member;

//memberService의 구현체이다.
public class MemberServiceImpl implements MemberService{

    //회원 가입을 하고, 회원 정보를 찾으려면 MemberRepository가 필요하다.
    // (회원 저장소가 필요하다는 말)
    //MemberRepository는 인터페이스기 때문에 구현 객체를 선택 해 줘야 한다.
    //여기서는 MemoryMemberRepository()가 구현체이다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
