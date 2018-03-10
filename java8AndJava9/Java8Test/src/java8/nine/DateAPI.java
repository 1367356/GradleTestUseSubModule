package java8.nine;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class DateAPI {

	/**
	 * Clock时钟
	 */
	public void clock(){
		Clock clock=Clock.systemDefaultZone();
		long millis=clock.millis();
		Instant instant=clock.instant();
		Date legacyDate=Date.from(instant);
	}
}
