import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
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

	private ObservableList<Person> masterData = FXCollections.observableArrayList();
	public PersonTableController() {
		masterData.add(new Person(1,"Ганс", "Хеинз","15:24","15.02.2016","01:25:00"));
		masterData.add(new Person(2,"Рич", "Мюллер","15:24","14.02.2016","01:25:00"));
		masterData.add(new Person(3,"Ганс", "Курт","15:24","13.02.2016","01:04:24"));
		masterData.add(new Person(4,"Корнелия", "Мейер","15:24","12.02.2016","00:01:25"));
		masterData.add(new Person(5,"Вернер", "Мейер","15:24","06.02.2014","10:23:24"));
		masterData.add(new Person(6,"Лидия", "Кант","15:24","10.02.2016","05:10:23"));
		masterData.add(new Person(7,"Анна", "Лучший","15:24","10.02.2016","00:00:34"));
		masterData.add(new Person(8,"Стефан", "Мейер","15:24","10.02.2015","00:00:23"));
		masterData.add(new Person(9,"Мартин", "Мюллер","15:24","10.02.2016","00:00:21"));
	}
	private void initRecord() throws FileNotFoundException {
		Scanner in = new Scanner(new File("files/records.txt"));
		String s;
		int k = 9;
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