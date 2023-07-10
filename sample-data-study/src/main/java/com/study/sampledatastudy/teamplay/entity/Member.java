package com.study.sampledatastudy.teamplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.entity
 * @since : 2023/07/09
 */
@Data
@Entity
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String name;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  @Column(name = "AGE")
  private int age;

  @Builder
  public Member(Long id, String name, int age,
      Team team) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.team = team;
  }
}
