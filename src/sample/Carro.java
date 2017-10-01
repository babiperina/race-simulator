package sample;

import javafx.scene.shape.Circle;

import java.util.Random;

public class Carro {

    private Circle carro;
    private double velocidade;
    private double curva;

    public Carro(double radius, double x, double y, double curva) {
        carro = new Circle();
        carro.setRadius(radius);
        carro.setCenterX(x);
        carro.setCenterY(y);
        velocidade = 20 + new Random().nextInt(40);
        this.curva = curva;
    }

    public Circle displayCarro() {
        return carro;
    }

    public Circle displayCarro(double x, double y) {
        carro.setCenterX(x);
        carro.setCenterX(y);
        return carro;
    }

    public double getVelocidade() {
        return velocidade;
    }
}
