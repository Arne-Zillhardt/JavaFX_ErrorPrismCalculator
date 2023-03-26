package Optics;

import java.util.ArrayList;

public class ToricLens extends Lens{
    double cylinder;
    double axis;

    public ToricLens(ArrayList<Double> attributes) {
        super(attributes);
        toric = true;

        cylinder = attributes.get(5);
        axis = attributes.get(6);
    }

    public void setAxis(double axis) {
        this.axis = axis;
    }

    public double getCylinder() {
        return cylinder;
    }

    public double getAxis() {
        return axis;
    }
}
