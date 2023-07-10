package com.study.springdatajpastudy.domain.teamplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
  @Column(name = "MEMBER_ID")
  @GeneratedValue
  private Long id;

  @Column(name = "USERNAME")
  private String name;

  @Column(name = "AGE")
  private int age;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
  private Team team;

  @Builder
  public Member(Long id, String name, int age,
      Team team) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.team = team;
  }
}
