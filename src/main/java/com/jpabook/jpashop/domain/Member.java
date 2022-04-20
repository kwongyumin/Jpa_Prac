package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Member {


    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //읽기전용
    private List<Order> orders = new ArrayList<>();
    //초기화는 바로 해주는 것이 좋다.

}
