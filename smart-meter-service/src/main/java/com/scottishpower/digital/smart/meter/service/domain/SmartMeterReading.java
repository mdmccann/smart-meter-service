package com.scottishpower.digital.smart.meter.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class SmartMeterReading {

  @Id
  @GeneratedValue
  private UUID id;
  @Column(name = "ACCOUNT_NUMBER")
  private String accountNumber;
  @Embedded
  private GasReading gasReading;
  @Embedded
  private ElectricityReading electricityReading;

}
