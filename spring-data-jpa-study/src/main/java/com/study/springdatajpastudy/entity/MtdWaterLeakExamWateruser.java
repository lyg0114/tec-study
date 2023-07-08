package com.study.springdatajpastudy.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "mtd_water_leak_exam_wateruser")
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MtdWaterLeakExamWateruser implements Serializable {

  @Id
  @Column(name = "exam_wateruser_idx")
  private Long examWateruserIdx;

  @OneToMany
  @JoinColumn(name = "exam_wateruser_idx")
  private Set<MtdMeterinfoLeak> mtdMeterinfoLeaks;

  @OneToMany
  @JoinColumn(name = "exam_group_idx")
  private Set<MtdWaterLeakExamGroup> mtdWaterLeakExamGroupEntities;

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

  @Column(name = "exam_group_idx")
  private Long examGroupIdx;

  private String city;
}
