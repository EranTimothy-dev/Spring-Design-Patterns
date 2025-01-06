package spring.designpatterns.decorator.example1;

import java.math.BigDecimal;

public abstract class Pizza {

    protected String description;

    public String getDescription() {
        return this.description;
    }

    public abstract BigDecimal getCost();
}
