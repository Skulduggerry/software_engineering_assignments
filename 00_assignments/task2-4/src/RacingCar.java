public class RacingCar {

    // Hier fehlt noch die Definitionen der Attribute!

    public RacingCar(String name, int maxSpeed) {
        // Hier fehlt noch die Initialisierung!
    }

    // Hier fehlen noch einige Methoden!

    public String toString() {
        return "Racing Car " + this.racer + " at position: " + this.pos + ", with speed: " + this.speed + ".";
    }

    public static void assertTrue(boolean value){
        if (!value) {
            throw new RuntimeException("Ups! There is a mistake.");
        }
    }

    public static void main(String[] args) {
        RacingCar car = new RacingCar("Hamilton", 200);
        assertTrue(car.getRacer().equals("Hamilton"));
        assertTrue(car.maxSpeed == 200);
        assertTrue(car.finish == -1);

        car.setRacer("Bottas");
        assertTrue(car.getRacer().equals("Bottas"));
        car.setRacer("");
        assertTrue(car.getRacer().equals("Bottas"));

        car.setSpeed(10);
        assertTrue(car.getSpeed() == 10);
        car.setSpeed(0);
        assertTrue(car.getSpeed() == 0);
        car.setSpeed(-10);
        assertTrue(car.getSpeed() == 0);
        car.setSpeed(car.maxSpeed);
        assertTrue(car.getSpeed() == car.maxSpeed);
        car.setSpeed(car.maxSpeed + 10);
        assertTrue(car.getSpeed() == car.maxSpeed);

        car.setPosition(10);
        assertTrue(car.getPosition() == 10);
        car.setPosition(-10);
        assertTrue(car.getPosition() == 10);
        car.setPosition(0);
        assertTrue(car.getPosition() == 0);

        assertTrue(!car.isFinished());
        car.finish = 20;
        car.setPosition(10);
        assertTrue(!car.isFinished());
        car.setPosition(20);
        assertTrue(car.isFinished());
        car.setPosition(22);
        assertTrue(car.isFinished());

        car.start(50, 200);
        assertTrue(car.getPosition() == 0);
        assertTrue(car.getSpeed() == 50);
        assertTrue(car.finish == 200);

        car.race(0);
        assertTrue(car.getSpeed() == 50);
        assertTrue(car.getPosition() == 50);
        assertTrue(!car.isFinished());

        car.race(10);
        assertTrue(car.getSpeed() == 60);
        assertTrue(car.getPosition() == 110);
        assertTrue(!car.isFinished());

        car.race(-10);
        assertTrue(car.getSpeed() == 50);
        assertTrue(car.getPosition() == 160);
        assertTrue(!car.isFinished());

        car.race(0);
        assertTrue(car.isFinished());
    }

}
