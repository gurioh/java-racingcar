package racingcar;

import racingcar.model.Car;

import java.util.List;

import static java.lang.System.in;

public class ResultView {

//    static void printResult(int[] cars) {
//        for (int i = 0; i < cars.length; i++) {
//            for (int j = 0; j < cars[i]; j++) {
//                System.out.print("-");
//            }
//            System.out.println();
//        }
//        System.out.println("################################################################");
//    }

    static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format("%s : %s", car.getName(),car.getDistance()));
        }
        System.out.println("################################################################");
    }

    public static void printWinner(List<Car> cars) {
        int maxValue = 0;
        for (Car car : cars) {
            Math.max(car.getPosition(), maxValue);
        }
    }
}
