package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static final int RUN_CONDITION = 4;
    public static final int RANDOM_RANGE = 10;
    private int[] cars;
    private int moveTimes;

    private List<Car> carList = new ArrayList<>();

    public void setCarNumber() {
        cars = new int[InputView.setCarNumber()];
    }

    public void setCars(){
        addCars(InputView.setCarNames().split(","));
    }

    public void addCars(String[] names) {
        for (String name : names) {
            carList.add(createNewCar(name));
        }
    }

    private Car createNewCar(String name) {
        return new Car(name, 0);
    }

    public void setMoveTimes() {
        moveTimes = InputView.setMoveTimes();
    }

    public void racing() {
        System.out.println("실행결과");

        for (int i = 0; i < moveTimes; i++) {
            moveCars();
            ResultView.printResult(carList);
            ResultView.printWinner(carList);
        }
    }
    private void moveCars() {
        for (Car car : carList) {
            if (goOrStop(RUN_CONDITION, getRandomValue())) {
                car.move();
            }
        }
    }

//    private void moveCars() {
//        for (int j = 0; j < cars.length; j++) {
//            if (goOrStop(RUN_CONDITION, getRandomValue())) {
//                cars[j] += 1;
//            }
//        }
//    }

    public boolean goOrStop(int condition, int value) {
        return value >= condition ? true : false;
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }

    public int getCarNumber() {
        return cars.length;
    }

    public int getMoveTimes() {
        return moveTimes;
    }

    public List<Car> getCars() {
        return carList;
    }
}
