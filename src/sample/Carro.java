package sample;

import javafx.scene.shape.Circle;

public class Carro {

    Circle carro;

    public Carro(double radius, double x, double y) {
        carro = new Circle();
        carro.setRadius(radius);
        carro.setCenterX(x);
        carro.setCenterY(y);
    }

    public Circle displayCarro() {
        return carro;
    }

    public Circle displayCarro(double x, double y) {
        carro.setCenterX(x);
        carro.setCenterX(y);
        return carro;
    }
}
