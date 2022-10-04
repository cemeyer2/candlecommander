package net.charliemeyer.candlecontrol.api;


import net.charliemeyer.candlecontrol.models.ApiReturnValue;
import net.charliemeyer.candlecontrol.rf.CandleCommander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {

  private CandleCommander candleCommander;

  @Autowired
  public ApiResource(CandleCommander candleCommander) {
    this.candleCommander = candleCommander;
  }


  @GET
  @Path("/start")
  public ApiReturnValue start() {
    candleCommander.start();
    return ApiReturnValue.builder()
            .status("STARTED")
            .message("started candle turn off background process")
            .build();
  }

  @GET
  @Path("/stop")
  public ApiReturnValue stop() {
    candleCommander.stop();
    return ApiReturnValue.builder()
            .status("STOPPED")
            .message("stopped candle turn off background process")
            .build();
  }
}
