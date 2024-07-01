package spring.spring_lec.test2;

import spring.spring_lec.test1.Member;
import spring.spring_lec.test1.repository.MemberRepository;
import spring.spring_lec.test1.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입 -
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 X
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });

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



}
