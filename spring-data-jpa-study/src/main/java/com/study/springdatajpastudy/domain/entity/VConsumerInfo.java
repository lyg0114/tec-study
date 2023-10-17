package com.study.springdatajpastudy.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Data
@NoArgsConstructor
@Table(name = "v_consumer_info")
public class VConsumerInfo {

  @Id
  @Column(name = "mng_id")
  private String mngId;

  @Column(name = "consumer_sid")
  private Long consumerSid;

  @Column(name = "modem_id")
  private String modemId;

  @Column(name = "install_yn")
  private Boolean installYn;
}
