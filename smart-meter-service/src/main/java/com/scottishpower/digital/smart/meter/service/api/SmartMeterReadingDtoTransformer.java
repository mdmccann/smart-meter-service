package com.scottishpower.digital.smart.meter.service.api;

import com.scottishpower.digital.smart.meter.service.domain.SmartMeterReading;
import dto.ReadingDetailDto;
import dto.SmartMeterReadingDto;
import org.springframework.stereotype.Component;

@Component
public class SmartMeterReadingDtoTransformer {

  public SmartMeterReadingDto transformToDto(SmartMeterReading smartMeterReading) {
    SmartMeterReadingDto smartMeterReadingDto = new SmartMeterReadingDto();
    smartMeterReadingDto.setId(smartMeterReading.getId());
    smartMeterReadingDto.setAccountNumber(smartMeterReading.getAccountNumber());

    smartMeterReadingDto.setElectricityRead(ReadingDetailDto.builder()
        .id(smartMeterReading.getElectricityReading().getId())
        .reading(smartMeterReading.getElectricityReading().getReading())
        .build()
    );

    smartMeterReadingDto.setGasRead(ReadingDetailDto.builder()
        .id(smartMeterReading.getGasReading().getId())
        .reading(smartMeterReading.getGasReading().getReading())
        .build()
    );

    return smartMeterReadingDto;
  }

}
