import java.util.Random;
import java.util.Scanner;

class Auswertung {
				private int[] alter;

				private int freiePos;

				private Random random;

				private Scanner scanner;
				
				private boolean arrayFull = false;

				public Auswertung(int groesse) {
								scanner = new Scanner(System.in);
								freiePos = 0;

								if (groesse <= 0) {
												System.out.println("Größe ungültig, auf standard gesetzt");
												groesse = 10;
								}

								alter = new int[groesse];
				}
				
				public Auswertung(int groesse, int anzahl) {
								scanner = new Scanner(System.in);
								random = new Random();

								if (groesse <= 0) {
												System.out.println("Größe ungültig, auf standard gesetzt");
								}

								alter = new int[groesse];

								if (anzahl <= groesse) {
												for (int i = 0; i < anzahl; i++) {
																alter[i] = random.nextInt(0, 100);
												}
												freiePos = anzahl;
								}
				}

				public void anhaengen(int wert) {
								if (freiePos == alter.length) {
												System.err.println("Array voll kann nichts mehr einfügen");
												arrayFull = true;
								}
								else {
												if (wert < 0 || wert > 99) {
																System.err.println("Wert liegt nicht im gültigen bereich");
												}
												else {
																alter[freiePos] = wert;
																freiePos++;
												}
								
								}
				}

				public void einlesen(int anzahl) {
								if (anzahl > alter.length) {
												System.err.println("Anzahl zu hoch");
								}
								else {
												for (int i = 0; i < anzahl; i++) {
																System.out.println("Bitte geben Sie einen gültigen Wert zwischen 0 und 99 ein: ");
																anhaengen(scanner.nextInt());
												}
								}
				}

				public void printHashTags(int count) {
								for (int i = 0; i < count; i++) {
												System.out.print("#");
								}
				}

				public void ausgeben() {
								System.out.println("Feld: Wert");
								for (int i = 0; i < alter.length; i++) {
												System.out.print("[" + i + "]:  " + alter[i] + " ");
												printHashTags(alter[i]);
												System.out.println();
								}
				}

				public float durchschnitt() {
								int werteMenge = 0, werteAnzahl = freiePos - 1;

								for (int i = 0; i < werteAnzahl + 1; i++) {
												werteMenge += alter[i];
								}

								return (float)(werteMenge / werteAnzahl);
				}

				public void tauschen(int pos1, int pos2) {
								int tempPos = freiePos;
								if (arrayFull) {
												tempPos--;
								}
								if (pos1 >= alter.length || pos2 > alter.length) {
												System.err.println("Positonen größer als array länge");
								}
								else {
												if (alter[pos1] > tempPos || alter[pos2] > tempPos) {
																System.err.println("Ungültige Positionswerte");
												}
												else {
																int temp = alter[pos1];
																alter[pos1] = alter[pos2];
																alter[pos2] = temp;
												}
								
								}
				}

				public void sortieren() {
								int n = alter.length;
								boolean swapped;
								for (int i = 0; i < n - 1; i++) {
												swapped = false;
												for (int j = 0; j < n - i - 1; j++) {
																if (alter[j] > alter[j + 1]) {
																tauschen(j, j + 1);
																swapped = true;
																}
												}
												if (!swapped) {
																break;
												}
								}
				}

				public void loeschen(int pos) {
								if (pos >= alter.length) {
												System.err.println("Position ungültig");
								}
								else {
												if (pos != (freiePos - 1)) {
																for (int i = pos; i < freiePos - 1; i++) {
																				if (i == (freiePos - 2)) {
																								alter[i] = 0;
																				}
																				alter[i] = alter[i + 1];
																}
												}
												else {
																alter[pos] = 0;
												}
								}
				}

				public static void main(String[] args) {
								Auswertung auswertung = new Auswertung(10, 9);
								auswertung.ausgeben();
								auswertung.anhaengen(43);
								auswertung.anhaengen(100);
								auswertung.ausgeben();
								auswertung.einlesen(2);
								auswertung.tauschen(3, 6);
								auswertung.ausgeben();
								auswertung.tauschen(103, 4);
								System.out.println(auswertung.durchschnitt());
								auswertung.loeschen(4);
								auswertung.ausgeben();
				}
}
