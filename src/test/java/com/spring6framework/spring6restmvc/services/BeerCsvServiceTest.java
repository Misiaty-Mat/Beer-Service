package com.spring6framework.spring6restmvc.services;

import com.spring6framework.spring6restmvc.model.BeerCSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BeerCsvServiceTest {

    @Autowired
    BeerCsvService beerCsvService;

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void convertCSV() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:csvdata/beers.csv");
        InputStream inputStream = resource.getInputStream();
        List<BeerCSVRecord> recs = beerCsvService.convertCSV(inputStream);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(0);
    }
}