package pl.cp.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public void initialize() {
        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
    }

    public void setBoardScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("board-view.fxml"));
        Stage window = (Stage) easy.getScene().getWindow();
        window.setScene(new Scene(root, 500, 700));
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
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Easy);
        dl.createBoard(board);
        setBoardScene();

    }
}