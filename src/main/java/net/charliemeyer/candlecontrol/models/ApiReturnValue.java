package net.charliemeyer.candlecontrol.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ApiReturnValue {
  String message;
  @NonNull String status;
}
