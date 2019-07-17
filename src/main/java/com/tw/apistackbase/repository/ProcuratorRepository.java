package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.Procurator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Component
public interface ProcuratorRepository extends JpaRepository<Procurator, Integer> {

}
