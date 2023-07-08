package com.study.springdatajpastudy.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.dto
 * @since : 2023/07/08
 */
@Data
public class MtdWaterLeakInfo {

  private String area_id;
  private String created_user;
  private String examNm;
  private LocalDate examPlanStartDt;
  private LocalDate examStartedDt;
  private List<Long> consumers;
}
