package com.study.springdatajpastudy.domain.entity;

import com.study.springdatajpastudy.domain.entity.id.MeterdailyId;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@Data
@Entity
@Table(name = "meterdaily")
@NoArgsConstructor
@AllArgsConstructor
public class Meterdaily {

  @EmbeddedId
  private MeterdailyId meterdailyId;

  @Column(name = "metering_date", nullable = false)
  private LocalDateTime meteringDate;

  @Column(name = "daily_past_value", nullable = false)
  private Integer dailyPastValue;

  @Column(name = "daily_last_value", nullable = false)
  private Integer dailyLastValue;

  @Column(name = "daily_usage", nullable = false)
  private Integer dailyUsage;

  @Column(name = "meter_backflow", nullable = false)
  private boolean meterBackflow;

  @Column(name = "meter_battery", nullable = false, precision = 2, scale = 1)
  private int meterBattery;

  @Column(name = "meter_overflow", nullable = false)
  private boolean meterOverflow;

  @Column(name = "meter_waterleak", nullable = false)
  private boolean meterWaterleak;

  @Column(name = "metering_temp", precision = 10, scale = 1)
  private BigDecimal meteringTemp;

  @Column(name = "modem_rssi")
  private String modemRssi;

  @Column(name = "modem_connect")
  private boolean modemConnect;

  @Column(name = "modem_battery", nullable = false, precision = 2, scale = 1)
  private BigDecimal modemBattery;

  @Column(name = "time_sync")
  private boolean timeSync;

  @Column(name = "daily_tag", nullable = false)
  private String dailyTag;

  @Column(name = "insert_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDate insertDate;

  @Column(name = "update_date")
  private LocalDate updateDate;

  public MeterdailyTest converToMeterDailyTest(Long consumerSid) {
    return null;
  }
}
