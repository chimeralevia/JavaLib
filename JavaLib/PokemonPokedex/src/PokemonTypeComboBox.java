import Entities.PokemonType;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class PokemonTypeComboBox extends ComboBox<PokemonType>{

	
	public PokemonTypeComboBox() {
		this.setItems(FXCollections.observableArrayList(PokemonType.values()));
		this.getSelectionModel().selectFirst();
		this.setPrefWidth(200);
	}
}
