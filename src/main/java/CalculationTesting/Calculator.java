package CalculationTesting;

import Optics.Lens;
import Optics.Optics;
import Optics.ToricLens;

import java.util.ArrayList;

public class Calculator {
    public void errorPrismHorizontally(Lens lens) {
        double c = lens.getDesiredPD() - lens.getpD();

        lens.setBaseHorizontally(Optics.BA);
        if (lens.getEffect().equals(Optics.PLUS)) {
            lens.setBaseHorizontally(Optics.BI);
        }

        if (lens.getDesiredPD() < lens.getpD()) {
            c = lens.getpD() - lens.getDesiredPD();

            lens.setBaseHorizontally(Optics.BI);
            if (lens.getEffect().equals(Optics.PLUS)) {
                lens.setBaseHorizontally(Optics.BA);
            }
        }

        c /= 10;
        double errPriHor = c * Math.abs(lens.getPower());
        lens.setErrorPrismHorizontally(errPriHor);
    }

    public void errorPrismVertically(Lens lens) {
        double c = lens.getDesiredY() - lens.getY();

        lens.setBaseVertically(Optics.BO);
        if (lens.getEffect().equals(Optics.PLUS)) {
            lens.setBaseVertically(Optics.BU);
        }

        if (lens.getDesiredY() < lens.getY()) {
            c = lens.getY() - lens.getDesiredY();

            lens.setBaseVertically(Optics.BU);
            if (lens.getEffect().equals(Optics.PLUS)) {
                lens.setBaseVertically(Optics.BO);
            }
        }

        c /= 10;
        double errPriVer = c * Math.abs(lens.getPower());
        lens.setErrorPrismVertically(errPriVer);
    }

    public void horizontalTolerance(ArrayList<Lens> lenses) {
        double power = Math.abs(lenses.get(0).getPower());
        for (Lens lens : lenses) {
            double tmpPower = Math.abs(lens.getPower());
            power = Math.min(power, tmpPower);
        }

        double tolerance = 0.67;
        if (power > 3.25) {
            tolerance = 0.2 * power;
        }

        Lens.setHorizontalTolerance(tolerance);
    }

    public void verticalTolerance(ArrayList<Lens> lenses) {
        double power = Math.abs(lenses.get(0).getPower());
        for (Lens lens : lenses) {
            double tmpPower = Math.abs(lens.getPower());
            power = Math.min(power, tmpPower);
        }

        double tolerance = 0.5;
        if (power > 5) {
            tolerance = 0.1 * power;
        }

        Lens.setVerticalTolerance(tolerance);
    }

    public void overallErrorPrismHorizontally(Lens lens1, Lens lens2) {
        double oveErrPriHor = lens1.getErrorPrismHorizontally() + lens2.getErrorPrismHorizontally();
        Lens.setOverallBaseHorizontally(lens1.getBaseHorizontally());

        if (!lens1.getBaseHorizontally().equals(lens2.getBaseHorizontally())) {
            oveErrPriHor = lens1.getErrorPrismHorizontally() - lens2.getErrorPrismHorizontally();
            Lens.setOverallBaseHorizontally(lens1.getBaseHorizontally());

            if (lens1.getErrorPrismHorizontally() < lens2.getErrorPrismHorizontally()) {
                oveErrPriHor = lens2.getErrorPrismHorizontally() - lens1.getErrorPrismHorizontally();
                Lens.setOverallBaseHorizontally(lens2.getBaseHorizontally());
            }
        }

        Lens.setOverallErrorPrismHorizontally(oveErrPriHor);
    }

    public void overallErrorPrismVertically(Lens lens1, Lens lens2) {
        double oveErrPriVer = lens1.getErrorPrismHorizontally() + lens2.getErrorPrismHorizontally();

        if (lens1.getBaseVertically().equals(lens2.getBaseVertically())) {
            oveErrPriVer = lens1.getErrorPrismHorizontally() - lens2.getErrorPrismHorizontally();

            if (lens1.getErrorPrismHorizontally() < lens2.getErrorPrismHorizontally()) {
                oveErrPriVer = lens2.getErrorPrismHorizontally() - lens1.getErrorPrismHorizontally();
            }
        }

        Lens.setOverallErrorPrismVertically(oveErrPriVer);
    }

    public ToricLens power90Degrees(ToricLens l) {
        ToricLens lens = new ToricLens(l.getAttributes());
        lens.setSide(l.getSide());

        double diff = l.getAxis() - 90;
        if (l.getAxis() < 90) {
            diff = 90 - l.getAxis();
        }

        double power = l.getPower() + l.getCylinder() * Math.pow(Math.sin(Math.toRadians(diff)), 2);
        lens.setPower(power);
        lens.setAxis(90);

        return lens;
    }

    public ToricLens power0Degrees(ToricLens l) {
        ToricLens lens = new ToricLens(l.getAttributes());
        lens.setSide(l.getSide());

        double diff = l.getAxis();

        double power = l.getPower() + l.getCylinder() * Math.pow(Math.sin(Math.toRadians(diff)), 2);
        lens.setPower(power);
        lens.setAxis(0);

        return lens;
    }
}