package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {


    @Test
    @DisplayName("자동차 대수를 입력한다")
    void input_car_number() {
        mockInputStream("3");

        RacingGame car = new RacingGame();
        car.setCarNumber();
        assertThat(car.getCarNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름을 입력한다")
    void input_car_names() {
        mockInputStream("pobi,crong,honux");

        RacingGame car = new RacingGame();
        car.setCars();
        assertThat(car.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이동 횟수를 입력한다")
    void input_car_move_times() {
        mockInputStream("3");

        RacingGame car = new RacingGame();
        car.setMoveTimes();
        assertThat(car.getMoveTimes()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("조건 값에 따른 True, False 반환 확인")
    void check_go_or_stop_when_condition_is_four(int randomNumber, boolean expected) {
        RacingGame car = new RacingGame();
        assertThat(car.goOrStop(4, randomNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 객체를 생성한다.")
    void create_new_car(){
        RacingGame game = new RacingGame();
        game.addCars(new String[]{"pobi","crong"});

        assertThat(game.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 명이 5자를 초과하면 에러 발생")
    void generate_runtime_exception_when_name_over_five(){
        RacingGame game = new RacingGame();
        assertThatThrownBy(()->{
            game.addCars(new String[]{"pobi1234","crong"});
        })
        .isInstanceOf(RuntimeException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다");
    }

    private void mockInputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
