package Main;

import CalculationTesting.Calculator;
import CalculationTesting.Testing;
import InputOutput.GUI;
import InputOutput.Input;
import InputOutput.Output;
import Optics.Lens;
import Optics.ToricLens;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Program extends Application{
    Output output;
    Input inputRight;
    Input inputLeft;
    Calculator calculator;
    Testing testing;
    GUI gui;
    ArrayList<Lens> lenses;
    ArrayList<Lens> horTorLenses;
    ArrayList<Lens> verTorLenses;
    public static GridPane pane;
    public static Stage stage;
    public static Scene scene;

    public void start(Input inputR, Input inputL) {
        output = new Output();
        inputRight = inputR;
        inputLeft = inputL;
        calculator = new Calculator();
        testing = new Testing();
        lenses = new ArrayList<>();
        horTorLenses = new ArrayList<>();
        verTorLenses = new ArrayList<>();

        //output.prompt(inputRight, inputLeft);

        if (inputRight.getInputs().size() == 5) {
            Lens right = new Lens(inputRight.getInputs());
            right.setSide("right");
            lenses.add(right);
            horTorLenses.add(lenses.get(lenses.size() - 1));
            verTorLenses.add(lenses.get(lenses.size() - 1));
        } else {
            ToricLens right = new ToricLens(inputRight.getInputs());
            right.setSide("right");
            lenses.add(calculator.power0Degrees(right));
            horTorLenses.add(lenses.get(lenses.size() - 1));
            lenses.add(calculator.power90Degrees(right));
            verTorLenses.add(lenses.get(lenses.size() - 1));
        }

        if (inputLeft.getInputs().size() == 5) {
            Lens left = new Lens(inputLeft.getInputs());
            left.setSide("left");
            lenses.add(left);
            horTorLenses.add(lenses.get(lenses.size() - 1));
            verTorLenses.add(lenses.get(lenses.size() - 1));
        } else {
            ToricLens left = new ToricLens(inputLeft.getInputs());
            left.setSide("left");
            lenses.add(calculator.power0Degrees(left));
            horTorLenses.add(lenses.get(lenses.size() - 1));
            lenses.add(calculator.power90Degrees(left));
            verTorLenses.add(lenses.get(lenses.size() - 1));
        }

        for (Lens lens : horTorLenses) {
            calculator.errorPrismHorizontally(lens);
        }
        for (Lens lens : verTorLenses) {
            calculator.errorPrismVertically(lens);
        }

        calculator.overallErrorPrismHorizontally(horTorLenses.get(0), horTorLenses.get(1));
        calculator.overallErrorPrismVertically(verTorLenses.get(0), verTorLenses.get(1));

        calculator.horizontalTolerance(lenses);
        calculator.verticalTolerance(lenses);

        testing.validation();

        output.result(lenses);
    }

    @Override
    public void start(Stage st) throws Exception {
        pane = new GridPane();
        scene = new Scene(pane, 700, 400);
        stage = new Stage();

        gui = new GUI();
        gui.setUp();

        stage.setScene(scene);
        stage.show();
    }
}