package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonTableController {

    private ObservableList<Person> masterData = FXCollections.observableArrayList();

    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, Integer> idColumn;

    @FXML
    private TableColumn<Person, String> toColumn;

    @FXML
    private TableColumn<Person, String> fromColumn;

    @FXML
    private TableColumn<Person, String> dateColumn;

    @FXML
    private TableColumn<Person, String> timeColumn;

    @FXML
    private TableColumn<Person, Integer> durationColumn;

    @FXML
    private TableColumn<Person, Integer> typeColumn;

    @FXML
    private void initialize() throws FileNotFoundException {
        initRecord();

        ChangeListener<String> changeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                personTable.getItems().clear();

                Scanner in = null;
                try {
                    in = new Scanner(new File("records.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                int i = 0;
                while (in.hasNextLine()) {
                    String s = in.nextLine();
                    String w[] = s.split(" ");

                    if (newValue.equals("Все") || w[5].equals(newValue)) {
                        masterData.add(new Person(i + 1, w[0], w[1], w[2], w[3], w[4], w[5]));
                        i++;
                    }
                }
                in.close();

            }
        };

        choiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        toColumn.setCellValueFactory(new PropertyValueFactory<>("To"));
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("From"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        personTable.setItems(masterData);
    }

    @FXML
    private ChoiceBox choiceBox;

    private void initRecord() throws FileNotFoundException {
        Scanner in = new Scanner(new File("records.txt"));

        int i = 0;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String w[] = s.split(" ");

            masterData.add(new Person(i + 1, w[0], w[1], w[2], w[3], w[4], w[5]));
            i++;
        }
        in.close();
    }

    @FXML
    public void handleChoice() {
        //здесь реализуй поиск
    }
}
