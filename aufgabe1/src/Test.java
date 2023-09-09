import java.util.Random;

class Test {
				public static void main(String[] args) {
								Random random = new Random();

								Garage g1 = new Garage(random.nextInt(1.5f, 3.0f));
								Garage g2 = new Garage(1.6f);
								Fahrzeug f1 = new Fahrzeug("W 124 AB", 1.6f);

								g1.einparken(f1);

								g1.ausparken();

								g2.einparken(f1);
				}
}
