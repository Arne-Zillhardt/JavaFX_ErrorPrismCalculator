package InputOutput;

import Optics.Lens;
import Optics.ToricLens;
import Optics.Optics;

import java.util.ArrayList;

public class Output {
    public void prompt(Input inR, Input inL) {
        System.out.print("D right = ");
        inR.input(); //0

        System.out.print("D left = ");
        inL.input(); //0

        System.out.println();

        System.out.print("Desired PD right = ");
        inR.input(); //1
        System.out.print("PD right = ");
        inR.input(); //2

        System.out.print("Desired Y right = ");
        inR.input(); //3
        System.out.print("Y right = ");
        inR.input(); //4

        System.out.println();

        System.out.print("Desired PD left = ");
        inL.input(); //1
        System.out.print("PD left = ");
        inL.input(); //2

        System.out.print("Desired Y left = ");
        inL.input(); //3
        System.out.print("Y left = ");
        inL.input(); //4

        System.out.println();

        System.out.print("Cyl right = ");
        inR.input(); //5
        System.out.print("A right = ");
        inR.input(); //6

        System.out.println();

        System.out.print("Cyl left = ");
        inL.input(); //5
        System.out.print("A left = ");
        inL.input(); //6
    }

    public void result(ArrayList<Lens> lenses) {

        for (int i = 0; i <= 5; i++) {
            System.out.println();
        }

        for (Lens lens : lenses) {
            String baseH;
            String baseV;
            String side = lens.getSide();

            if (!lens.isToric()) {
                baseH = "B.a.";
                if (lens.getBaseHorizontally().equals(Optics.BI)) {
                    baseH = "B.i.";
                }
                baseV = "B.o.";
                if (lens.getBaseVertically().equals(Optics.BU)) {
                    baseV = "B.u.";
                }

                System.out.printf("A prism of %.2f %s pdpt occurs on the %s side horizontally\n", lens.getErrorPrismHorizontally(), baseH, side);
                System.out.printf("A prism of %.2f %s pdpt occurs on the %s side vertically\n", lens.getErrorPrismHorizontally(), baseV, side);
            } else {
                if (((ToricLens) lens).getAxis() == 0) {
                    baseH = "B.a.";
                    if (lens.getBaseHorizontally().equals(Optics.BI)) {
                        baseH = "B.i.";
                    }

                    System.out.printf("A prism of %.2f %s pdpt occurs on the %s side horizontally", lens.getErrorPrismHorizontally(), baseH, side);
                } else {
                    baseV = "B.o.";
                    if (lens.getBaseVertically().equals(Optics.BU)) {
                        baseV = "B.u.";
                    }

                    System.out.printf("A prism of %.2f %s pdpt occurs on the %s side vertically\n", lens.getErrorPrismHorizontally(), baseV, side);
                }
            }

            System.out.println();
        }

        System.out.println();

        String baseH = "B.a.";
        if (Lens.getOverallBaseHorizontally().equals(Optics.BI)) {
            baseH = "B.i.";
        }

        System.out.printf("The overall horizontal prism is %.2f %s pdpt\n", Lens.getOverallErrorPrismHorizontally(), baseH);
        System.out.printf("The overall vertical prism is %.2f pdpt\n", Lens.getOverallErrorPrismVertically());
        System.out.println();

        if (Lens.isValidation()) {
            System.out.printf("You can give the customer the glasses, because overall horizontal prism is %.2f pdpt and the tolerance is %.2f pdpt\n", Lens.getOverallErrorPrismHorizontally(), Lens.getHorizontalTolerance());
        } else {
            System.out.printf("You can't give the customer the glasses, because overall horizontal prism is %.2f pdpt and the tolerance is %.2f pdpt\n", Lens.getOverallErrorPrismHorizontally(), Lens.getHorizontalTolerance());
        }

        System.out.printf("Also the overall horizontal prism is %.2f pdpt and the tolerance is %.2f pdpt", Lens.getOverallErrorPrismVertically(), Lens.getVerticalTolerance());
    }
}