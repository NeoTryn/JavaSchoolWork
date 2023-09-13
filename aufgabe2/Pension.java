class Pension {
				private Urlaub[] buchungen;
				private int freiePos = 0;

				public Pension(int maxBuchungen) {
								buchungen = new Urlaub[maxBuchungen];
				}

				public boolean urlaubBuchen(Urlaub u) {
								if (freiePos < buchungen.length - 1) {
												buchungen[freiePos] = u;
								}
				}

				public int loescheUrlaub(String jahr) {
								int jahrAbInt = 0;
								try {
												jahrAbInt = Integer.parseInt(jahr);
								}
								catch (NumberFormatException e) {
												System.err.println("Jahr is not a number");
								}

								for (int i = 0; i < buchungen.length; i++) {
												String[] splits = buchungen[i].getAb().split("/");
												int jahrInt = 0;
												try {
																jahrInt = Integer.parseInt(splits[2]);
												}
												catch (NumberFormatException e) {

												}
								}
				}
}
