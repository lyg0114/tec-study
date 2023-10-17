package com.study.springdatajpastudy.serivce;

import com.study.springdatajpastudy.domain.entity.Meterdaily;
import com.study.springdatajpastudy.domain.entity.Meterinfo;
import com.study.springdatajpastudy.dto.DataDto;
import com.study.springdatajpastudy.repository.querydsl.TeamPlayQueryRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
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
class MoveDataServiceTest {

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

  @Test
  public void findMeterdailyDataTest() {
    DataDto build = DataDto.builder()
        .fromDate(LocalDate.parse("2023-10-14"))
        .toDate(LocalDate.parse("2023-10-16"))
        .modemIds(List.of("2308WS679457"))
        .build();
    List<Meterdaily> meterdailyData = queryRepository.findMeterdailyData(build);
    for (Meterdaily meterdailyDatum : meterdailyData) {
      System.out.println("meterdailyDatum = " + meterdailyDatum);
    }
  }

  @Test
  public void findMeterInfoDataTest() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DataDto build = DataDto.builder()
        .fromDateTime(LocalDateTime.parse("2023-10-14 00:00:00", formatter))
        .toDateTime(LocalDateTime.parse("2023-10-14 23:59:59", formatter))
        .modemIds(List.of("2308WS679457"))
        .build();
    List<Meterinfo> meterInfoData = queryRepository.findMeterInfoData(build);
    for (Meterinfo meterInfoDatum : meterInfoData) {
      System.out.println("meterInfoDatum = " + meterInfoDatum);
    }
  }
}