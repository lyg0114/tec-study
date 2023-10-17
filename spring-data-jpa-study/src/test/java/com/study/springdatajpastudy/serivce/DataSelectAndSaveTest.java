package com.study.springdatajpastudy.serivce;

import com.study.springdatajpastudy.domain.entity.Meterdaily;
import com.study.springdatajpastudy.domain.entity.MeterdailyTest;
import com.study.springdatajpastudy.domain.entity.Meterinfo;
import com.study.springdatajpastudy.domain.entity.MeterinfoTest;
import com.study.springdatajpastudy.dto.DataDto;
import com.study.springdatajpastudy.repository.MeterDailyTestRepository;
import com.study.springdatajpastudy.repository.MeterinfoTestRepository;
import com.study.springdatajpastudy.repository.querydsl.TeamPlayQueryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
  private TeamPlayQueryRepository queryRepository;
  @Autowired
  private MeterinfoTestRepository meterinfoTestRepository;
  @Autowired
  private MeterDailyTestRepository meterDailyTestRepository;

  private List<String> makeModemIds() {
    return Arrays.asList(
        "2308WS679455",
        "2308WS679456",
        "2308WS679457",
        "2308WS679458",
        "2308WS679459"
    );
  }

  @DisplayName("오늘부터 3일간 Meterinfo 데이터 조회후 MeterinfoTest갱신")
  @Test
  public void findMeterinfoThreeDaysDataAndSaveTest() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DataDto build = DataDto.builder()
        .fromDateTime(LocalDateTime.now().minusDays(3))
        .toDateTime(LocalDateTime.parse("2023-10-20 23:59:59", formatter))
        .modemIds(makeModemIds())
        .build();
    List<Meterinfo> meterInfoData = queryRepository.findMeterInfoData(build);

    List<MeterinfoTest> meterInfoResults = new ArrayList<>();
    for (Meterinfo meterInfoDatum : meterInfoData) {
      meterInfoResults.add(meterInfoDatum.converToMeterinfoTest(
          getConsumerSid(meterInfoDatum.getMeterinfoId().getModemId()))
      );
    }
    meterinfoTestRepository.deleteAll();
    meterinfoTestRepository.saveAll(meterInfoResults);
  }

  @DisplayName("오늘부터 3일간 MeterDaily 데이터 조회후 MeterDailyTest갱신")
  @Test
  public void findMeterdailyThreeDaysDataAndSaveTest() {
    DataDto build = DataDto.builder()
        .fromDate(LocalDate.now().minusDays(3))
        .toDate(LocalDate.parse("2023-10-20"))
        .modemIds(makeModemIds())
        .build();

    List<MeterdailyTest> meterDailyresults = new ArrayList<>();
    List<Meterdaily> meterdailyDatas = queryRepository.findMeterdailyData(build);
    for (Meterdaily meterdaily : meterdailyDatas) {
      System.out.println("meterdailyDatum = " + meterdaily);
      meterDailyresults.add(meterdaily.converToMeterDailyTest(
          getConsumerSid(meterdaily.getMeterdailyId().getModemId())))
      ;
    }
    meterDailyTestRepository.deleteAll();
    meterDailyTestRepository.saveAll(meterDailyresults);
  }

  private Long getConsumerSid(String modemId) {
    if (modemId.equals("2308WS679457")) {
      return 8L;
    }
    if (modemId.equals("2308WS679455")) {
      return 11L;
    }
    if (modemId.equals("2308WS679456")) {
      return 7L;
    }
    if (modemId.equals("2308WS679458")) {
      return 9L;
    }
    if (modemId.equals("2308WS679459")) {
      return 10L;
    }
    return 0L;
  }
}