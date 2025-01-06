package spring.designpatterns.prototype.example2;

public class Soldier extends Prototype{
    private String weapon;
    private int health;
    private Equipment equipment; // Sensitive sub-object

    // Constructor with expensive setup
    public Soldier() {
        System.out.println("Loading assets and initializing stats...");
        this.weapon = "Sword";
        this.health = 100;
        this.equipment = new Equipment("Shield", "Armor");
    }

    // 3. Override clone method to provide class-specific behavior
    @Override
    public Soldier clone() {
        Soldier cloned = (Soldier) super.clone();
        // 4. Clone sensitive sub-objects to prevent threading issues
        cloned.equipment = this.equipment.clone();
        return cloned;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Soldier [Weapon=" + weapon + ", Health=" + health + ", Equipment=" + equipment + "]";
    }
}
