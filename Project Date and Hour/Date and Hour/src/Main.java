import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.now(); //Instancia uma nova data SEM horário, com base na data e hora do Sistema (Horário local)
        LocalDateTime d02 = LocalDateTime.now(); //O Date-Time Instancia uma nova data COM horário, com base na data e hora do Sistema (HORÁRIO LOCAL)
        Instant d03 = Instant.now(); // Cria uma data e hora com fuso horário global GMT/UTC ou Zulo hour no formato ISO68: year-month-day T hour:minute:secod.secondsFracttion

        ZoneId myZone = ZoneId.systemDefault(); //A Classe Zone ID traz o fuso horário, podemos ser o local ou de outro pais

        //A classe Date Time Formatter formata a data e a hora do padrão ISO68 para o padrão que for especificado:
        DateTimeFormatter fmtLocal = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        //A classe Date Time Formatter formata a data e a hora do padrão ISO68 para o padrão que for especificado, inclusive com o Time-Zone:
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(myZone);

        //Time Zone US
        //Time Zone lists da Classe ZoneID: https://coderanch.com/t/583150/java/timezone-getavailableids-shows-duplicates

        DateTimeFormatter fmtCanadaVancouver = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").withZone(ZoneId.of("Canada/Pacific"));

        LocalDate res = LocalDate.ofInstant(d03,myZone);


        //System.out.println(fmt.format(d03));
        System.out.println("Horário local no Brasil-SP: " + fmt.format(d03));
        //System.out.println(d03);
        System.out.println("Horário Local no Canada: " + fmtCanadaVancouver.format(d03));

        //#################################### Operation with Dates Times ############################################

        LocalDate d04 = LocalDate.parse("2022-07-20"); //Convert Local Date (without time) for text (String)
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26"); //Convert Local Date with for text (String)
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        //Subtraction and add dates
        LocalDate pastWeekDate = d04.minusDays(7);
        LocalDate nextWeekDate = d04.plusDays(7);

        LocalDateTime pastWeekLocalDate = d05.minusDays(7);
        LocalDateTime nextWeekLocalDate = d05.plusDays(7);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekDate = " + pastWeekDate);
        System.out.println("nextWeekDate = " + nextWeekDate);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDate, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(d06, pastWeekInstant);

        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());

    }
}