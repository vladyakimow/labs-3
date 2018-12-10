import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonTableController {

    @FXML
    private TextField filterField;
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, Integer> idColumn;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> secondNameColumn;
    @FXML
    private TableColumn<Person, String> timeColumn;

    @FXML
    private TableColumn<Person, String> dateColumn;

    @FXML
    private TableColumn<Person, String> durationColumn;

    @FXML
    private ChoiceBox choiceBox;

    private ObservableList<Person> masterData = FXCollections.observableArrayList();

    private void initRecord() throws FileNotFoundException {
        Scanner in = new Scanner(new File("files/records.txt"));
        String s;
        int k = 0;
        while (in.hasNextLine()) {
            k++;
            s = in.nextLine();
            String w[] = s.split(" ");
            for (int i = 0; i < w.length - 4; i++)
                masterData.add(new Person(k, w[i], w[i + 1], w[i + 2], w[i + 3], (w[i + 4])));
        }
        in.close();
    }

    @FXML
    public void handleChoice() {
        
    }

    @FXML
    private void initialize() throws FileNotFoundException {
        initRecord();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        secondNameColumn.setCellValueFactory(cellData -> cellData.getValue().secondNameProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        durationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty());
        FilteredList<Person> filteredData = new FilteredList<>(masterData, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getSecondName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getTime().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getDuration().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }

                return false;
            });
        });
        SortedList<Person> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(personTable.comparatorProperty());
        personTable.setItems(sortedData);
    }
}
