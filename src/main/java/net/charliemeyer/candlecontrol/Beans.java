package net.charliemeyer.candlecontrol;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.charliemeyer.candlecontrol.rf.CandleCommander;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Beans {

  private final CandleCommander candleCommander;
  private final ExecutorService executorService = Executors.newFixedThreadPool(1);

  public Beans() {
    this.candleCommander = new CandleCommander();
    executorService.submit(candleCommander);
  }

  @Bean(destroyMethod = "shutdown")
  public CandleCommander getCandleCommander() {
    return candleCommander;
  }

  @Bean
  public ExecutorService getExecutorService() {
    return executorService;
  }

  @Bean
  public ObjectMapper getObjectMapper() {
    return new Jackson2ObjectMapperBuilder().build();
  }
}
