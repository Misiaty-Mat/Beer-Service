package com.spring6framework.spring6restmvc.services;

import com.opencsv.bean.CsvToBeanBuilder;
import com.spring6framework.spring6restmvc.model.BeerCSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class BeerCsvServiceImpl implements BeerCsvService {
    @Override
    public List<BeerCSVRecord> convertCSV(InputStream csvInputStream) {
        return new CsvToBeanBuilder<BeerCSVRecord>(new InputStreamReader(csvInputStream))
                .withType(BeerCSVRecord.class)
                .build().parse();
    }
}
