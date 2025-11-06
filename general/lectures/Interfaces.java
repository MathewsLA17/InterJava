public class Interfaces {
	public static void main(String[] args) {
		Platypus bill = new Platypus("Bill", 4);

		// All of these are valid due to polymorphism
		Animal animal = bill;
		Mammal mammal = bill;
		Monotreme monotreme = bill;
		EggLayer eggLayer = bill;

		bill.layEgg();
		eggLayer.layEgg();

		EggLayer polly = new Bird("Polly", 2);
		polly.layEgg();

		EggLayer[] eggLayers = { bill, polly };
		for (int i = 0; i < eggLayers.length; i++) {
			eggLayers[i].layEgg();
		}

		Animal[] animals = {
				new Dog("Koro", 3, "White"),
				new Cat("Mona", 4, "Black"),
				new Bird("Lufel", 1),
				new Platypus("Perry", 7),
		};
		for (int i = 0; i < animals.length; i++) {
			animals[i].speak();
			if (animals[i] instanceof EggLayer) {
				EggLayer e = (EggLayer) animals[i];
				e.layEgg();
			}
		}
	}
}
