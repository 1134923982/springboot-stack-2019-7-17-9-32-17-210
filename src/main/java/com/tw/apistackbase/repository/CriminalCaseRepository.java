package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
//@Component
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Integer> {
//    CriminalCase findCriminalCaseById(long id);
//    @Transactional
//    @Modifying
//    @Query("select cc from CriminalCase cc order by cc.time desc")
//    List<CriminalCase> findAllOrderByTime();
    List<CriminalCase> findAllByOrderByCaseTimeDesc();
    List<CriminalCase> findAllByName(String name);
}
