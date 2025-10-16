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



}
