package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Component
public interface CaseInformationRepository extends JpaRepository<CaseInformation, Integer> {

}
