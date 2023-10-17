package com.study.springdatajpastudy.domain.repository;

import com.study.springdatajpastudy.domain.entity.Meterdaily;
import com.study.springdatajpastudy.domain.entity.id.MeterdailyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterDailyRepository extends JpaRepository<Meterdaily, MeterdailyId> {
}


