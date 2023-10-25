/**
 *
 * @author Your name: UTSAV BUDATHOKI, student number: 2306084 and FAN: buda0027 here
 */
public class Monkey extends Animal {
    public Monkey(String name) {
        super(name, "Monkey");
    }

    @Override
    void giveFood() {
        setHunger(Math.max(getHunger() - 30, 0));
        setThirst(getThirst() + 10);
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }
    }

    @Override
    void giveWater() {
        setHunger(getHunger() + 10);
        setThirst(Math.max(getThirst() - 40, 0));
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }

    }

    @Override
    void giveToy() {
        setHunger(getHunger() + 10);
        setThirst(getThirst() + 10);
        setBoredom(Math.max(getBoredom() - 15, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 15);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }
    }
}
