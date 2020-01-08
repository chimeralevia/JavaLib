import java.util.ArrayList;
import java.util.List;

import Entities.Pokemon;
import Entities.PokemonType;
import Util.CsvReader;

public class Pokedex {
	ArrayList<Pokemon> pokemonList = new ArrayList<>();



	public Pokedex() {
		loadPokemonFromCsv();
	}

	private void loadPokemonFromCsv() {
		CsvReader csvReader = new CsvReader();
		List<String[]> csvData = csvReader.loadCsvToList("src\\Util\\pokedex.csv", ",");

		csvData.stream().forEach(cell -> {

			int id = Integer.parseInt(cell[0]);
			String name = cell[1];
			PokemonType firstType = PokemonType.valueOf(cell[2].toUpperCase());
			PokemonType secondType = cell[3].equals("")?PokemonType.NONE:PokemonType.valueOf(cell[3].toUpperCase());
			int totalValue = Integer.parseInt(cell[4]);
			int hpValue = Integer.parseInt(cell[5]);
			int attackValue = Integer.parseInt(cell[6]);
			int defenseValue = Integer.parseInt(cell[7]);
			int specialAttackValue = Integer.parseInt(cell[8]);
			int specialDefenseValue = Integer.parseInt(cell[9]);
			int speed = Integer.parseInt(cell[10]);

			Pokemon pokemon = new Pokemon(id, totalValue, hpValue, attackValue, defenseValue, specialAttackValue,
					specialDefenseValue, speed, name, firstType, secondType);

			this.pokemonList.add(pokemon);
		});

	}
	
	public ArrayList<Pokemon> getPokemonList() {
		return this.pokemonList;
	}
}
