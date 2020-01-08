
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.function.Predicate;

import Entities.Pokemon;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PokemonTableView extends TableView<Pokemon> {

	private ObservableList<Pokemon> masterData;
	private FilteredList<Pokemon> filteredData;
	SortedList<Pokemon> sortedData;

	public PokemonTableView(ArrayList<Pokemon> objectList) {
		addHeaderColumnsToTable(generateHeaderColumnsLinkedHashMap());

		// objectList as observable List
		this.masterData = FXCollections.observableArrayList(objectList);

		// wrap masterData in Filtered list to be able to change it through a new
		// Predicate
		this.filteredData = new FilteredList<>(this.masterData, pokemon -> true);

		// create sorted List and bind it to default sorting of TableView
		this.sortedData = new SortedList<>(this.filteredData);
		this.sortedData.comparatorProperty().bind(this.comparatorProperty());

		this.setItems(this.sortedData);
	}

	private LinkedHashMap<String, String> generateHeaderColumnsLinkedHashMap() {
		LinkedHashMap<String, String> headerColumns = new LinkedHashMap<>();

		headerColumns.put("Name", "name");
		headerColumns.put("Total", "totalValue");
		headerColumns.put("HP", "hpValue");
		headerColumns.put("Attack", "attackValue");
		headerColumns.put("Defense", "defenseValue");
		headerColumns.put("Spc. Attack", "specialAttackValue");
		headerColumns.put("Spc. Defense", "specialDefenseValue");
		headerColumns.put("Speed", "speed");
		headerColumns.put("Type1", "firstType");
		headerColumns.put("Type2", "secondType");

		return headerColumns;
	}

	private void addHeaderColumnsToTable(LinkedHashMap<String, String> headerColumns) {
		for (Entry<String, String> entry : headerColumns.entrySet()) {

			Object currentKey = entry.getKey();
			TableColumn<Pokemon, String> currentColumn = new TableColumn<>(currentKey.toString());

			Object currentValue = entry.getValue();
			currentColumn.setCellValueFactory(new PropertyValueFactory<>(currentValue.toString()));

			this.getColumns().add(currentColumn);
		}
	}

	public void setFilterPredicate(Predicate<Pokemon> filter, Observable... dependencies) {
		this.filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> filter, dependencies));
	}
}
