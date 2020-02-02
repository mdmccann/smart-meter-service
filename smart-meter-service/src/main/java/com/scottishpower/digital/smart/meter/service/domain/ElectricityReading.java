package com.scottishpower.digital.smart.meter.service.domain;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class ElectricityReading {

  @Column(name = "ELEC_ID")
  private String id;
  @Column(name = "ELEC_SMART_READ")
  private BigDecimal reading;

}
