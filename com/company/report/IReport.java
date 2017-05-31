package com.company.report;

import com.company.analyzer.ReportAnalyzer;

import java.util.List;

/**Andrei
 * Created by Andrei on 03.04.2017.
 * @version 1.0
 */
public interface IReport<T> {
  /**
   *Interface defining classes for reports
   * @param ra Class object containing tweets, states, emotional weight
   * @param str Array containing the required data
   * @return Type defined by parameterization
   * @throws Exception
   */
  T report (ReportAnalyzer ra, String[] str) throws Exception;

}
