package com.study.springdatajpastudy.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
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
}
