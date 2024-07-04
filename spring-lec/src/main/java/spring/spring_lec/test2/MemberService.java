package spring.spring_lec.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spring_lec.test1.Member;
import spring.spring_lec.test1.repository.MemberRepository;
import spring.spring_lec.test1.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// MemberService는 비즈니스 로직을 처리하며,
// 데이터 저장소(MemberRepository)를 통해 간접적으로 상호작용함.

// MemberService 클래스는 서비스 계층으로, 비즈니스 로직 담당!
// MemberMemoryRepository가 데이터 접근 계층이고, 이 위에 있는 서비스 계층.

// => 클라이언트가 요청한 작업을 처리하고 필요한 데이터 작업을 위해 레포지토리 호출.
// ※ 한마디로 서비스 계층은 비즈니스 로직을 캡슐화하고 데이터 접근 계층과 상호작용함.
public class MemberService {
    // Ctrl + Shift + T => 테스트 자동화 생성

    private final MemberRepository memberRepository;

    // (구조체) MemberService 클래스가 memberRepository 인터페이스를 주입받음.

    public MemberService(MemberRepository memberRepository ) {
        this.memberRepository = memberRepository;
    }


    // 회원가입 - 자바 람다함수 복습해볼 것.
    // join 메서드 => 회원가입 처리
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 X
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });

        //
        memberRepository.findByName(member.getName());
        memberRepository.save(member);
        return member.getId(); // 아이디 반환
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 한명 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Prof+ 닉네임 조회하기 만들기
    public Optional<Member> findNickname(String memberNickname) {
        return memberRepository.findByNickname(memberNickname);
    }

}
