import java.util.Random;

class Test {
				public static void main(String[] args) {
								Random random = new Random();

								int randomInt = random.nextInt(15, 30);

								float height = (float)randomInt / 10;

								Garage g1 = new Garage(height);
								Garage g2 = new Garage(1.6f);
								Fahrzeug f1 = new Fahrzeug("W 124 AB", 1.6f);

								g1.einparken(f1);

								g1.printGarage();

								g1.ausparken();

								g2.einparken(f1);

								g2.printGarage();
				}
}
