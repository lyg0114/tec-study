package com.study.springdatajpastudy.domain.leak.service;

import com.study.springdatajpastudy.domain.leak.entity.MtdWaterLeakExamGroup;
import com.study.springdatajpastudy.domain.leak.entity.MtdWaterLeakExamWateruser;
import com.study.springdatajpastudy.domain.leak.repository.MtdWaterLeakExamGroupRepository;
import com.study.springdatajpastudy.domain.leak.repository.MtdWaterLeakExamWateruserRepository;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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
  @Autowired
  EntityManager em;

  @Test
  @Transactional
  @Rollback(false)
  public void test_addLeakInfo_2() {
    meterLeakService.addLeakInfo();

    em.flush();
    em.clear();

    List<MtdWaterLeakExamWateruser> all = examUserRepository.findAll();
    for (MtdWaterLeakExamWateruser user : all) {
      System.out.println("user.getConsumerSid() = " + user.getConsumerSid());
      System.out.println("user.getExamGroup() = " + user.getExamGroup().getExamNm());
    }
  }

  @Test
  @Transactional
  @Rollback(false)
  public void test_addLeakInfo_1() {
    meterLeakService.addLeakInfo();

    em.flush();
    em.clear();

    List<MtdWaterLeakExamGroup> groups = groupRepository.findAll();
    MtdWaterLeakExamGroup group = groups.get(0);
    Set<MtdWaterLeakExamWateruser> waterLeakExamWaterusers = group.getWaterLeakExamWaterusers();
    for (MtdWaterLeakExamWateruser waterLeakExamWateruser : waterLeakExamWaterusers) {
      System.out.println(
          "waterLeakExamWateruser.getExamGroup() = " + waterLeakExamWateruser.getExamGroup().getExamNm());
    }
  }
}