package com.study.querydslstudy.repository;

import static com.study.querydslstudy.entity.QAcademy.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydslstudy.entity.Academy;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

/**
 * @author : iyeong-gyo
 * @package : com.study.querydslstudy.repository
 * @since : 2023/07/08
 */
@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {

  private final JPAQueryFactory queryFactory;

  public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
    super(Academy.class);
    this.queryFactory = queryFactory;
  }

  public List<Academy> findByName(String name) {
    return queryFactory
        .selectFrom(academy)
        .where(academy.name.eq(name))
        .fetch();
  }
}