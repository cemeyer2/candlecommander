package net.charliemeyer.candlecontrol.rf;

import lombok.SneakyThrows;

import java.time.Duration;

public class CandleCommander implements Runnable {

  private boolean isRunning;
  private static final int DELAY_SECONDS = 10;
  private boolean shutdown = false;

  public CandleCommander() {
    isRunning = false;
  }

  @SneakyThrows
  @Override
  public void run() {
    while (!shutdown) {
      if (isRunning) {
        new CandleTurnOffCmd().turnOffCandles();
      }
      Thread.sleep(Duration.ofSeconds(DELAY_SECONDS));
    }
  }

  public void shutdown() {
    this.shutdown = true;
  }

  public void start() {
    isRunning = true;
  }

  public void stop() {
    isRunning = false;
  }
}
