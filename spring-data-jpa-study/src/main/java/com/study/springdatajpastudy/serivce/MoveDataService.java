package com.study.springdatajpastudy.serivce;

import com.study.springdatajpastudy.repository.MeterDailyRepository;
import com.study.springdatajpastudy.repository.MeterDailyTestRepository;
import com.study.springdatajpastudy.repository.MeterinfoRepository;
import com.study.springdatajpastudy.repository.MeterinfoTestRepository;
import com.study.springdatajpastudy.repository.querydsl.TeamPlayQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.serivce
 * @since : 17.10.23
 */
@RequiredArgsConstructor
@Service
public class MoveDataService {

  private final MeterDailyRepository meterDailyRepository;
  private final MeterDailyTestRepository meterDailyTestRepository;
  private final MeterinfoRepository meterinfoRepository;
  private final MeterinfoTestRepository meterinfoTestRepository;

  private final TeamPlayQueryRepository queryRepository;

  public void moveFromDailytoTestDaily() {
  }

  public void moveFromInfotoTestInfo() {
  }

}
