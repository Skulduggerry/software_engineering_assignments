public class RacingCar {

    private String racer;
    private int speed;
    private int pos;
    private final int maxSpeed;
    private int finish = -1;

    public RacingCar(String name, int maxSpeed) {
        setRacer(name);
        assertTrue(maxSpeed >= 0);
        this.maxSpeed = maxSpeed;
    }

    public void setSpeed(int speed) {
        this.speed = Math.min(maxSpeed, Math.max(speed, 0));
    }

    public void setRacer(String racer) {
        if(racer != null && !racer.isEmpty()) {
            this.racer = racer;
        }
    }

    public void setPosition(int pos) {
        if(pos >= 0)
            this.pos = pos;
    }

    public void start(int initSpeed, int finishDistance){
        setSpeed(initSpeed);
        setPosition(0);
        finish = finishDistance;
    }

    public void race(int acceleration) {
        setSpeed(acceleration + this.speed);
        setPosition(this.pos + this.speed);
    }

    public boolean isFinished() {
        return finish != -1 && pos >= finish;
    }

    public String toString() {
        return "Racing Car " + this.racer + " at position: " + this.pos + ", with speed: " + this.speed + ".";
    }

    public static void assertTrue(boolean value){
        if (!value) {
            throw new RuntimeException("Ups! There is a mistake.");
        }
    }

    public String getRacer() {
        return racer;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPosition() {
        return pos;
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
