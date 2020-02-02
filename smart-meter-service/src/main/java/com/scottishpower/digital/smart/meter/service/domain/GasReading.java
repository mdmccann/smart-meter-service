package com.scottishpower.digital.smart.meter.service.domain;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class GasReading {

  @Column(name = "GAS_ID")
  private String id;
  @Column(name = "GAS_SMART_READ")
  private BigDecimal reading;

}
