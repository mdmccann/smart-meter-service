package com.scottishpower.digital.smart.meter.service.service;

import com.scottishpower.digital.smart.meter.service.domain.SmartMeterReading;
import com.scottishpower.digital.smart.meter.service.service.port.SmartMeterReadingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmartMeterReadingServiceTest {

  private static String ACCOUNT_NUMBER = "000000001";

  @Mock
  private SmartMeterReadingRepository smartMeterReadingRepository;
  @Mock
  private SmartMeterReading smartMeterReading;

  @InjectMocks
  private SmartMeterReadingService sut;

  @BeforeEach
  void setUp() {
  }

  @Test
  void getSmartMeterReadingsForAccount() {
    when(smartMeterReadingRepository.findSmartMeterReadingsByAccountNumber(ACCOUNT_NUMBER)).thenReturn(Collections.singletonList(smartMeterReading));
    assertEquals(Collections.singletonList(smartMeterReading), sut.getSmartMeterReadingsForAccount(ACCOUNT_NUMBER));
  }

}