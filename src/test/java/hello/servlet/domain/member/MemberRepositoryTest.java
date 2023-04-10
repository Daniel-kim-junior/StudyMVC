package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        // given
        Member member1 = new Member("hello", 20);
        // when
        memberRepository.save(member1);
        // then
        Member member2 = memberRepository.findById(member1.getId());

        assertThat(member1).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member("St", 1);
        Member member2 = new Member("St1", 12);

        memberRepository.save(member1);
        memberRepository.save(member2);
        // when
        List<Member> list = memberRepository.findAll();

        // then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(member1, member2);
    }
}