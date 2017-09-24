package localDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Umesh Adhikari on 24 Sep 2017, 12:03:01
 *
 *Copyright © 2017 Umesh Adhikari. All rights reserved.
 */
public class ChristmasDay {
	static LocalDate startDate = LocalDate.of(1800, 12, 25);
	static LocalDate endDate = LocalDate.of(2100, 12, 31);
	static DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMMM YYYY").withLocale(Locale.UK);
	
	public static List<LocalDate> getXmasDays(LocalDate startDate, LocalDate endDate){
		return Stream.iterate(startDate, date -> date.plusYears(1)).limit(endDate.getYear() - startDate.getYear() + 1)
				.filter(date -> date.getDayOfWeek() == DayOfWeek.SUNDAY).collect(Collectors.toList());
	}
	
	public static void main(String[] args){
		getXmasDays(startDate, endDate).forEach(date -> System.out.println(date.format(format)));
	}
}
