package com.study.springdatajpastudy.domain.leak.service;

import com.study.springdatajpastudy.domain.leak.entity.MtdWaterLeakExamGroup;
import com.study.springdatajpastudy.domain.leak.entity.MtdWaterLeakExamWateruser;
import com.study.springdatajpastudy.domain.leak.repository.MtdWaterLeakExamGroupRepository;
import com.study.springdatajpastudy.domain.leak.repository.MtdWaterLeakExamWateruserRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.leak.service
 * @since : 2023/07/08
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class MeterLeakService {

  private final MtdWaterLeakExamGroupRepository groupRepository;
  private final MtdWaterLeakExamWateruserRepository examUserRepository;

  @Transactional
  public void addLeakInfo() {

    MtdWaterLeakExamWateruser use1 = MtdWaterLeakExamWateruser.builder()
        .consumerSid(1L)
        .areaId("00")
        .leakMinUsage(new BigDecimal("1.0"))
        .groupSid(99L)
        .build();
    MtdWaterLeakExamWateruser use2 = MtdWaterLeakExamWateruser.builder()
        .consumerSid(2L)
        .areaId("00")
        .leakMinUsage(new BigDecimal("1.5"))
        .groupSid(99L)
        .build();

    MtdWaterLeakExamWateruser userSave1 = examUserRepository.save(use1);
    MtdWaterLeakExamWateruser userSave2 = examUserRepository.save(use2);

    MtdWaterLeakExamGroup group1 = MtdWaterLeakExamGroup.builder()
        .examNm("TEST-exam1")
        .city("Daegu")
        .groupSid(99L)
        .build();

    MtdWaterLeakExamGroup groupSave1 = groupRepository.save(group1);

    userSave1.setExamGroup(groupSave1);
    userSave1.setExamGroup(groupSave1);
  }

}
