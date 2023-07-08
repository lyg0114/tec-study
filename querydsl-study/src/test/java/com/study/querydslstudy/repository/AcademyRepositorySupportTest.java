package com.study.querydslstudy.repository;

import com.study.querydslstudy.entity.Academy;
import java.util.List;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : iyeong-gyo
 * @package : com.study.querydslstudy.repository
 * @since : 2023/07/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AcademyRepositorySupportTest {

  @Autowired
  private AcademyRepository academyRepository;
  @Autowired
  private AcademyRepositorySupport academyRepositorySupport;

  @After
  public void tearDown() throws Exception {
    academyRepository.deleteAllInBatch();
  }

  @Test
  public void querydsl_기본_기능_확인() {
    //given
    String name = "younggyo";
    String address = "younggyo0114@gmail.com";
    academyRepository.save(new Academy(name, address));

    //when
    List<Academy> result = academyRepositorySupport.findByName(name);

    //then
    Assertions.assertEquals(result.size(), 1);
    Assertions.assertEquals(result.get(0).getAddress(), address);
  }
}