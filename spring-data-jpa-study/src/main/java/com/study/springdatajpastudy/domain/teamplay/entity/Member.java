package com.study.springdatajpastudy.domain.teamplay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.entity
 * @since : 2023/07/09
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long memberId;

  @Column(name = "USERNAME")
  private String name;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  @Column(name = "AGE")
  private int age;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinColumn(
      name = "MEMBER_TYPE_CD",
      referencedColumnName = "code",
      insertable = false, updatable = false,
      nullable = false
  )
  private Code memberTypeCd;
}
