package Main;

import CalculationTesting.Calculator;
import CalculationTesting.Testing;
import InputOutput.Input;
import InputOutput.Output;
import Optics.Lens;
import Optics.ToricLens;

import java.util.ArrayList;

public class Program {
    Output output;
    Input inputRight;
    Input inputLeft;
    Calculator calculator;
    Testing testing;
    ArrayList<Lens> lenses;
    ArrayList<Lens> horTorLenses;
    ArrayList<Lens> verTorLenses;

    void start() {
        output = new Output();
        inputRight = new Input();
        inputLeft = new Input();
        calculator = new Calculator();
        testing = new Testing();
        lenses = new ArrayList<>();
        horTorLenses = new ArrayList<>();
        verTorLenses = new ArrayList<>();

        output.prompt(inputRight, inputLeft);

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

        /*if (inputRight.getInputs().size() == 5) {
            lenses.add(new Lens(inputRight.getInputs()));
            lenses.get(0).setSide("right");
            lenses.add(new Lens(inputLeft.getInputs()));
            lenses.get(1).setSide("left");
        } else {
            ToricLens right = new ToricLens(inputRight.getInputs());
            ToricLens left = new ToricLens(inputLeft.getInputs());

            lenses.add(calculator.power0Degrees(right));
            lenses.get(0).setSide("right");
            lenses.add(calculator.power90Degrees(right));
            lenses.get(1).setSide("right");

            lenses.add(calculator.power0Degrees(left));
            lenses.get(2).setSide("left");
            lenses.add(calculator.power90Degrees(left));
            lenses.get(3).setSide("left");
        }

         */

        for (Lens lens : horTorLenses) {
            calculator.errorPrismHorizontally(lens);
        }
        for (Lens lens : verTorLenses) {
            calculator.errorPrismVertically(lens);
        }

        /*for (Lens lens : lenses) {
            if (lens.isToric()) {
                if (((ToricLens) lens).getAxis() == 0) {
                    calculator.errorPrismHorizontally(lens);
                } else {
                    calculator.errorPrismVertically(lens);
                }
            } else {
                calculator.errorPrismHorizontally(lens);
                calculator.errorPrismVertically(lens);
            }
        }

         */

        calculator.overallErrorPrismHorizontally(horTorLenses.get(0), horTorLenses.get(1));
        calculator.overallErrorPrismVertically(verTorLenses.get(0), verTorLenses.get(1));

        /*if (horTorLenses.size() != 0 && verTorLenses.size() != 0) {
            calculator.overallErrorPrismHorizontally(horTorLenses.get(0), horTorLenses.get(1));
            calculator.overallErrorPrismVertically(verTorLenses.get(0), verTorLenses.get(1));
        } else {
            calculator.overallErrorPrismHorizontally(lenses.get(0), lenses.get(1));
            calculator.overallErrorPrismVertically(lenses.get(0), lenses.get(1));
        }

         */

        //

        calculator.horizontalTolerance(lenses);
        calculator.verticalTolerance(lenses);

        testing.validation();

        output.result(lenses);
    }
}