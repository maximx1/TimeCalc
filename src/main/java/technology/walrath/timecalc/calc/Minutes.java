package technology.walrath.timecalc.calc;

import technology.walrath.timecalc.model.Tuple2;

import java.util.List;

/**
 * Minutes helper.
 */
public class Minutes {
    /**
     * Takes a list of minutes, adds them up, and then converts them to hours and minutes.
     * @param minutes A list of minutes to sum and reduce.
     * @return The total hours and minutes reduced to hours and no more than 59 minutes.
     */
    public static Tuple2<Integer, Integer> convertMinutesToHoursAndMinutes(List<Integer> minutes) {
        return convertMinutesToHoursAndMinutes(minutes.stream().mapToInt(i -> i).sum());
    }

    /**
     * Converts an integer total of minutes into hours and minutes with no more than 59 minutes.
     * @param minutes The number of minutes to convert.
     * @return The total hours and minutes reduced to hours and no more than 59 minutes.
     */
    public static Tuple2<Integer, Integer> convertMinutesToHoursAndMinutes(int minutes) {
        return new Tuple2<>(minutes / 60, minutes % 60);
    }

    /**
     * Sums a list of (hours, minutes) pairs into a single total (hours, minutes) pair.
     * @param times The tupled hours and minutes.
     * @return The total hours and minutes reduced to hours and no more than 59 minutes.
     */
    public static Tuple2<Integer, Integer> sumListOfHoursAndMinutesWorked(List<Tuple2<Integer, Integer>> times) {
        Tuple2<Integer, Integer> roughTotal = times.stream().reduce(new Tuple2<>(0, 0), (a, b) -> new Tuple2<>(a._1 + b._1, a._2 + b._2));
        Tuple2<Integer, Integer> minutesAsMinAndHour = convertMinutesToHoursAndMinutes(roughTotal._2);
        return new Tuple2<>(roughTotal._1 + minutesAsMinAndHour._1, minutesAsMinAndHour._2);
    }
}
