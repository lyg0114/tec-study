package com.study.springdatajpastudy.domain.entity.id;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MeterdailyTestId implements Serializable {

  @Column(name = "consumer_sid", nullable = false)
  private Long consumerSid;

  @Column(name = "modem_id", nullable = false)
  private String modemId;

  @Column(name = "daily_date", nullable = false)
  private LocalDate dailyDate;


}
