package com.study.springdatajpastudy.repository;

import com.study.springdatajpastudy.domain.entity.MeterinfoTest;
import com.study.springdatajpastudy.domain.entity.id.MeterdailyTestId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterDailyTestRepository extends JpaRepository<MeterinfoTest, MeterdailyTestId> {
}


