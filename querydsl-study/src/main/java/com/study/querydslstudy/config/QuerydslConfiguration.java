package com.study.querydslstudy.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author : iyeong-gyo
 * @package : com.study.querydslstudy.config
 * @since : 2023/07/08
 */
@Configuration
public class QuerydslConfiguration {

  @PersistenceContext
  private EntityManager entityManager;

  public JPAQueryFactory jpaQueryFactory() {
    return new JPAQueryFactory(entityManager);
  }
}
