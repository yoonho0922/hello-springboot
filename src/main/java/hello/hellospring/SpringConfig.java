package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // 코드로 직접 스프링 빈 등록

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // DB를 바꿀 경우 밑의 코드만 변경하면 됨 - 수동 스프링 빈 등록의 장점
        return new MemoryMemberRepository();
    }
}
