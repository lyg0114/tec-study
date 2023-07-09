package com.study.springdatajpastudy.domain.leak.entity;

import com.study.springdatajpastudy.domain.leak.entity.id.MtdMeterinfoLeakId;
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
@Table(name = "mtd_meterinfo_leak")
@NoArgsConstructor
@AllArgsConstructor
public class MtdMeterinfoLeak {

  @EmbeddedId
  private MtdMeterinfoLeakId id;

  @Column(name = "acube_signal01")
  private Integer acubeSignal01;

  @Column(name = "acube_signal02")
  private Integer acubeSignal02;

  @Column(name = "criterion_date")
  private LocalDate criterionDate;

  @Column(name = "group_sid")
  private Long groupSid;

  @Column(name = "info_tag")
  private String infoTag;

  @Column(name = "metering_signal01")
  private Integer meteringSignal01;

  @Column(name = "metering_signal02")
  private Integer meteringSignal02;

  @Column(name = "metering_signal03")
  private Integer meteringSignal03;

  @Column(name = "metering_signal04")
  private Integer meteringSignal04;

  @Column(name = "metering_state")
  private String meteringState;

  @Column(name = "metering_usage", precision = 10, scale = 3)
  private BigDecimal meteringUsage;

  @Column(name = "metering_value", precision = 10, scale = 3)
  private BigDecimal meteringValue;

  @Column(name = "modem_rssi")
  private Integer modemRssi;

  @Column(name = "modem_signal01")
  private Integer modemSignal01;

  @Column(name = "modem_signal02")
  private Integer modemSignal02;

  @Column(name = "modem_signal03")
  private Integer modemSignal03;


}
