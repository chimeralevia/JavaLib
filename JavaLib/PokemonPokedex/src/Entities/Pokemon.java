package Entities;

public class Pokemon {
	private int id, totalValue, hpValue, attackValue, defenseValue, specialAttackValue, specialDefenseValue, speed;
	String name;
	PokemonType firstType, secondType;

	public Pokemon(int id, int totalValue, int hpValue, int attackValue, int defenseValue, int specialAttackValue,
			int specialDefenseValue, int speed, String name, PokemonType firstType, PokemonType secondType) {
		super();
		this.id = id;
		this.totalValue = totalValue;
		this.hpValue = hpValue;
		this.attackValue = attackValue;
		this.defenseValue = defenseValue;
		this.specialAttackValue = specialAttackValue;
		this.specialDefenseValue = specialDefenseValue;
		this.speed = speed;
		this.name = name;
		this.firstType = firstType;
		this.secondType = secondType;
	}

	public int getId() {
		return this.id;
	}

	public int getTotalValue() {
		return this.totalValue;
	}

	public int getHpValue() {
		return this.hpValue;
	}

	public int getAttackValue() {
		return this.attackValue;
	}

	public int getDefenseValue() {
		return this.defenseValue;
	}

	public int getSpecialAttackValue() {
		return this.specialAttackValue;
	}

	public int getSpecialDefenseValue() {
		return this.specialDefenseValue;
	}

	public int getSpeed() {
		return this.speed;
	}

	public String getName() {
		return this.name;
	}

	public PokemonType getFirstType() {
		return this.firstType;
	}

	public PokemonType getSecondType() {
		return this.secondType;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + this.id + ", totalValue=" + this.totalValue + ", hpValue=" + this.hpValue + ", attackValue="
				+ this.attackValue + ", defenseValue=" + this.defenseValue + ", specialAttackValue=" + this.specialAttackValue
				+ ", specialDefenseValue=" + this.specialDefenseValue + ", speed=" + this.speed + ", name=" + this.name
				+ ", firstType=" + this.firstType + ", secondType=" + this.secondType + "]";
	}
	

	
}
