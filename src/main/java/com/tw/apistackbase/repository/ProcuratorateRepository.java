package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInformation;
import com.tw.apistackbase.model.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;

//@Component
public interface ProcuratorateRepository extends JpaRepository<Procuratorate, Integer> {

}
