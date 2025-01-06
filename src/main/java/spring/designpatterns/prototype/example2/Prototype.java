package spring.designpatterns.prototype.example2;

public class Prototype implements Cloneable{
    @Override
    protected Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
