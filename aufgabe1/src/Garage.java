class Garage {
				private float hoehe;

				private Fahrzeug parkedVehicle;

				public Garage(float hoehe) {
								setHoehe(hoehe);
				}

				public void setHoehe(float hoehe) {
								if (hoehe < 1.5f || hoehe > 3.0f || hoehe = null) {
												System.out.println("Höhe nicht im gültigen bereich, auf standard gesetzt");
												hoehe = 2.1f;
								}

								this.hoehe = hoehe;
				}

				public float setHoehe() {
								return this.hoehe;
				}

				public void printGarage() {
								System.out.println(this.parkedVehicle.getKennzeichen());
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
								if (this.parkedVehicle == null) {
												System.out.println("Kein Fahrzeug in der Garage");
												return null;
								}
								else {
												this.parkedVehicle = null;
												return this.parkedVehicle.getKennzeichen();
								}
				}
}
