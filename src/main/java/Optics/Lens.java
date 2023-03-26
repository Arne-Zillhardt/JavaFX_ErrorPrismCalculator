package Optics;

import java.util.ArrayList;

public class Lens {
    double power;
    Optics effect;
    double desiredPD;
    double pD;
    double desiredY;
    double y;
    boolean toric;
    ArrayList<Double> attributes;

    double errorPrismHorizontally;
    Optics baseHorizontally;
    double errorPrismVertically;
    Optics baseVertically;

    static double overallErrorPrismHorizontally;
    static Optics overallBaseHorizontally;
    static double overallErrorPrismVertically;
    static double horizontalTolerance;
    static double verticalTolerance;

    static boolean validation;

    String side;

    public Lens(ArrayList<Double> attributes) {
        power = attributes.get(0);
        effect = Optics.MINUS;
        if (power > 0) {
            effect = Optics.PLUS;
        }

        desiredPD = attributes.get(1);
        pD = attributes.get(2);
        desiredY = attributes.get(3);
        y = attributes.get(4);
        toric = false;

        this.attributes = attributes;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setErrorPrismHorizontally(double errorPrismHorizontally) {
        this.errorPrismHorizontally = errorPrismHorizontally;
    }

    public void setErrorPrismVertically(double errorPrismHorizontally) {
        this.errorPrismHorizontally = errorPrismHorizontally;
    }

    public void setBaseHorizontally(Optics baseHorizontally) {
        this.baseHorizontally = baseHorizontally;
    }

    public void setBaseVertically(Optics baseVertically) {
        this.baseVertically = baseVertically;
    }

    public static void setOverallErrorPrismHorizontally(double overallErrorPrismHorizontally) {
        Lens.overallErrorPrismHorizontally = overallErrorPrismHorizontally;
    }

    public static void setOverallBaseHorizontally(Optics overallBaseHorizontally) {
        Lens.overallBaseHorizontally = overallBaseHorizontally;
    }

    public static void setOverallErrorPrismVertically(double overallErrorPrismVertically) {
        Lens.overallErrorPrismVertically = overallErrorPrismVertically;
    }

    public static void setHorizontalTolerance(double horizontalTolerance) {
        Lens.horizontalTolerance = horizontalTolerance;
    }

    public static void setVerticalTolerance(double verticalTolerance) {
        Lens.verticalTolerance = verticalTolerance;
    }

    public static void setValidation(boolean validation) {
        Lens.validation = validation;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public ArrayList<Double> getAttributes() {
        return attributes;
    }

    public double getPower() {
        return power;
    }

    public Optics getEffect() {
        return effect;
    }

    public double getDesiredPD() {
        return desiredPD;
    }

    public double getpD() {
        return pD;
    }

    public double getDesiredY() {
        return desiredY;
    }

    public double getY() {
        return y;
    }

    public boolean isToric() {
        return toric;
    }

    public double getErrorPrismHorizontally() {
        return errorPrismHorizontally;
    }

    public Optics getBaseHorizontally() {
        return baseHorizontally;
    }

    public void getBaseHorizontally(Optics baseVertically) {
        this.baseVertically = baseVertically;
    }

    public double getErrorPrismVertically() {
        return errorPrismVertically;
    }

    public Optics getBaseVertically() {
        return baseVertically;
    }

    public static double getOverallErrorPrismHorizontally() {
        return overallErrorPrismHorizontally;
    }

    public static Optics getOverallBaseHorizontally() {
        return overallBaseHorizontally;
    }

    public static double getOverallErrorPrismVertically() {
        return overallErrorPrismVertically;
    }

    public static double getHorizontalTolerance() {
        return horizontalTolerance;
    }

    public static double getVerticalTolerance() {
        return verticalTolerance;
    }

    public static boolean isValidation() {
        return validation;
    }

    public String getSide() {
        return side;
    }
}