import java.util.StringJoiner;

enum Weekday {
	MONDAY    ("MON", false), 
	TUESDAY   ("TUE", false), 
	WEDNESDAY ("WED", false),
	THURSDAY  ("THU", false), 
	FRIDAY    ("FRI", false), 
	SATURDAY  ("SAT", true), 
	SUNDAY    ("SUN", true);

	private final String shortName;
	private final boolean weekend;

	Weekday(String shortName, boolean weekend) {
		this.shortName = shortName;
		this.weekend = weekend;
	}

	public String getShortName() { return shortName; }
	public boolean isWeekend() { return weekend; }
}

public class funny_enum {
	public static void main(String[] args) {
		for (Weekday weekday: Weekday.values()) {
			System.out.printf("%s (%s) %s\n  --> %s\n\n", 
					weekday, weekday.getShortName(), 
					(weekday.isWeekend() ? "relax and enjoy" : "work!"),
					workingHours(weekday));
		}
		System.out.println("Joiner work:");
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		for (Weekday weekday: Weekday.values()) {
			joiner.add(weekday.name());
		}
		System.out.println(joiner);
	}
	public static String workingHours(Weekday weekday) {
		return switch(weekday) {
			case MONDAY, FRIDAY							 -> "9:30-13:00";
			case TUESDAY, THURSDAY					 -> "14:00-17:30";
			case WEDNESDAY, SATURDAY, SUNDAY -> "weekend";
		};
	}
}
