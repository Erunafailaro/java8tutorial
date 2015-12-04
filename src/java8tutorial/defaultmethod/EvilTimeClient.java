package java8tutorial.defaultmethod;

import java.time.LocalDateTime;

public interface EvilTimeClient {
	void setTime(int hour, int minute, int second);

	void setDate(int day, int month, int year);

	void setDateAndTime(int day, int month, int year, int hour, int minute,
			int second);

	LocalDateTime getLocalDateTime();

	// ZonedDateTime getZonedDateTime(String zoneString);

	// static ZoneId getZoneId(String zoneString) {
	// try {
	// return ZoneId.of(zoneString);
	// } catch (DateTimeException e) {
	// System.err.println("Invalid time zone: " + zoneString
	// + "; using default time zone instead.");
	// return ZoneId.systemDefault();
	// }
	// }

	// default ZonedDateTime getZonedDateTime(String zoneString) {
	// return null;
	// }
}
