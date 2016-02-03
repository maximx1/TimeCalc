package technology.walrath.timecalc.calc;

import org.junit.Test;
import technology.walrath.timecalc.model.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class MinutesTest {

    @Test
    public void canConvertLessThan60MinutesTo0HoursAndMinutes() {
        Tuple2<Integer, Integer> result = Minutes.convertMinutesToHoursAndMinutes(30);
        assertEquals(0, result._1.intValue());
        assertEquals(30, result._2.intValue());
    }

    @Test
    public void canConvertMoreThan60MinutesToHoursAndMinutes() {
        Tuple2<Integer, Integer> result = Minutes.convertMinutesToHoursAndMinutes(90);
        assertEquals(1, result._1.intValue());
        assertEquals(30, result._2.intValue());
    }

    @Test
    public void canConvert60MinutesTo1Hour() {
        Tuple2<Integer, Integer> result = Minutes.convertMinutesToHoursAndMinutes(60);
        assertEquals(1, result._1.intValue());
        assertEquals(0, result._2.intValue());
    }

    @Test
    public void canConvert0MinutesTo0HoursAnd0Minutes() {
        Tuple2<Integer, Integer> result = Minutes.convertMinutesToHoursAndMinutes(0);
        assertEquals(0, result._1.intValue());
        assertEquals(0, result._2.intValue());
    }

    @Test
    public void canConvertAListOfMinutesToHoursAndMinutes() {
        Tuple2<Integer, Integer> result = Minutes.convertMinutesToHoursAndMinutes(Arrays.asList(1, 54, 65, 30));
        assertEquals(2, result._1.intValue());
        assertEquals(30, result._2.intValue());
    }

    @Test
    public void canSumAListOfMultipleHoursAndMinutesPairs() {
        Tuple2<Integer, Integer> result = Minutes.sumListOfHoursAndMinutesWorked(Arrays.asList(new Tuple2<>(7, 45), new Tuple2<>(7, 21), new Tuple2<>(4, 12)));
        assertEquals(19, result._1.intValue());
        assertEquals(18, result._2.intValue());
    }

    @Test
    public void canSumAListOfMultipleHoursAndMinutesPairsWithOneEmpty() {
        Tuple2<Integer, Integer> result = Minutes.sumListOfHoursAndMinutesWorked(Arrays.asList(new Tuple2<>(7, 45), new Tuple2<>(7, 21), new Tuple2<>(4, 12), new Tuple2<>(0, 0)));
        assertEquals(19, result._1.intValue());
        assertEquals(18, result._2.intValue());
    }

    @Test
    public void canSumAnEmptyListOfHoursAndMinutesPairs() {
        Tuple2<Integer, Integer> result = Minutes.sumListOfHoursAndMinutesWorked(new ArrayList<>());
        assertEquals(0, result._1.intValue());
        assertEquals(0, result._2.intValue());
    }
}
