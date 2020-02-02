package com.scottishpower.digital.smart.meter.service.api;


import com.scottishpower.digital.smart.meter.service.service.SmartMeterReadingService;
import dto.SmartMeterReadingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/smart/reads")
public class SmartMeterReadingResource {

  private SmartMeterReadingService smartMeterReadingService;
  private SmartMeterReadingDtoTransformer smartMeterReadingDtoTransformer;

  @Autowired
  public SmartMeterReadingResource(SmartMeterReadingService smartMeterReadingService, SmartMeterReadingDtoTransformer smartMeterReadingDtoTransformer) {
    this.smartMeterReadingService = smartMeterReadingService;
    this.smartMeterReadingDtoTransformer = smartMeterReadingDtoTransformer;
  }

  @GetMapping("/{accountNumber}")
  public List<SmartMeterReadingDto> getSmartMeterReadingsByAccount(@PathVariable("accountNumber") String accountNumber) {
    return smartMeterReadingService.getSmartMeterReadingsForAccount(accountNumber).stream().map(smartMeterReadingDtoTransformer::transformToDto).collect(Collectors.toList());
  }


}
