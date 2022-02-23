package hello.core.member;

public interface MemberService {
    //회원 가입, 조회기능이 있어야 한다.
    void join(Member member);

    Member findMember(Long memberId);
}
