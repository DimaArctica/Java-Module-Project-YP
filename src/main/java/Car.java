public class Car {
    String name;
    int speed, distance;
    static int raceDuration = 24;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.distance = speed * raceDuration;
    }
}
