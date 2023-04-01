package InputOutput;

import Main.Main;
import Main.Program;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class GUI {
    static GridPane outPane;
    GridPane pane;
    ArrayList<TextField> textFieldsR;
    ArrayList<TextField> textFieldsL;
    Input inputR;
    Input inputL;

    public void setUp() {
        Program.pane.setAlignment(Pos.CENTER);
        Program.pane.setHgap(20);
        Program.pane.setVgap(20);

        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        Label infoLabel = new Label("Error Prism Calculator");
        infoLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        HBox infHBox = new HBox();
        infHBox.getChildren().add(infoLabel);
        infHBox.setAlignment(Pos.CENTER);

        Label rLabel = new Label("R");
        rLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        Label lLabel = new Label("L");
        lLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Label dLabel = new Label("D");
        TextField dTextFieldR = new TextField();
        TextField dTextFieldL = new TextField();
        dTextFieldR.setPrefSize(60, 20);
        dTextFieldL.setPrefSize(60, 20);
        HBox dHBox = new HBox();
        dHBox.getChildren().add(dLabel);
        dHBox.setAlignment(Pos.CENTER);

        Label cylLabel = new Label("Cyl");
        TextField cylTextFieldR = new TextField();
        TextField cylTextFieldL = new TextField();
        cylTextFieldR.setPrefSize(60, 20);
        cylTextFieldL.setPrefSize(60, 20);
        HBox cylHBox = new HBox();
        cylHBox.getChildren().add(cylLabel);
        cylHBox.setAlignment(Pos.CENTER);

        Label aLabel = new Label("A");
        TextField aTextFieldR = new TextField();
        TextField aTextFieldL = new TextField();
        aTextFieldR.setPrefSize(60, 20);
        aTextFieldL.setPrefSize(60, 20);
        HBox aHBox = new HBox();
        aHBox.getChildren().add(aLabel);
        aHBox.setAlignment(Pos.CENTER);

        Label desPDLabel = new Label("Desired PD");
        TextField desPDTextFieldR = new TextField();
        TextField desPDTextFieldL = new TextField();
        desPDTextFieldR.setPrefSize(60, 20);
        desPDTextFieldL.setPrefSize(60, 20);
        HBox desPdHBox = new HBox();
        desPdHBox.getChildren().add(desPDLabel);
        desPdHBox.setAlignment(Pos.CENTER);

        Label pDLabel = new Label("PD");
        TextField pDTextFieldR = new TextField();
        TextField pDTextFieldL = new TextField();
        pDTextFieldR.setPrefSize(60, 20);
        pDTextFieldL.setPrefSize(60, 20);
        HBox pdHBox = new HBox();
        pdHBox.getChildren().add(pDLabel);
        pdHBox.setAlignment(Pos.CENTER);

        Label desYLabel = new Label("Desired Y");
        TextField desYTextFieldR = new TextField();
        TextField desYTextFieldL = new TextField();
        desYTextFieldR.setPrefSize(60, 20);
        desYTextFieldL.setPrefSize(60, 20);
        HBox desYHBox = new HBox();
        desYHBox.getChildren().add(desYLabel);
        desYHBox.setAlignment(Pos.CENTER);

        Label yLabel = new Label("Y");
        TextField yTextFieldR = new TextField();
        TextField yTextFieldL = new TextField();
        yTextFieldR.setPrefSize(60, 20);
        yTextFieldL.setPrefSize(60, 20);
        HBox yHBox = new HBox();
        yHBox.getChildren().add(yLabel);
        yHBox.setAlignment(Pos.CENTER);

        Button submit = new Button("Calculate");
        submit.setOnAction(event -> {
            textFieldsR = new ArrayList<>();
            textFieldsL = new ArrayList<>();

            inputR = new Input();
            inputL = new Input();

            textFieldsR.add(dTextFieldR);
            textFieldsR.add(desPDTextFieldR);
            textFieldsR.add(pDTextFieldR);
            textFieldsR.add(desYTextFieldR);
            textFieldsR.add(yTextFieldR);
            textFieldsR.add(cylTextFieldR);
            textFieldsR.add(aTextFieldR);

            textFieldsL.add(dTextFieldL);
            textFieldsL.add(desPDTextFieldL);
            textFieldsL.add(pDTextFieldL);
            textFieldsL.add(desYTextFieldL);
            textFieldsL.add(yTextFieldL);
            textFieldsL.add(cylTextFieldL);
            textFieldsL.add(aTextFieldL);

            inputR.input(textFieldsR);
            inputL.input(textFieldsL);

            Main.program.start(inputR, inputL);
        });
        HBox subHBox = new HBox();
        subHBox.getChildren().add(submit);
        subHBox.setAlignment(Pos.CENTER);


        Program.pane.add(infHBox, 0, 0);

        pane.add(rLabel, 0, 1);
        pane.add(lLabel, 0, 2);

        pane.add(dHBox, 1, 0);
        pane.add(dTextFieldR, 1, 1);
        pane.add(dTextFieldL, 1, 2);

        pane.add(cylHBox, 2, 0);
        pane.add(cylTextFieldR, 2, 1);
        pane.add(cylTextFieldL, 2, 2);

        pane.add(aHBox, 3, 0);
        pane.add(aTextFieldR, 3, 1);
        pane.add(aTextFieldL, 3, 2);

        pane.add(desPdHBox, 4, 0);
        pane.add(desPDTextFieldR, 4, 1);
        pane.add(desPDTextFieldL, 4, 2);

        pane.add(pdHBox, 5, 0);
        pane.add(pDTextFieldR, 5, 1);
        pane.add(pDTextFieldL, 5, 2);

        pane.add(desYHBox, 6, 0);
        pane.add(desYTextFieldR, 6, 1);
        pane.add(desYTextFieldL, 6, 2);

        pane.add(yHBox, 7, 0);
        pane.add(yTextFieldR, 7, 1);
        pane.add(yTextFieldL, 7, 2);

        Program.pane.add(subHBox, 0, 2);

        Program.pane.add(pane, 0, 1);
    }

    static void output(ArrayList<String> text) {
        Program.pane.getChildren().remove(outPane);
        outPane = new GridPane();
        outPane.setAlignment(Pos.CENTER);

        int i = 0;
        for (String s : text) {
            Label label = new Label(s);
            label.setFont(Font.font("Arial", FontWeight.BOLD, 13));

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(label);

            outPane.add(hBox, 0, i);

            i++;
        }

        Program.pane.add(outPane, 0, 3);
    }
}