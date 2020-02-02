package com.scottishpower.digital.smart.meter.service.api;

import com.scottishpower.digital.smart.meter.service.domain.ElectricityReading;
import com.scottishpower.digital.smart.meter.service.domain.GasReading;
import com.scottishpower.digital.smart.meter.service.domain.SmartMeterReading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmartMeterReadingDtoTransformerTest {

  private static final UUID ID = UUID.randomUUID();
  private static final String ACCOUNT_NUMBER = "000000001";
  private static final String ELECTRICITY_ID = "800000001";
  private static final BigDecimal ELECTRICITY_READING = BigDecimal.TEN;
  private static final String GAS_ID = "900000001";
  private static final BigDecimal GAS_READING = BigDecimal.ONE;

  @Mock
  private SmartMeterReading smartMeterReading;
  @Mock
  private ElectricityReading electricityReading;
  @Mock
  private GasReading gasReading;

  private SmartMeterReadingDtoTransformer cut;

  @BeforeEach
  void setUp() {
    when(smartMeterReading.getElectricityReading()).thenReturn(electricityReading);
    when(smartMeterReading.getGasReading()).thenReturn(gasReading);
    cut = new SmartMeterReadingDtoTransformer();
  }

  @Test
  void transformToDto_Id() {
    when(smartMeterReading.getId()).thenReturn(ID);
    assertEquals(ID, cut.transformToDto(smartMeterReading).getId());
  }

  @Test
  void transformToDto_AccountNumber() {
    when(smartMeterReading.getAccountNumber()).thenReturn(ACCOUNT_NUMBER);
    assertEquals(ACCOUNT_NUMBER, cut.transformToDto(smartMeterReading).getAccountNumber());
  }

  @Test
  void transformToDto_ElectricityRead_Id() {
    when(smartMeterReading.getElectricityReading()).thenReturn(electricityReading);
    when(electricityReading.getId()).thenReturn(ELECTRICITY_ID);
    assertEquals(ELECTRICITY_ID, cut.transformToDto(smartMeterReading).getElectricityRead().getId());
  }

  @Test
  void transformToDto_ElectricityRead_Reading() {
    when(electricityReading.getReading()).thenReturn(ELECTRICITY_READING);
    assertEquals(ELECTRICITY_READING, cut.transformToDto(smartMeterReading).getElectricityRead().getReading());
  }

  @Test
  void transformToDto_GasRead_Id() {
    when(gasReading.getId()).thenReturn(GAS_ID);
    assertEquals(GAS_ID, cut.transformToDto(smartMeterReading).getGasRead().getId());
  }

  @Test
  void transformToDto_GasRead_Reading() {
    when(gasReading.getReading()).thenReturn(GAS_READING);
    assertEquals(GAS_READING, cut.transformToDto(smartMeterReading).getGasRead().getReading());
  }

}