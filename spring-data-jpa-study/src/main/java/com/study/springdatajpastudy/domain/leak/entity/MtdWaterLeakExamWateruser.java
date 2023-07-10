package com.study.springdatajpastudy.domain.leak.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "mtd_water_leak_exam_wateruser")
@NoArgsConstructor
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MtdWaterLeakExamWateruser implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exam_wateruser_idx")
  private Long examWateruserIdx;

  @ManyToOne
  @JoinColumn(name = "exam_group_idx")
  private MtdWaterLeakExamGroup examGroup;

  @OneToMany
  @JoinColumn(name = "exam_wateruser_idx")
  private Set<MtdMeterinfoLeak> mtdMeterinfoLeaks;

  @Column(name = "area_id")
  private String areaId;

  private String dividarea;

  private String dongno;

  @Column(name = "exam_result")
  private String examResult;

  @Column(name = "group_sid")
  private Long groupSid;

  @Column(name = "leak_min_usage", precision = 10, scale = 3)
  private BigDecimal leakMinUsage;

  @Column(name = "consumer_sid")
  private Long consumerSid;

  private String city;

  @Builder
  public MtdWaterLeakExamWateruser(Long examWateruserIdx,
      MtdWaterLeakExamGroup examGroup,
      Set<MtdMeterinfoLeak> mtdMeterinfoLeaks, String areaId, String dividarea,
      String dongno, String examResult, Long groupSid, BigDecimal leakMinUsage,
      Long consumerSid, String city) {
    this.examWateruserIdx = examWateruserIdx;
    this.examGroup = examGroup;
    this.mtdMeterinfoLeaks = mtdMeterinfoLeaks;
    this.areaId = areaId;
    this.dividarea = dividarea;
    this.dongno = dongno;
    this.examResult = examResult;
    this.groupSid = groupSid;
    this.leakMinUsage = leakMinUsage;
    this.consumerSid = consumerSid;
    this.city = city;
  }
}
