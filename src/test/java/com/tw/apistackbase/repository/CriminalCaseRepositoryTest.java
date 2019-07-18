package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInformation;
import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.Procuratorate;
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
        criminalCases.add(new CriminalCase("hello", 1000, new Procuratorate("changsha")));
        criminalCases.add(new CriminalCase("kill", 2000, new Procuratorate("state")));
        criminalCases.add(new CriminalCase("hello", 2000, new Procuratorate("haha")));
        criminalCaseRepository.saveAll(criminalCases);
    }


    @Test
    public void should_a_case_by_id_when_query_a_case_by_id(){
        CriminalCase criminalCase = criminalCaseRepository.findById(1).get();
        assertEquals(1,criminalCase.getId());
    }

    @Test
    public void should_return_all_cases_by_time_desc_when_query_all_cases(){
        List<CriminalCase> criminalCases = criminalCaseRepository.findAllByOrderByCaseTimeDesc();
        long[] cases = criminalCases.stream().mapToLong(CriminalCase::getCaseTime).toArray();
        long[] expectedCases = criminalCases.stream().mapToLong(CriminalCase::getCaseTime).boxed().sorted(Comparator.reverseOrder()).mapToLong(Long::longValue).toArray();
        Assert.assertArrayEquals(cases,expectedCases);
    }

    @Test
    public void should_return_all_case_by_name_when_query_cases_by_name(){
        List<CriminalCase> criminalCases = criminalCaseRepository.findAllByName("hello");

        assertEquals("hello",criminalCases.get(0).getName());
        assertEquals(2,criminalCases.size());
    }

    @Test
    public void should_return_deleted_case_when_delete_case_by_id(){
        List<CriminalCase> allCase = criminalCaseRepository.findAll();
        criminalCaseRepository.deleteById(1);
        List<CriminalCase> newCases = criminalCaseRepository.findAll();

        assertEquals(allCase.size(),newCases.size()+1);
    }

    @Test
    public void should_return_criminal_case_with_information_when_add_information_to_case(){
        CaseInformation caseInformation = new CaseInformation("boring boring","stupid");
        CriminalCase criminalCase = new CriminalCase("hello mock", 2000);
        criminalCase.setCaseInformation(caseInformation);
        CriminalCase save = criminalCaseRepository.save(criminalCase);
        assertEquals(save,criminalCase);
    }

    @Test
    public void should_return_procuratorate_in_criminal_case_when_add_procuratorate_to_criminal_case(){
        CriminalCase criminalCase = new CriminalCase("hack", 40000);
        criminalCase.setProcuratorate(new Procuratorate("changsha"));
        CriminalCase save = criminalCaseRepository.save(criminalCase);
        assertEquals(criminalCase,save);

    }
}