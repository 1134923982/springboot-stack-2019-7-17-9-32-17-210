package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        long[] cases = criminalCases.stream().mapToLong(CriminalCase::getCaseTime).toArray();
        long[] expectedCases = criminalCases.stream().mapToLong(CriminalCase::getCaseTime).boxed().sorted(Comparator.reverseOrder()).mapToLong(Long::longValue).toArray();
        Assert.assertArrayEquals(cases,expectedCases);
    }
}