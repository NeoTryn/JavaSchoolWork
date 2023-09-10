class Garage {
				private float hoehe;

				private Fahrzeug parkedVehicle;

				public Garage(float hoehe) {
								setHoehe(hoehe);
				}

				public void setHoehe(float hoehe) {
								if (hoehe < 1.5f || hoehe > 3.0f) {
												System.out.println("Höhe nicht im gültigen bereich, auf standard gesetzt");
												hoehe = 2.1f;
								}

								this.hoehe = hoehe;
				}

				public float getHoehe() {
								return this.hoehe;
				}

				public void printGarage() {
					if (this.parkedVehicle == null) {
						System.out.println("Kein Fahrzeug in der Garage");
					}
					else {
						System.out.println(this.parkedVehicle.getKennzeichen());
					}
				}

				public void einparken(Fahrzeug vehicleToPark) {
								if (this.parkedVehicle == null && vehicleToPark.getHoehe() < this.hoehe) {
												this.parkedVehicle = vehicleToPark;
								}
								else {
												System.err.println("Fahrzeug kann nicht in die Garage");
								}
				}

				public String ausparken() {
								String tempKennzeichen = " ";
								if (this.parkedVehicle == null) {
												System.out.println("Kein Fahrzeug in der Garage");
												return null;
								}
								else {
												tempKennzeichen = this.parkedVehicle.getKennzeichen();
												this.parkedVehicle = null;
								}
								return tempKennzeichen;
				}
}
