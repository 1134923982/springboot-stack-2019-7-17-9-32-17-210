package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCaseRepositoryTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Before
    public void setUp() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        criminalCases.add(new CriminalCase("hello", 1000));
        criminalCases.add(new CriminalCase("kill", 2000));
        criminalCaseRepository.saveAll(criminalCases);
    }


    @Test
    public void should_a_case_by_id_when_query_a_case_by_id(){
        CriminalCase criminalCase = criminalCaseRepository.findById(1).get();
        assertEquals(1,criminalCase.getId());
    }

    @Test
    public void should_return_all_list_by_time_desc_when_query_all_cases(){
        List<CriminalCase> criminalCases = criminalCaseRepository.findAllByOrderByCaseTimeDesc();
        assertEquals(true, criminalCases.get(0).getCaseTime()>criminalCases.get(1).getCaseTime());
    }
}