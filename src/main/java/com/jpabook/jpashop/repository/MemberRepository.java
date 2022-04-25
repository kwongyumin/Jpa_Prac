package com.jpabook.jpashop.repository;


import com.jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //실행 어노테이션 빈의 하위 컴포넌트 스캔 대상
@RequiredArgsConstructor
public class MemberRepository {

  //  @PersistenceContext// 생성된 엔티티매니저를 스프링이 주입해준다.
    // 스프링부트가 @Autowired 로도 em을 주입되도록 지원
    private final EntityManager em;


    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
       return em.find(Member.class , id);
    }

    public List<Member> findAll(){

        return em.createQuery("select m from Member m", Member.class)
                 .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name) //전달 파라미터를 바인딩 ,
                .getResultList();
    }

}
