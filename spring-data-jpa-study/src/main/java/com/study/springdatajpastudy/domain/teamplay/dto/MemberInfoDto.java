package com.study.springdatajpastudy.domain.teamplay.dto;

import com.study.springdatajpastudy.domain.teamplay.entity.Member;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.dto
 * @since : 2023/07/09
 */
public class MemberInfoDto {

  private String memberName;
  private int age;

  public Member converToEntity() {
    return Member.builder()
        .name(this.memberName)
        .age(this.age)
        .build();
  }
}
