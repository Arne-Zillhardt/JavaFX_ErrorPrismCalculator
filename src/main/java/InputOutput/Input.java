package InputOutput;

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
        }
    }

    public ArrayList<Double> getInputs() {
        return inputs;
    }
}
