package com.company.report;

import com.company.analyzer.ReportAnalyzer;

import java.util.List;

/**
 * Created by Алексей on 03.04.2017.
 */
public interface IReport<T> {

  T report (ReportAnalyzer ra, String[] str) throws Exception;

}
