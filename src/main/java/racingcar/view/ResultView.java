package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;


public class ResultView {
    private static final String DASH = "-";
    private static final String COMMA = ", ";
    private static String NAME_POSITION_FORMAT = "%s : %s";
    private static String WINNERS_FORMAT = "%s가 최종 우승했습니다.";


    public static void printCarPosition(String name, int position) {
        System.out.println(
                String.format(
                        NAME_POSITION_FORMAT,
                        name,
                        DASH.repeat(position)
                )
        );
    }


    public static void printWinner(List<String> names){
        System.out.println(
                String.format(
                        WINNERS_FORMAT,String.join(COMMA,names)
                )
        );
    }
}
