package com.study.springdatajpastudy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "mtd_water_leak_exam_group")
@NoArgsConstructor
public class MtdWaterLeakExamGroup implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exam_group_idx")
  private Long examGroupIdx;

  @OneToMany(mappedBy = "examGroup")
  private Set<MtdWaterLeakExamWateruser> waterLeakExamWaterusers = new HashSet<>();

  @Column(name = "area_id")
  private String area_id;

  @Column(name = "created_date")
  private LocalDate created_date;

  @Column(name = "created_dept")
  private String created_dept;

  @Column(name = "created_user")
  private String created_user;

  @Column(name = "exam_estimated_date")
  private LocalDate examEstimatedDate;

  @Column(name = "exam_finished_dt")
  private LocalDate examFinishedDt;

  @Column(name = "exam_nm")
  private String examNm;

  @Column(name = "exam_plan_start_dt")
  private LocalDate examPlanStartDt;

  @Column(name = "exam_started_dt")
  private LocalDate examStartedDt;

  @Column(name = "exam_status")
  private String examStatus;

  @Column(name = "group_sid")
  private Long groupSid;

  @Column(name = "last_modified_date")
  private LocalDate lastModifiedDate;

  @Column(name = "last_modified_dept")
  private String lastModifiedDept;

  @Column(name = "last_modified_user")
  private String lastModifiedUser;

  @Column(name = "target_cnt")
  private Integer targetCnt;

  private String city;

  @Builder
  public MtdWaterLeakExamGroup(Long examGroupIdx,
      Set<MtdWaterLeakExamWateruser> waterLeakExamWaterusers, String area_id,
      LocalDate created_date, String created_dept, String created_user,
      LocalDate examEstimatedDate, LocalDate examFinishedDt, String examNm,
      LocalDate examPlanStartDt, LocalDate examStartedDt, String examStatus, Long groupSid,
      LocalDate lastModifiedDate, String lastModifiedDept, String lastModifiedUser,
      Integer targetCnt, String city) {
    this.examGroupIdx = examGroupIdx;
    this.waterLeakExamWaterusers = waterLeakExamWaterusers;
    this.area_id = area_id;
    this.created_date = created_date;
    this.created_dept = created_dept;
    this.created_user = created_user;
    this.examEstimatedDate = examEstimatedDate;
    this.examFinishedDt = examFinishedDt;
    this.examNm = examNm;
    this.examPlanStartDt = examPlanStartDt;
    this.examStartedDt = examStartedDt;
    this.examStatus = examStatus;
    this.groupSid = groupSid;
    this.lastModifiedDate = lastModifiedDate;
    this.lastModifiedDept = lastModifiedDept;
    this.lastModifiedUser = lastModifiedUser;
    this.targetCnt = targetCnt;
    this.city = city;
  }
}

