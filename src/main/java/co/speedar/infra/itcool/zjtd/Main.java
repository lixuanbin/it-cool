package co.speedar.infra.itcool.zjtd;

public class Main {
	private static final int[] daysOfMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static String dateOffset(String date, int offset) {
		checkDate(date);
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));
		checkMonthAndDay(year, month, day);
		int daySum = day + offset;
		while (daySum > daysOfMonth(year, month)) {
			daySum -= daysOfMonth(year, month);
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}
		return year + "" + month + "" + daySum;
	}

	private static int daysOfMonth(int year, int month) {
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return daysOfMonth[month];
		}
	}

	public static void checkDate(String date) {
		if (date == null || date.length() != 8) {
			throw new IllegalArgumentException("invalid input, date must be yyyyMMdd");
		}
		for (int i = 0; i < date.length(); i++) {
			if (date.charAt(i) < '0' || date.charAt(i) > '9') {
				throw new IllegalArgumentException("invalid input, date must be yyyyMMdd");
			}
		}
	}

	private static void checkMonthAndDay(int year, int month, int day) {
		if (month > 12 || month < 1 || day > daysOfMonth(year, month)) {
			throw new IllegalArgumentException("invalid month or day");
		}
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//int a = in.nextInt();
		//System.out.println(a);
		System.out.println(dateOffset("20200316", 3));
		System.out.println(dateOffset("20200316", 30));

	}
}