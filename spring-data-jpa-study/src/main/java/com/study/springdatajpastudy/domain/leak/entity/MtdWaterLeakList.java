package com.study.springdatajpastudy.domain.leak.entity;

import com.study.springdatajpastudy.domain.leak.entity.id.MtdWaterLeakListId;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "mtd_water_leak_list")
@NoArgsConstructor
@AllArgsConstructor
public class MtdWaterLeakList {

  @EmbeddedId
  private MtdWaterLeakListId id;

  private String address;

  @Column(name = "alert_date")
  private LocalDate alertDate;

  private String caliber;

  @Column(name = "consumer_name")
  private String consumerName;

  @Column(name = "consumer_sid")
  private String consumerSid;

  @Column(name = "end_date")
  private String endDate;

  @Column(name = "is_continous")
  private Boolean isContinous;

  @Column(name = "is_over")
  private Boolean isOver;

  @Column(name = "leak_predict", precision = 19, scale = 2)
  private BigDecimal leakPredict;

  @Column(name = "start_date")
  private String startDate;

}
