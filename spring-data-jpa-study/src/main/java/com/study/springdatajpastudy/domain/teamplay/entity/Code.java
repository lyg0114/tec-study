package com.study.springdatajpastudy.domain.teamplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.entity
 * @since : 2023/07/20
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Code {

  @Id
  @Column(nullable = false)
  private String code;

  @Column
  private String codeNm;

  @Column
  private String explain;
}
