package spring.spring_lec.test1.repository;

import spring.spring_lec.test1.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByNickname(String nickname);
    List<Member> findAll();
}
