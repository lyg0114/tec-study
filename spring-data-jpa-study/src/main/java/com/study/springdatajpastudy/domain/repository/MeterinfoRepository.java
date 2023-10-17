package com.study.springdatajpastudy.domain.repository;

import com.study.springdatajpastudy.domain.entity.Meterinfo;
import com.study.springdatajpastudy.domain.entity.id.MeterinfoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterinfoRepository extends JpaRepository<Meterinfo, MeterinfoId> {
}


