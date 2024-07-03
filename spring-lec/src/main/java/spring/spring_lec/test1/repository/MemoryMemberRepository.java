package spring.spring_lec.test1.repository;

import spring.spring_lec.test1.Member;

import java.util.*;

// MemoryMemberRepository는 데이터 저장소에 직접 접근하며 데이터 저장 & 조회

// MemberRepository (Interface)의 구현체
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // map을 사용하는 이유?
    // => (실무에서) 동시성 문제가 있기 때문에 공유되는 변수일 경우
    // => Component HashMap 을 사용해야 함.

    private static long sequence = 0L;
    // sequence => 자동적으로 키값을 생성해줌 (회원의 id)
    
    // 회원 정보를 저장하는 메서드
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        // member의 id값을 증가시켜서 회원 id 세팅
        store.put(member.getId(), member);
        // store에 저장 (Map에 저장이 됨)
        return member;
        // 저장된 Member 객체 반환
    }

    // store에 해당하는 ID로 Member 객체를 찾아 반환
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // 값이 없을 경우 Optional.empty()를 반환
    }

    // store에 해당하는 Name으로 Member 객체를 찾아 반환
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                // store에 저장된 모든 Member 객체를 스트림으로 변환 
                // => 컬렉션에 저장된 요소들의 연산을 가능하게 변환한다는 의미

                .filter(member -> member.getName().equals(name))
                // 루프를 돌리면서, 각 Member 객체의 이름을 찾음
                .findAny(); // 찾으면 반환, 못 찾으면 Optional.empty() 가 반환됨
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        return Optional.empty();
    }

    // store에 저장된 모든 회원 정보를 리스트로 반환
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // store에 저장된 모든 값을 리스트로 변환하여 반환
    }

    public void clearStore() {
        // store를 비워주는 메서드. (테스트 후 초기화를 위함)
        store.clear();
    }
}
