public abstract class Mammal extends Animal {
	protected String furColor;

	public Mammal(String name, int age, String furColor) {
		super(name, age);

		if (furColor == null || furColor.isBlank()) {
			throw new IllegalArgumentException("Fur color cannot be null or blank");
		}

		this.furColor = furColor;
	}

	public final String getFurColor() {
		return furColor;
	}
}
