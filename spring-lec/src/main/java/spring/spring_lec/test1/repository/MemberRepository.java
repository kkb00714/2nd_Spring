package spring.spring_lec.test1.repository;

import spring.spring_lec.test1.Member;

import java.util.List;
import java.util.Optional;

// 인터페이스 사용하는 이유 (추상화, 유연성, 테스트 용이성, 다형성)
// => 특정 구현에 종속되지 않고 동작 정의를 위함,
// => 이후 구현체를 변경해서 클라이언트 코드에 영향이 없음,
// => 모의 객체를 사용하여 테스트하기가 쉬움,
// =>  다양한 클래스가 동일한 메서드를 구현할 수 있음

public interface MemberRepository {
    
    // 멤버를 저장하는 메서드
    Member save(Member member);

    // Optiona로 감싸는 이유 => 주로 null을 처리하기 위함
    // => 메서드가 값이 없을 수 있음을 주로 명시적으로 명세함
    // => null을 직접 사용했을 때 NullPointerException 발생 위험을 줄임
    
    // 회원id로 멤버를 검색하는 메서드
    Optional<Member> findById(Long id);
    
    // 회원name으로 멤버를 검색 => Optional<Member> 로 반환
    Optional<Member> findByName(String name);
    
    // 회원nickname으로 멤버를 검색 => Optional<Member> 로 반환
    Optional<Member> findByNickname(String nickname);
    
    // 모든 회원 정보 검색 => 리스트로 반환
    List<Member> findAll();
}
