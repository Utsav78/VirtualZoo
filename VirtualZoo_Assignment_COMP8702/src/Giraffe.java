/**
 *
 * @author Your name: UTSAV BUDATHOKI, student number: 2306084 and FAN: buda0027 here
 */
public class Giraffe extends Animal {
    public Giraffe(String name) {
        super(name, "Giraffe");
    }

    @Override
    void giveFood() {
        setHunger(Math.max(getHunger() - 50, 0));
        setThirst(getThirst() + 30);
        setBoredom(getBoredom() + 20);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 100);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }
    }

    @Override
    void giveWater() {
        setHunger(getHunger() + 20);
        setThirst(Math.max(getThirst() - 50, 0));
        setBoredom(getBoredom() + 30);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }

    }

    @Override
    void giveToy() {
        setHunger(getHunger() + 30);
        setThirst(getThirst() + 10);
        setBoredom(Math.max(getBoredom() - 40, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 75);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }
    }
}
