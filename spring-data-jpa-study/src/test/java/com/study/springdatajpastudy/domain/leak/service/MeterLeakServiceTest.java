package com.study.springdatajpastudy.domain.leak.service;

import com.study.springdatajpastudy.domain.leak.entity.MtdWaterLeakExamGroup;
import com.study.springdatajpastudy.domain.leak.entity.MtdWaterLeakExamWateruser;
import com.study.springdatajpastudy.domain.leak.repository.MtdWaterLeakExamGroupRepository;
import com.study.springdatajpastudy.domain.leak.repository.MtdWaterLeakExamWateruserRepository;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.leak.service
 * @since : 2023/07/08
 */
@SpringBootTest
class MeterLeakServiceTest {

  @Autowired
  private MtdWaterLeakExamGroupRepository groupRepository;
  @Autowired
  private MtdWaterLeakExamWateruserRepository examUserRepository;
  @Autowired
  MeterLeakService meterLeakService;

  @Transactional
  @Test
  public void test_addLeakInfo() {
    meterLeakService.addLeakInfo();
    List<MtdWaterLeakExamGroup> all = groupRepository.findAll();
    MtdWaterLeakExamGroup mtdWaterLeakExamGroup = all.get(0);
    System.out.println("mtdWaterLeakExamGroup.getExamGroupIdx() = " + mtdWaterLeakExamGroup.getExamGroupIdx());
    Set<MtdWaterLeakExamWateruser> waterLeakExamWaterusers = mtdWaterLeakExamGroup
        .getWaterLeakExamWaterusers();

    List<MtdWaterLeakExamWateruser> all1 = examUserRepository.findAll();
    for (MtdWaterLeakExamWateruser mtdWaterLeakExamWateruser : all1) {
      System.out.println(
          "mtdWaterLeakExamWateruser.getExamGroup().getExamNm() = " + mtdWaterLeakExamWateruser
              .getExamGroup().getExamNm());

    }

  }

}