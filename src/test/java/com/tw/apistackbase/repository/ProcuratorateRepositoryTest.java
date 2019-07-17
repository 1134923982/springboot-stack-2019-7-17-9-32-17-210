package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Procurator;
import com.tw.apistackbase.model.Procuratorate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_add_procurators_to_procuratorate_when_add_add_procurators(){
        Procuratorate procuratorate = new Procuratorate("yunan");
        List<Procurator> procurators = new ArrayList<>();
        procurators.add(new Procurator("Zhangsan"));
        procurators.add(new Procurator("Lisi"));
        procuratorate.setProcurators(procurators);
        Procuratorate save = procuratorateRepository.save(procuratorate);
        assertEquals(procuratorate, save);

    }

}