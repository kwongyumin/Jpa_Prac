package com.jpabook.jpashop.service;


import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional
//데이터 변경은 트랜잭셔널 안에서 처리된다.
//스프링에서 제공하는 트랜잭셔널 어노테이션을 사용하는게 쓸 수 있는 기능들이 많다.
public class MemberService {


    private final MemberRepository memberRepository;

    //회원가입 기능 구현
    @Transactional
    public Long join(Member member){

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    // 회원 전체 조회 기능 구현
    // 조회 트랜잭셔널은 readOnly = true 를 사용한다.
    // readOnly 읽기전용 트랙잰션을 사용 시 리소스 사용을 최적화 한다.
    @Transactional(readOnly = true)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


}
