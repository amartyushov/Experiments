package io.mart;

import java.util.Random;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.influx.InfluxMeterRegistry;

public class Application {
	
	public static void main(String[] args) {
		
		// config
		InfluxConfiguration influxConfiguration = new InfluxConfiguration();
		MeterRegistry meterRegistry = new InfluxMeterRegistry(influxConfiguration, Clock.SYSTEM);
		
		
		// create timer and counter
		Timer timer1 =
				meterRegistry.timer("myTimerName1", "timerTag11", "timerTagValue11", "timerTag12", "timerTagValue12");
		Timer timer2 =
				meterRegistry.timer("myTimerName2", "timerTag22", "timerTagValue22", "timerTag22", "timerTagValue22");
		
		Counter counter1 = meterRegistry.counter("myCounterName1", "counterTag1", "counterTagValue1");
		
		
		// gather metrics
//		while (true) {
		Random random = new Random();
		
		timer1.record(() -> sleep(random.nextInt(3)));
//			timer2.record(() -> sleep(random.nextInt(3)));

//			counter1.increment();
//		}
	}
	
	
	private static void sleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
		}
	}
	
}
