package com.study.springdatajpastudy.domain.entity;

import com.study.springdatajpastudy.domain.entity.id.MeterinfoId;
import com.study.springdatajpastudy.domain.entity.id.MeterinfoTestId;
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

  public MeterinfoTest converToMeterinfoTest(Long consumerSid) {
    MeterinfoTest.MeterinfoTestBuilder builder = MeterinfoTest.builder();
    MeterinfoId meterinfoId = this.getMeterinfoId();
    builder.meterinfoTestId(new MeterinfoTestId(
        consumerSid, meterinfoId.getModemId(), meterinfoId.getMeteringDate()
    ));
    builder.receivingDate(this.receivingDate);
    builder.meteringValue(this.meteringValue);
    builder.meteringUsage(this.meteringUsage);
    builder.meteringTemp(this.meteringTemp);
    builder.meteringState(this.meteringState);
    builder.meteringSignal01(this.meteringSignal01);
    builder.meteringSignal02(this.meteringSignal02);
    builder.meteringSignal03(this.meteringSignal03);
    builder.meteringSignal04(this.meteringSignal04);
    builder.modem_rssi(this.modem_rssi);
    builder.modemSignal01(this.modemSignal01);
    builder.modemSignal02(this.modemSignal02);
    builder.modemSignal03(this.modemSignal03);
    builder.infoTag(this.infoTag);
    builder.infoTagDetail(this.infoTagDetail);
    builder.acubeSignal01(this.acubeSignal01);
    builder.acubeSignal02(this.acubeSignal02);
    builder.insertDate(this.insertDate);
    builder.updateDate(this.updateDate);
    return builder.build();
  }
}
