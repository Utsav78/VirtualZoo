/**
 *
 * @author Your name: UTSAV BUDATHOKI, student number: 2306084 and FAN: buda0027 here
 */
public class Hippo extends Animal {
    public Hippo(String name) {
        super(name, "Hippo");
    }

    @Override
    void giveFood() {
        setHunger(Math.max(getHunger() - 25, 0));
        setThirst(getThirst() + 5);
        setBoredom(getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
    }

    @Override
    void giveWater() {
        setHunger(getHunger() + 5);
        setThirst(Math.max(getThirst() - 25, 0));
        setBoredom(getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
    }

    @Override
    void giveToy() {
        setHunger(getHunger() + 20);
        setThirst(getThirst() + 20);
        setBoredom(Math.max(getBoredom() - 50, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }
}
