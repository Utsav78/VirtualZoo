public class Panda extends Animal {
    public Panda(String name) {
        super(name, "Panda");
    }

    @Override
    void giveFood() {
        setHunger(Math.max(getHunger() - 25, 0));
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() - 5);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 70);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }
    }

    @Override
    void giveWater() {
        setHunger(getHunger() + 40);
        setThirst(Math.max(getThirst() - 80, 0));
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }

    }

    @Override
    void giveToy() {
        setHunger(getHunger() + 40);
        setThirst(getThirst() + 15);
        setBoredom(Math.max(getBoredom() - 40, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(getName() + " has died");
        }
    }
}
