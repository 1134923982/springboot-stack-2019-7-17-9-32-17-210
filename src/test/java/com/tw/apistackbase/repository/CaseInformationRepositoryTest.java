package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseInformation;
import com.tw.apistackbase.model.CriminalCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CaseInformationRepositoryTest {
    @Autowired
    CaseInformationRepository caseInformationRepository;
    @Before
    public void setUp() {
        List<CaseInformation> caseInformations = new ArrayList<>();
        caseInformations.add(new CaseInformation("boring","stupid"));
        caseInformations.add(new CaseInformation("boring boring","stupid"));
        caseInformationRepository.saveAll(caseInformations);
    }

    @Test
    public void should_return_case_information_when_given_case_id(){
        CaseInformation caseInformation = caseInformationRepository.findById(1).get();
        assertEquals(1,caseInformation.getId());
    }

}