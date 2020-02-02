package dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SmartMeterReadingDto {

  private UUID id;
  private String accountNumber;
  private ReadingDetailDto gasRead;
  private ReadingDetailDto electricityRead;

}
