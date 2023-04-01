package Main;

import static javafx.application.Application.launch;

public class Main {
    public static Program program;

    public static void main(String[] args) {
        /*Program program = new Program();
        program.start();

         */

        program = new Program();
        launch(Program.class, args);
    }
}
