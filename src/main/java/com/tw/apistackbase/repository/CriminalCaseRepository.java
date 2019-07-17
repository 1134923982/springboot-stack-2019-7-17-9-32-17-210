package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Integer> {
//    CriminalCase findCriminalCaseById(long id);
    List<CriminalCase> findAllByTimeOrderByTimeDesc(long time);
}
