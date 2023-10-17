package com.study.springdatajpastudy.domain.entity;

import com.study.springdatajpastudy.domain.entity.id.MeterinfoId;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Data
@Entity
@Table(name = "meterinfo")
@NoArgsConstructor
@AllArgsConstructor
public class Meterinfo {

  @EmbeddedId
  private MeterinfoId meterinfoId;

  @Column(name = "receiving_date", nullable = false)
  private LocalDateTime receivingDate;

  @Column(name = "metering_value", nullable = false, precision = 10, scale = 3)
  private BigDecimal meteringValue;

  @Column(name = "metering_usage", nullable = false, precision = 10, scale = 3)
  private BigDecimal meteringUsage;

  @Column(name = "metering_temp", nullable = false, precision = 10, scale = 3)
  private BigDecimal meteringTemp;

  @Column(name = "metering_state", nullable = false)
  private String meteringState;

  @Column(name = "metering_signal01", nullable = false)
  private Boolean meteringSignal01;

  @Column(name = "metering_signal02", nullable = false)
  private Boolean meteringSignal02;

  @Column(name = "metering_signal03", nullable = false)
  private Boolean meteringSignal03;

  @Column(name = "metering_signal04", nullable = false)
  private Integer meteringSignal04;

  @Column(name = "modem_rssi")
  private Integer modem_rssi;

  @Column(name = "modem_signal01")
  private Integer modemSignal01;

  @Column(name = "modem_signal02")
  private Boolean modemSignal02;

  @Column(name = "modem_signal03")
  private Boolean modemSignal03;

  @Column(name = "info_tag")
  private String infoTag;

  @Column(name = "info_tag_detail")
  private String infoTagDetail;

  @Column(name = "acube_signal01")
  private Integer acubeSignal01;

  @Column(name = "acube_signal02")
  private Integer acubeSignal02;

  @Column(name = "insert_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDate insertDate;

  @Column(name = "update_date")
  private LocalDate updateDate;

}
