package cinema.controllers;

import cinema.model.Movie;
import cinema.presenter.CinemaProjectPresenter;

import hibernateUtil.HibernateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class CinemaMainWindowController implements Initializable {

    CinemaProjectPresenter presenter = new CinemaProjectPresenter(this);
    Movie movie;
    ObservableList observableListOfMovies;

    @FXML
    private TableView<Movie> moviesTableView;
    @FXML
    private TableColumn<Movie, String> titleColumn;
    @FXML
    private TableColumn<Movie, String> directorColumn;
    @FXML
    private TableColumn<Movie, String> genreColumn;
    @FXML
    private TableColumn<Movie, LocalDate> prodDateColumn;

    @FXML
    private Button addMovieButton;
    @FXML
    private Button deleteMovieButton;
    @FXML
    private Label warningLabel;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField directorTextField;
    @FXML
    private TextField genreTextField;
    @FXML
    private DatePicker productDatePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        movie = new Movie();
        observableListOfMovies = FXCollections.observableArrayList(presenter.showMovieList());
        moviesTableView.setItems(observableListOfMovies);
        titleColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getMovieTitle()));
        directorColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMovieDirector()));
        genreColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMovieGenre()));
        prodDateColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getMovieProductionDate()));
    }


    public void addMovieToList(ActionEvent actionEvent) {
        if (titleTextField.getText() != null
                && directorTextField.getText() != null
                && genreTextField.getText() != null
                && productDatePicker.getValue() != null) {
            warningLabel.setText("");
            Movie movieToAdd = new Movie();
            setMovieAttributesFromInputFields(movieToAdd);

            presenter.addMovieToDatabase(movieToAdd);
            clearInputFields();
            observableListOfMovies = FXCollections.observableArrayList(presenter.showMovieList());
            moviesTableView.setItems(observableListOfMovies);
        } else {
            warningLabel.setTextFill(Color.RED);
            warningLabel.setText("Wypełnij puste pola!");
        }
    }


    public void deleteMovieFromList(ActionEvent actionEvent) {
        Integer selectedMovieIndex = moviesTableView.selectionModelProperty().getValue().getSelectedItem().getMovieId();
        Movie movieToDelete = moviesTableView.selectionModelProperty().getValue().getSelectedItem();
        if (selectedMovieIndex >= 0) {
            Integer selectedIndexFromTable = moviesTableView.getSelectionModel().getSelectedIndex();
            moviesTableView.getItems().remove(selectedIndexFromTable);
            observableListOfMovies.clear();
            presenter.removeMovieFromDatabase(movieToDelete, selectedMovieIndex);

            observableListOfMovies = FXCollections.observableArrayList(presenter.showMovieList());
            moviesTableView.getItems().clear();
            moviesTableView.setItems(observableListOfMovies);
        }
    }

    public void exitFromApp(ActionEvent actionEvent) {
        HibernateUtil.closeSession();
        System.exit(0);
    }


    private void clearInputFields() {
        titleTextField.clear();
        directorTextField.clear();
        genreTextField.clear();
        productDatePicker.setValue(null);
        observableListOfMovies.clear();
    }

    private void setMovieAttributesFromInputFields(Movie movieToAdd) {
        movieToAdd.setMovieTitle(titleTextField.getText());
        movieToAdd.setMovieDirector(directorTextField.getText());
        movieToAdd.setMovieGenre(genreTextField.getText());
        movieToAdd.setMovieProductionDate(productDatePicker.getValue());
    }
}
