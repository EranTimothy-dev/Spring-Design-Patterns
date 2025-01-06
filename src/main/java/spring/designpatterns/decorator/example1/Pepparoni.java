package spring.designpatterns.decorator.example1;

import java.math.BigDecimal;

public class Pepparoni extends PizzaIngredient{

    private Pizza pizza;

    public Pepparoni(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + "+ pepparoni";
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(1.5).add(this.pizza.getCost());
    }
}
