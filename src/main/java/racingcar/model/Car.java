package racingcar.model;

public class Car {

    private String name;
    private int position;

    public Car(String name, int position) {
        if(name.length() >5)
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다");
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        this.position += 1;
    }

    public Object getDistance() {
        String distance = "";
        for (int i = 0; i <this.position; i++){
            distance += "-";
        }
        return distance;
    }
}
