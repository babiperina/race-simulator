package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Pane main;
    @FXML
    Ellipse ellipse;

    @FXML
    Circle primeiroColocado;

    @FXML
    Circle segundoColocado;

    @FXML
    Button desenhar;
    @FXML
    Button start;

    private int qtdeCarros;
    private double centroX;
    private double centroY;

    private double theta = 0;
    private int velocidade = 0;

    private ArrayList<Circle> carros = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Runtime runtime = Runtime.getRuntime();
        qtdeCarros = runtime.availableProcessors();
    }

    public void printEllipse() {
        System.out.println(ellipse.toString());
        System.out.println("H: " + ellipse.getBoundsInLocal().getHeight());
        System.out.println("D: " + ellipse.getBoundsInLocal().getWidth());
    }

    public void desenharCarros() {
        centroX = (ellipse.getBoundsInParent().getMaxX() - ellipse.getBoundsInParent().getMinX()) / 2 + ellipse.getBoundsInParent().getMinX();
        centroY = (ellipse.getBoundsInParent().getMaxY() - ellipse.getBoundsInParent().getMinY()) / 2 + ellipse.getBoundsInParent().getMinY();

        int distancia = 50;

        for (int i = 0; i < qtdeCarros; i++) {
            carros.add(new Circle(centroX + ellipse.getRadiusX() * Math.cos(theta - (02 * Math.PI / distancia)), centroY - ellipse.getRadiusY() * Math.sin(theta - (02 * Math.PI / distancia)), 8, Paint.valueOf(getRandomColor())));
        }

        for (Circle carro : carros) {
//            System.out.println(carro);
            main.getChildren().add(carro);
        }

        desenhar.setDisable(true);

    }


    public void comecarCorrida() {
        double step = 02 * Math.PI / 50;
        theta = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < qtdeCarros; i++) {
                    for (theta = 0; theta < 2 * Math.PI; theta += step) {
                        Platform.runLater(() -> {
                            for (Circle carro : carros) {
                                main.getChildren().remove(carro);
                                do {
                                    velocidade = new Random().nextInt(20);
                                } while (velocidade < 10);
                                carro.setCenterX(centroX + ellipse.getRadiusX() * Math.cos(theta + 02 * Math.PI / velocidade));
                                carro.setCenterY(centroY - ellipse.getRadiusY() * Math.sin(theta + 02 * Math.PI / velocidade));
                                main.getChildren().add(carro);
                            }
                        });
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (Circle carro : carros) {
                    System.out.println(carro.toString());
                }
                verDoisPrimeirosColocados();
            }
        }).start();


    }

    public String getRandomColor() {
        final Random random = new Random();
        final String[] letters = "0123456789ABCDEF".split("");
        String color = "#";
        for (int i = 0; i < 6; i++) {
            color += letters[Math.round(random.nextFloat() * 15)];
        }
        return color;
    }

    public void verDoisPrimeirosColocados() {
        double menor = 0;
        int imenor = 0;
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getCenterY() < menor) {
                menor = carros.get(i).getCenterY();
                imenor = i;
            }
        }
        primeiroColocado.setFill(carros.get(imenor).getFill());
        primeiroColocado.setVisible(true);

        double segundomenor = 0;
        int isegundomenor = 0;
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getCenterY() > segundomenor && isegundomenor != imenor) {
                segundomenor = carros.get(i).getCenterY();
                isegundomenor = i;
            }
        }

        segundoColocado.setFill(carros.get(isegundomenor).getFill());
        segundoColocado.setVisible(true);
    }
}
