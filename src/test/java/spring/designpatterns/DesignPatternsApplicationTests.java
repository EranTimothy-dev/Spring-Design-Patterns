package spring.designpatterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.designpatterns.adapter.Apple;
import spring.designpatterns.adapter.AppleAdapter;
import spring.designpatterns.adapter.MoroOrange;
import spring.designpatterns.adapter.Orange;
import spring.designpatterns.decorator.example1.Pepparoni;
import spring.designpatterns.decorator.example1.Pizza;
import spring.designpatterns.decorator.example1.ThickCrustPizza;
import spring.designpatterns.decorator.example2.BoldTextDecorator;
import spring.designpatterns.decorator.example2.ItalicTextDecorator;
import spring.designpatterns.decorator.example2.PlainText;
import spring.designpatterns.decorator.example2.Text;
import spring.designpatterns.prototype.example1.NotPrototype;
import spring.designpatterns.prototype.example1.Prototype;
import spring.designpatterns.prototype.example2.Soldier;
import spring.designpatterns.singleton.SingletonA;
import spring.designpatterns.singleton.SingletonB;

@SpringBootTest
class DesignPatternsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SingletonB singletonB1;

    @Autowired
    SingletonB singletonB2;

    @Test
    public void testSingleton(){
        SingletonA singletonA1 = SingletonA.getInstance();
        SingletonA singletonA2 = SingletonA.getInstance();
        Assertions.assertNotNull(singletonA1);
        Assertions.assertNotNull(singletonB2);

        Assertions.assertSame(singletonA1, singletonA2);
        Assertions.assertSame(singletonB1, singletonB2);
    }

    @Autowired
    Prototype prototype1;
    @Autowired
    Prototype prototype2;
    @Autowired
    NotPrototype notPrototype1;
    @Autowired
    NotPrototype notPrototype2;

    @Test
    public void testPrototypeEx1(){
        Assertions.assertSame(notPrototype1, notPrototype2);
        Assertions.assertNotSame(prototype1, prototype2);
    }

    @Test
    public void testAdapter(){
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVariety());
        apple.eat();
    }

    @Test
    public void testDecoratorEx1(){
        Pizza pizza = new ThickCrustPizza();
        System.out.println(pizza.getCost());
        System.out.println(pizza.getDescription());

        Pepparoni pepparoniPizza = new Pepparoni(pizza);
        System.out.println(pepparoniPizza.getCost());
        System.out.println(pepparoniPizza.getDescription());

        Pepparoni doublePepparoniPizza = new Pepparoni(pepparoniPizza);
        System.out.println(doublePepparoniPizza.getCost());
        System.out.println(doublePepparoniPizza.getDescription());
    }

    @Test
    public void testPrototypeEx2(){
        // Create prototype
        Soldier prototype = new Soldier();

        // Clone prototype to create new instances
        Soldier soldier1 = prototype.clone();
        Soldier soldier2 = prototype.clone();

        // Modify cloned objects independently
        soldier1.setWeapon("Bow");
        soldier2.setWeapon("Axe");

        // Display cloned objects
        System.out.println(soldier1);
        System.out.println(soldier2);
    }

    @Test
    public void testDecoratorEx2(){
        Text plainText = new PlainText("Hello world");

        // Apply bold decorator
        Text boldText = new BoldTextDecorator(plainText);

        // Apply italic decorator
        Text italicBoldText = new ItalicTextDecorator(boldText);


        // Render decorated text
        System.out.println("Plain Text: " + plainText.render());
        System.out.println("Bold Text: " + boldText.render());
        System.out.println("Bold Italic Text: " + italicBoldText.render());
    }


}
