package InputOutput;

import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {
    ArrayList<Double> inputs;
    BufferedReader reader;

    public Input() {
        inputs = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    void input() {
        try {
            String s = reader.readLine();

            double d = Double.parseDouble(s);

            inputs.add(d);
        } catch (Exception e) {
            //Ignore
        }
    }

    void input(ArrayList<TextField> text) {
        for (TextField field : text) {
            try {
                double d = Double.parseDouble(field.getText());

                inputs.add(d);
            } catch (Exception e) {
                //Ignore
            }
        }
    }

    public ArrayList<Double> getInputs() {
        return inputs;
    }
}
