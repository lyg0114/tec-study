package com.study.springdatajpastudy.repository.querydsl;

import static com.study.springdatajpastudy.domain.entity.QMeterdaily.meterdaily;
import static com.study.springdatajpastudy.domain.entity.QMeterinfo.meterinfo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.springdatajpastudy.domain.entity.Meterdaily;
import com.study.springdatajpastudy.domain.entity.Meterinfo;
import com.study.springdatajpastudy.dto.DataDto;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.repository.querydsl
 * @since : 2023/07/10
 */
@RequiredArgsConstructor
@Repository
public class TeamPlayQueryRepository {

  private final JPAQueryFactory queryFactory;

  public List<Meterdaily> findMeterdailyData(DataDto dto) {
    return queryFactory
        .selectFrom(meterdaily)
        .where(
            meterdaily.meterdailyId.modemId.in(dto.getModemIds()),
            meterdaily.meterdailyId.dailyDate.between(
                dto.getFromDate(),
                dto.getToDate()
            )
        ).orderBy(
            meterdaily.meterdailyId.modemId.desc(),
            meterdaily.meterdailyId.dailyDate.desc()
        )
        .fetch();
  }

  public List<Meterinfo> findMeterInfoData(DataDto dto) {
    return queryFactory
        .selectFrom(meterinfo)
        .where(
            meterinfo.meterinfoId.modemId.in(dto.getModemIds()),
            meterinfo.meterinfoId.meteringDate.between(
                dto.getFromDateTime(),
                dto.getToDateTime()
            )
        ).orderBy(
            meterinfo.meterinfoId.modemId.desc(),
            meterinfo.meterinfoId.meteringDate.desc()
        )
        .fetch();
  }
}
