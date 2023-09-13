class Pension {
				private Urlaub[] buchungen;
				private int freiePos = 0;

				public Pension(int maxBuchungen) {
								buchungen = new Urlaub[maxBuchungen];
				}

				public static void main(String[] args) {
								Pension p1 = new Pension(5);
								Urlaub u1 = new Urlaub("Manfred Knon", "31/06/2024", 7, true);
								Urlaub u2 = new Urlaub("Volker Hofbauer", "30/12/2022", 10, false);
								Urlaub u3 = new Urlaub("Julia Stanek-Schleifer", "12/07/2023", 31, false);

								if (p1.urlaubBuchen(u1)) {
												System.out.println("Urlaub buchen works");
								}
								else {
												System.err.println("Urlaub buchen does not work");
								}

								p1.ausgabeUrlaube();

								p1.urlaubBuchen(u2);
								p1.urlaubBuchen(u3);

								p1.ausgabeUrlaube();

								p1.loescheUrlaub("2024");

								p1.ausgabeUrlaube();

								p1.bestGast();

								System.out.println(p1.einnahmen());

								p1.ausgabeUrlaube(11, true);

								p1.updateStammgaeste();

								p1.ausgabeUrlaube();
				}

				public boolean urlaubBuchen(Urlaub u) {
								if (freiePos < buchungen.length - 1) {
												buchungen[freiePos] = u;
												freiePos++;
												return true;
								}
								return false;
				}

				public int loescheUrlaub(String jahr) {
								int jahrAbInt = 0;
								int result = 0;
								boolean isShifted = false;
								try {
												jahrAbInt = Integer.parseInt(jahr);
								}
								catch (NumberFormatException e) {
												System.err.println("Jahr is not a number");
								}

								for (int i = 0; i < buchungen.length; i++) {
												if (!isShifted && i < buchungen.length - 1) {
																String[] splits = buchungen[i].getAb().split("/");
																int jahrInt = 0;
																try {
																				jahrInt = Integer.parseInt(splits[2]);
																}
																catch (NumberFormatException e) {
																				System.err.println("Internal Error: AB not a number");
																}

																if (jahrInt >= jahrAbInt) {
																				result += buchungen[i].getDauerInTagen();
																				buchungen[i] = null;
																				freiePos--;
																				shiftVacationLeft(i);
																				isShifted = true;
																}
												}
								}

								return result;
				}

				public int urlaubsTageVon(String gast) {
								int result = 0;
								for (Urlaub u : buchungen) {
												if (u != null) {
																if (u.getNameGast().equals(gast)) {
																				result += u.getDauerInTagen();	
																}
												
												}
								}
								return result;
				}

				public void ausgabeUrlaube() { 
								for (Urlaub u : buchungen) {
												if (u != null) {
																System.out.println(u.toString());
												}
								}
				}

				public void ausgabeUrlaube(int tage, boolean laenger) {
								for (Urlaub u : buchungen) {
												if (u != null) {
																if (laenger && tage <= u.getDauerInTagen()) {
																				System.out.println(u.toString());
																}
																else if(!laenger && tage > u.getDauerInTagen()) {
																				System.out.println(u.toString());
																}
												}
								}
				}

				public float einnahmen() {
								float einnahmen = 0.0f;

								for (Urlaub u : buchungen) {
												if (u != null) {
																if (u.getStammGast()) {
																				einnahmen += 26.0f;
																}	
																else {
																				einnahmen += 30.0f;
																}
												
												}
								}

								return einnahmen;
				}

				public void bestGast() {
								int highestDayz = 0;
								String nameGuestWithHighestDayz = " ";

								for (Urlaub u : buchungen) {
												if (u != null) {
																if (urlaubsTageVon(u.getNameGast()) > highestDayz) {
																				highestDayz = urlaubsTageVon(u.getNameGast());
																				nameGuestWithHighestDayz = u.getNameGast();
																}
												
												}
								}

								System.out.println(nameGuestWithHighestDayz);
				}

				public void updateStammgaeste() {
								for (int i = 0; i < buchungen.length; i++) {
												if (buchungen[i] != null) {
																if (urlaubsTageVon(buchungen[i].getNameGast()) > 30) {
																				buchungen[i].setStammGast(true);
																}
												}
								}
				}

				private void shiftVacationLeft(int vacationIndex) {
								for (int i = vacationIndex; i < buchungen.length - 1; i++) {
												buchungen[i] = buchungen[i + 1];
								}
				}
}
