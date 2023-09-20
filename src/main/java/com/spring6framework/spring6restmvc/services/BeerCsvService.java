package com.spring6framework.spring6restmvc.services;

import com.spring6framework.spring6restmvc.model.BeerCSVRecord;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(InputStream csvInputStream);
}
