package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Pane main;
    @FXML
    Ellipse ellipse;

    double theta = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        coordMaxX.setText("(" + ellipse.getBoundsInParent().getMaxX() + "," + centroY + ")");
//        coordMinX.setText("(" + ellipse.getBoundsInParent().getMinX() + "," + centroY + ")");
//        coordMaxY.setText("(" + centroY + "," + ellipse.getBoundsInParent().getMaxY() + ")");
//        coordMinY.setText("(" + centroY + "," + ellipse.getBoundsInParent().getMinY() + ")");

//        theta = 0;  // angle that will be increased each loop
//        h = 12      // x coordinate of circle center
//        k = 10      // y coordinate of circle center
//        step = 15;  // amount to add to theta each time (degrees)
//        var x = h +       r*Math.cos(theta) ;
//        var y = k - 0.5 * r*Math.sin(theta) ;


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 2; i++) {
//                    for (theta = 0; theta < 2 * Math.PI; theta += step) {
//                        Platform.runLater(() -> {
//                            main.getChildren().remove(nvo2);
//                            nvo2.setCenterX(centroX + ellipse.getRadiusX() * Math.cos(theta));
//                            nvo2.setCenterY(centroY - 0.8 * ellipse.getRadiusY() * Math.sin(theta));
//                            main.getChildren().add(nvo2);
//                        });
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }).start();

    }

    public void printEllipse() {
        System.out.println(ellipse.toString());
        System.out.println("H: " + ellipse.getBoundsInLocal().getHeight());
        System.out.println("D: " + ellipse.getBoundsInLocal().getWidth());
    }

    public void iniciarCorrida() {
        double centroX = (ellipse.getBoundsInParent().getMaxX() - ellipse.getBoundsInParent().getMinX()) / 2 + ellipse.getBoundsInParent().getMinX();
        double centroY = (ellipse.getBoundsInParent().getMaxY() - ellipse.getBoundsInParent().getMinY()) / 2 + ellipse.getBoundsInParent().getMinY();

        Circle nvo = new Circle();
        nvo.setRadius(5);
        Circle nvo2 = new Circle();
        nvo2.setRadius(5);
        nvo2.setFill(Color.RED);
        nvo.setCenterX(centroX + ellipse.getRadiusX() * Math.cos(theta- (02 * Math.PI / 20)));
        nvo.setCenterY(centroY - ellipse.getRadiusY() * Math.sin(theta - (02 * Math.PI / 20)));
        nvo2.setCenterX(centroX + ellipse.getRadiusX() * Math.cos(theta - (02 * Math.PI / 40)));
        nvo2.setCenterY(centroY - ellipse.getRadiusY() * Math.sin(theta - (02 * Math.PI / 40)));
        main.getChildren().add(nvo);
        main.getChildren().add(nvo2);

//        double step = 02 * Math.PI / 50;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 3; i++) {
//                    for (theta = 0; theta < 2 * Math.PI; theta += step) {
//                        Platform.runLater(() -> {
//                            main.getChildren().remove(nvo);
//                            nvo.setCenterX(centroX + ellipse.getRadiusX() * Math.cos(theta));
//                            nvo.setCenterY(centroY - ellipse.getRadiusY() * Math.sin(theta));
//                            main.getChildren().add(nvo);
//                        });
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }).start();
    }
}
