/**
 *
 * @author Your name: UTSAV BUDATHOKI, student number: 2306084 and FAN: buda0027 here
 */
public class Tiger extends Animal {
    public Tiger(String name) {
        super(name, "Tiger");
    }

    @Override
    void giveFood() {
        setHunger(Math.max(getHunger() - 30, 0));
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);
    }

    @Override
    void giveWater() {
        setHunger(getHunger() + 15);
        setThirst(Math.max(getThirst() - 30, 0));
        setBoredom(getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }

    @Override
    void giveToy() {
        setHunger(getHunger() + 15);
        setThirst(getThirst() + 15);
        setBoredom(Math.max(getBoredom() - 30, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
    }
}
