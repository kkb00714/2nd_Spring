package spring.spring_lec.test1.repository;

import spring.spring_lec.test1.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // map을 사용하는 이유?
    // => (실무에서) 동시성 문제가 있기 때문에 공유되는 변수일 경우
    // => Component HashMap 을 사용해야 함.

    private static long sequence = 0L;
    // sequence => 자동적으로 키값을 생성해줌
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        // member의 id값을 세팅
        store.put(member.getId(), member);
        // store에 저장을 함 (Map에 저장이 됨)
        return member;
        // 저장된 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null이 될 수 있을 때,
        // Optional로 감싸서 null이어도 가능하도록 함
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                // 루프를 돌리면서, 멤버에서 파라미터로 넘어온 name과 같은지 확인
                .findAny(); // 찾으면 반환, 못 찾으면 Optional에 null이 포함되어서 반환
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        // store를 비워주는 메서드.
        store.clear();
    }
}
