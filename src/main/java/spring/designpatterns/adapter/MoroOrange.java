package spring.designpatterns.adapter;

import java.sql.SQLOutput;

public class MoroOrange implements Orange{

    @Override
    public String getVariety() {
        return "Moro Blood Orange";
    }

    @Override
    public void eat() {
        System.out.println("Moro gets enjoyed");
    }

    @Override
    public void peel() {
        System.out.println("Moro gets peeled");
    }

    @Override
    public void juice() {
        System.out.println("Moro gets juice");
    }
}
