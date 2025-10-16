public class Sparbuch {
    private int money;

    public Sparbuch(int money) {
        this.money = money;
    }

    public void add(int money) {
        if(money < 0) {
            System.err.println("Cannot add a negative amount of money. Use withdraw instead!");
            return;
        }
        this.money += money;
    }

    public void withdraw(int money) {
        if(money < 0) {
            System.err.println("Cannot subtract a negative amount of money. Use add instead!");
            return;
        }
        this.money -= money;
    }

    public void info() {
        System.out.printf("You currently have %d€%n", money);
        if (this.money < 0) {
            System.out.println("WARNING! YOU OWE USE MONEY. PAY US OR WE WILL FIND YOU!");
        }
    }
}
