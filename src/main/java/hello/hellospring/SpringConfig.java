package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    private final DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, DataSource dataSource, EntityManager em) {
        this.memberRepository = memberRepository;
        this.dataSource = dataSource;
        this.em = em;
    }

    // 코드로 직접 스프링 빈 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository() {
        // DB를 바꿀 경우 밑의 코드만 변경하면 됨 - 수동 스프링 빈 등록의 장점
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
