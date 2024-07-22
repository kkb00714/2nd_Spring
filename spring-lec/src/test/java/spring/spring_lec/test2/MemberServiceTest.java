package spring.spring_lec.test2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.spring_lec.test1.domain.Member;
import spring.spring_lec.test1.service.MemberService;
import spring.spring_lec.test1.repository.MemberRepository;
import spring.spring_lec.test1.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemberRepository memberRepository;

    // 외부에서 memberRepository를 주입 => DI(Dependency Injection)
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원가입() {
        // give when then 문법 => 테스트
        // given => 이러한 상황이 주어졌을 때
        Member member = new Member();
        member.setName("hello");

        // when => 실행했을 때
        Long saveId = memberService.join(member);

        // then => 이러한 결과가 나와야 함
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring_boot");

        Member member2 = new Member();
        member2.setName("spring_boot");

        // when
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            // 설정해 둔 예외명과 일치하면 성공
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
        }

        // then


    }

    @Test
    void 전체조회() {
    }

    @Test
    void 한명조회() {
    }

    @Test
    void 닉네임조회() {
    }
}