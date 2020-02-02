package com.scottishpower.digital.smart.meter.service.service.port;

import com.scottishpower.digital.smart.meter.service.domain.SmartMeterReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SmartMeterReadingRepository extends CrudRepository<SmartMeterReading, UUID> {

  List<SmartMeterReading> findSmartMeterReadingsByAccountNumber(String accountNumber);

}
