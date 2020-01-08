import java.util.function.Predicate;

import Entities.Pokemon;
import Entities.PokemonType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GuiMain extends Application {
	private BorderPane mainPane = new BorderPane();
	private Scene scene = new Scene(this.mainPane);
	
	private Pokedex pokedex = new Pokedex();
	private PokemonTableView pokemonTableView = new PokemonTableView(this.pokedex.pokemonList);

	private HBox pokemonSearchBar = new HBox();
	private TextField nameSearchTextField = new TextField();
	private PokemonTypeComboBox firstTypePicker = new PokemonTypeComboBox();
	private PokemonTypeComboBox secondTypePicker = new PokemonTypeComboBox();
	private TextField valueSearchTextField = new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.mainPane.setCenter(this.pokemonTableView);
		this.mainPane.setTop(this.pokemonSearchBar);
		
		this.setFilters();
		
		primaryStage.setScene(this.scene);
		primaryStage.show();
	}

	private void setFilters() {
		Predicate<Pokemon> nameFilter = pokemon -> {
			return this.nameSearchTextField.getText().isEmpty()
					|| pokemon.getName().startsWith(this.nameSearchTextField.getText());
		};

		Predicate<Pokemon> typeFilter = pokemon -> {
			boolean shouldShowAllPokemon = this.firstTypePicker.getValue().equals(PokemonType.NONE);
			boolean isTypesFitting = pokemon.getFirstType().equals(this.firstTypePicker.getValue())
					&& pokemon.getSecondType().equals(this.secondTypePicker.getValue());
			return shouldShowAllPokemon || isTypesFitting;
		};

		Predicate<Pokemon> allFiltersCombined = nameFilter.and(typeFilter);

		this.pokemonTableView.setFilterPredicate(allFiltersCombined, this.nameSearchTextField.textProperty(),
				this.firstTypePicker.valueProperty(), this.secondTypePicker.valueProperty());

		this.pokemonSearchBar.getChildren().addAll(this.nameSearchTextField, this.firstTypePicker,
				this.secondTypePicker, this.valueSearchTextField);
	}

}
