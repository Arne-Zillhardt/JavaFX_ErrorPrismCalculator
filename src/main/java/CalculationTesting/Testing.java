package CalculationTesting;

import Optics.Lens;

public class Testing {
    public void validation() {
        boolean b = true;

        if (Lens.getOverallErrorPrismHorizontally() > Lens.getHorizontalTolerance()) {
            b = false;
        }
        if (Lens.getOverallErrorPrismVertically() > Lens.getHorizontalTolerance()) {
            b = false;
        }

        Lens.setValidation(b);
    }
}