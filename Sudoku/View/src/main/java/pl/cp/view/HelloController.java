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

    @FXML
    protected void onEasyButtonClick() throws Exception {

        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Easy);
        dl.createBoard(board);
        Parent root = FXMLLoader.load(getClass().getResource("board-view.fxml"));
        Stage window = (Stage) easy.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));

    }

    @FXML
    protected void onMediumButtonClick() throws Exception {

        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Medium);
        dl.createBoard(board);
        Parent root = FXMLLoader.load(getClass().getResource("board-view.fxml"));
        Stage window = (Stage) medium.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));

    }

    @FXML
    protected void onHardButtonClick() throws Exception {

        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        DifficultyLevel dl = new DifficultyLevel(DifficultyLevel.Difficulty.Easy);
        dl.createBoard(board);
        Parent root = FXMLLoader.load(getClass().getResource("board-view.fxml"));
        Stage window = (Stage) hard.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));

    }
}