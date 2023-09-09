class Fahrzeug {

				String kennzeichen;

				float hoehe;

				public Fahrzeug(String kennzeichen, float hoehe) {
								setKennzeichen(kennzeichen);
								setHoehe(hoehe);
				}

				public Fahrzeug() {
								setKennzeichen("KnonCool");
								setHoehe(2.0f);
				}

				public void setKennzeichen(String kennzeichen) {
								this.kennzeichen = kennzeichen;

								if (this.kennzeichen != null) {
												if (!(this.kennzeichen.length <= 5) || !(this.kennzeichen.length >= 8)){
																kennzeichen = null;
																System.out.println("Kennzeichenlänge nicht im erlaubten bereich, auf null gesetzt");
												}
								}
				}

				public String getKennzeichen() {
								return this.kennzeichen;
				}

				public void setHoehe(float hoehe) {
								if (hoehe > 4.0f || hoehe < 1.6f || hoehe == null) {
												hoehe = 1.6f;
												System.out.println("Hoehe nicht im erlaubten bereich, auf standard gesetzt")
								}
								this.hoehe = hoehe;
				}


}
