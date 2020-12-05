//Page 391 in the JavaFX Textbook
package spherejavafx;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SphereJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        //root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 300);
        PerspectiveCamera camera = new PerspectiveCamera(true);

        //Backs the camera away from the scene by 1000 units
        camera.setTranslateZ(-1000);

        //This is the range of which the camera will render objects
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);

        //The default field of view for the scene is 30 but change to suit
        camera.setFieldOfView(30);
        scene.setCamera(camera);

        //This sets up my sphere
        Sphere mysphere = new Sphere(150);
        mysphere.setTranslateX(-720);
        mysphere.setTranslateY(-300);
        mysphere.setTranslateZ(100);
        root.getChildren().add(mysphere);

        Sphere mysphere2 = new Sphere(150);
        mysphere2.setTranslateX(-520);
        mysphere2.setTranslateY(-560);
        mysphere2.setTranslateZ(100);
        root.getChildren().add(mysphere2);

        Sphere mysphere3 = new Sphere(150);
        mysphere3.setTranslateX(-920);
        mysphere3.setTranslateY(-560);
        mysphere3.setTranslateZ(100);
        root.getChildren().add(mysphere3);

        //This sets up the image of the earth to wrap around my sphere
        Image cecyiaImage = new Image("file:earth.jpg");
        Image coiaImage = new Image("file:Coia 2020-12-05-11-40.png");
        Image earthImage = new Image("file:Cecyia 2020-11-20-16-24.png");
        PhongMaterial earthPhong = new PhongMaterial();
        PhongMaterial coiaPhong = new PhongMaterial();
        PhongMaterial cecyiaPhong = new PhongMaterial();
        earthPhong.setDiffuseMap(earthImage);
        cecyiaPhong.setDiffuseMap(cecyiaImage);
        coiaPhong.setDiffuseMap(coiaImage);
        mysphere2.setMaterial(earthPhong);
        mysphere.setMaterial(cecyiaPhong);
        mysphere3.setMaterial(coiaPhong);

        //This rotates my sphere
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(mysphere);
        rotate.setDuration(Duration.millis(5000));
        rotate.setAxis(Rotate.X_AXIS);
        rotate.setByAngle(-360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setNode(mysphere2);
        rotate2.setDuration(Duration.millis(5000));
        rotate2.setAxis(Rotate.Y_AXIS);
        rotate2.setByAngle(360);
        rotate2.setCycleCount(Animation.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.play();

        RotateTransition rotate3 = new RotateTransition();
        rotate3.setNode(mysphere3);
        rotate3.setDuration(Duration.millis(5000));
        rotate3.setAxis(Rotate.Y_AXIS);
        rotate3.setByAngle(-360);
        rotate3.setCycleCount(Animation.INDEFINITE);
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate3.play();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
