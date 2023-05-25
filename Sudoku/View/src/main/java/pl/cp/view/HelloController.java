package pl.cp.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import pl.cp.BacktrackingSudokuSolver;
import pl.cp.DifficultyLevel;
import pl.cp.SudokuBoard;

public class HelloController {
    private SudokuBoard board;

    @FXML
    Button easy;

    @FXML
    Button medium;

    @FXML
    Button hard;

    @FXML
    GridPane gridPane;

    public void initialize() {
        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
    }

    public void populateGrid() {
        gridPane = new GridPane();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField field = new TextField(Integer.toString(board.getNumber(i, j)));
                field.setAlignment(Pos.CENTER);
                field.setPrefHeight(30);
                field.setPrefWidth(30);
                gridPane.add(field, i, j);
            }
        }

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setAlignment(Pos.CENTER);

    }

    public void setBoardScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("board-view.fxml"));
        Stage window = (Stage) easy.getScene().getWindow();
        populateGrid();
        window.setScene(new Scene(gridPane, 500, 700));
    }

    @FXML
    protected void onEasyButtonClick() throws Exception {

        initialize();
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Easy);
        dl.createBoard(board);
        setBoardScene();

    }

    @FXML
    protected void onMediumButtonClick() throws Exception {

        initialize();
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Medium);
        dl.createBoard(board);
        setBoardScene();
    }

    @FXML
    protected void onHardButtonClick() throws Exception {

        initialize();
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Hard);
        dl.createBoard(board);
        setBoardScene();

    }
}