package dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ReadingDetailDto {

  private String id;
  private BigDecimal reading;

}
