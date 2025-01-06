package spring.designpatterns.prototype.example2;

public class Equipment extends Prototype{

    private String shield;
    private String armor;

    public Equipment(String shield, String armor) {
        this.shield = shield;
        this.armor = armor;
    }

    @Override
    protected Equipment clone() {
        return (Equipment) super.clone();
    }

    @Override
    public String toString() {
        return "[Shield=" + shield + ", Armor=" + armor + "]";
    }
}
