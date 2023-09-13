import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear){
        // creating LocalDate from years given
        LocalDate startYear = LocalDate.of(fromYear, 1, 1);
        LocalDate endYear = LocalDate.of(toYear, 1, 1);

        //Creating a list of every possible date
        List<LocalDate> dateList = startYear.datesUntil(endYear).collect(Collectors.toList());
        List<LocalDate> matchingDates = new ArrayList<>();

        for (LocalDate date : dateList){
            String dateString = turnDateToString(date);
            String reversedString = getDateInReverseString(date);

            if(dateString.equals(reversedString)){
                matchingDates.add(date);
            }

        }

        matchingDates.forEach(System.out::println);
    }

    public static String getDateInReverseString(LocalDate date){
        String formattedString = turnDateToString(date);
        StringBuilder sb = new StringBuilder(formattedString);
        sb.reverse();

        return sb.toString();
    }

    public static String turnDateToString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
        String formattedString = date.format(formatter).replace("-", "");

        return formattedString;
    }
}
