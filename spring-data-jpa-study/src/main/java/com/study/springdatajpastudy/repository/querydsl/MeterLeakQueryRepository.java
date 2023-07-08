package com.study.springdatajpastudy.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.repository
 * @since : 2023/07/08
 */
@RequiredArgsConstructor
@Repository
public class MeterLeakQueryRepository {

  private final JPAQueryFactory queryFactory;
}
