package net.charliemeyer.candlecontrol.rf;

import java.time.Duration;

public class CandleCommander implements Runnable {

  private boolean isRunning;
  private static final int DELAY_SECONDS = 10;
  private boolean shutdown = false;

  public CandleCommander() {
    isRunning = false;
  }

  @Override
  public void run() {
    while (!shutdown) {
      if (isRunning) {
        new CandleTurnOffCmd().turnOffCandles();
      }
      try {
        Thread.sleep(Duration.ofSeconds(DELAY_SECONDS));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
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
