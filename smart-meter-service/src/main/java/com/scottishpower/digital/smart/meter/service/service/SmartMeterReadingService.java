package com.scottishpower.digital.smart.meter.service.service;

import com.scottishpower.digital.smart.meter.service.domain.SmartMeterReading;
import com.scottishpower.digital.smart.meter.service.service.port.SmartMeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmartMeterReadingService {

  private SmartMeterReadingRepository smartMeterReadingRepository;

  @Autowired
  public SmartMeterReadingService(SmartMeterReadingRepository smartMeterReadingRepository) {
    this.smartMeterReadingRepository = smartMeterReadingRepository;
  }

  public List<SmartMeterReading> getSmartMeterReadingsForAccount(String accountNumber) {
    return smartMeterReadingRepository.findSmartMeterReadingsByAccountNumber(accountNumber);
  }

}
