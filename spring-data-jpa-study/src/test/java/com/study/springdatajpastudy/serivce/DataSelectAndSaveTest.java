package com.study.springdatajpastudy.serivce;

import com.study.springdatajpastudy.domain.entity.Meterdaily;
import com.study.springdatajpastudy.domain.entity.Meterinfo;
import com.study.springdatajpastudy.domain.entity.MeterinfoTest;
import com.study.springdatajpastudy.dto.DataDto;
import com.study.springdatajpastudy.repository.querydsl.TeamPlayQueryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.serivce
 * @since : 17.10.23
 */
@ActiveProfiles("refec")
@SpringBootTest
class DataSelectAndSaveTest {

  @Autowired
  private MoveDataService service;
  @Autowired
  TeamPlayQueryRepository queryRepository;

  private List<String> makeModemIds() {
    return Arrays.asList(
        "2308WS679455",
        "2308WS679456",
        "2308WS679457",
        "2308WS679458",
        "2308WS679459"
    );
  }

  @DisplayName("오늘부터 3일간 Meterdaily 데이터 조회")
  @Test
  public void findMeterdailyThreeDaysDataTest() {
    DataDto build = DataDto.builder()
        .fromDate(LocalDate.now().minusDays(3))
        .toDate(LocalDate.now())
        .modemIds(List.of("2308WS679455"))
        .build();
    List<Meterdaily> meterdailyData = queryRepository.findMeterdailyData(build);
    for (Meterdaily meterdailyDatum : meterdailyData) {
      System.out.println("meterdailyDatum = " + meterdailyDatum);
    }
  }

  @DisplayName("오늘부터 3일간 Meterinfo 데이터 조회")
  @Test
  public void findMeterinfoThreeDaysDataTest() {
    DataDto build = DataDto.builder()
        .fromDateTime(LocalDateTime.now().minusDays(3))
        .toDateTime(LocalDateTime.now())
        .modemIds(List.of("2308WS679455"))
        .build();
    List<Meterinfo> meterInfoData = queryRepository.findMeterInfoData(build);

    List<MeterinfoTest> results = new ArrayList<>();
    for (Meterinfo meterInfoDatum : meterInfoData) {
      System.out.println("meterInfoDatum = " + meterInfoDatum);
      results.add(meterInfoDatum.converToMeterinfoTest(11L));
    }
  }
}