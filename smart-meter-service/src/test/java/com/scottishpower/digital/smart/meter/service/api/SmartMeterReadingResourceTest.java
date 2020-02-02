package com.scottishpower.digital.smart.meter.service.api;

import com.scottishpower.digital.smart.meter.service.domain.SmartMeterReading;
import com.scottishpower.digital.smart.meter.service.service.SmartMeterReadingService;
import dto.SmartMeterReadingDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmartMeterReadingResourceTest {

  private static final String ACCOUNT_NUMBER = "000000001";

  @Mock
  private SmartMeterReadingService smartMeterReadingService;
  @Mock
  private SmartMeterReadingDtoTransformer smartMeterReadingDtoTransformer;
  @Mock
  private SmartMeterReading smartMeterReading;
  @Mock
  private SmartMeterReadingDto smartMeterReadingDto;

  @InjectMocks
  private SmartMeterReadingResource cut;

  @Test
  void getSmartMeterReadingsByAccount() {
    when(smartMeterReadingService.getSmartMeterReadingsForAccount(ACCOUNT_NUMBER)).thenReturn(Collections.singletonList(smartMeterReading));
    when(smartMeterReadingDtoTransformer.transformToDto(smartMeterReading)).thenReturn(smartMeterReadingDto);
    assertEquals(Collections.singletonList(smartMeterReadingDto), cut.getSmartMeterReadingsByAccount(ACCOUNT_NUMBER));
  }

}