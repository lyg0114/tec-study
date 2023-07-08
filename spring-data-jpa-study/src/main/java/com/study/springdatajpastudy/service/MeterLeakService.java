package com.study.springdatajpastudy.service;

import com.study.springdatajpastudy.dto.MtdWaterLeakInfo;
import com.study.springdatajpastudy.entity.MtdWaterLeakExamGroup;
import com.study.springdatajpastudy.entity.MtdWaterLeakExamWateruser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.service
 * @since : 2023/07/08
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class MeterLeakService {

  private final MtdWaterLeakExamGroup group;
  private final MtdWaterLeakExamWateruser examUser;

  public void addLeakInfo(MtdWaterLeakInfo info) {

  }

}
