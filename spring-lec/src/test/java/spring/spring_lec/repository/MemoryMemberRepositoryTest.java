package spring.spring_lec.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.spring_lec.test1.Member;
import spring.spring_lec.test1.repository.MemberRepository;
import spring.spring_lec.test1.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// 굳이 public을 안 써도 됨 (테스트 케이스니까)
// JUnit 프레임워크를 사용하여 테스트
// 새로 안 사실... 테스트케이스는 순서가 없다..!

//
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        // 테스트 실행이 끝날 때마다 repository를 지움 (콜백메서드)
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // optional로 싸여있는 경우 get을 통해서 가져올 수 있음. => 그러나 좋은 방법은 아니다!
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
