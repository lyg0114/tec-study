package com.study.querydslstudy.repository;

import com.study.querydslstudy.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.querydslstudy.repository
 * @since : 2023/07/08
 */
public interface AcademyRepository extends JpaRepository<Academy, Long> {
}
