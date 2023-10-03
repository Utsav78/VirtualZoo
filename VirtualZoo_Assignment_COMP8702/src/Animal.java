public class Animal {
    private String name;
    private String species;
    private int hunger = 50;
    private int thirst = 50;
    private int boredom = 50;
    //private String previousItem = "";


    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public boolean isDead() {
        return hunger > 100 || thirst > 100 || boredom > 100;
    }

    public void giveFood() {
        hunger = Math.max(hunger - 30, 0); // to select zero when the hunger goes negative
        thirst += 15;
        boredom += 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(name + " has died");
        }
    }

    public void giveWater() {
        hunger += 15;
        thirst = Math.max(thirst - 30, 0);
        boredom += 15;
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(name + " has died");
        }
    }

    public void giveToy() {
        hunger += 15;
        thirst += 15;
        boredom = Math.max(boredom - 30, 0);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
        if (isDead()) {
            VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 1000);
            System.out.println(name + " has died");
        }

    }


    public String toString() {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }
}