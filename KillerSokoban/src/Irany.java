
public enum Irany {
	FEL(0), JOBBRA(1), LE(2), BALRA(3);

	private int value;

	private Irany(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
