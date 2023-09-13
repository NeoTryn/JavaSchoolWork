class Urlaub {
				private String nameGast, ab;
				private int dauerInTagen;
				private boolean stammgast;

				public static void main(String[] args) {
								Urlaub urlaub = new Urlaub("ZockerDexYt", "15/03/2023", 0, false);
								System.out.println(urlaub.toString());
				} 

				public Urlaub(String nameGast, String ab, int dauerInTagen, boolean stammgast) {
							setNameGast(nameGast);	
							setAb(ab);	
							setDauerInTagen(dauerInTagen);
							setStammGast(stammgast);
				}

				@Override
				public String toString() {
								String result = nameGast + " - ";
								String[] splits = ab.split("/");
								
								String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
								
								int month = 0;

								for (String str : splits) {
												System.out.println(str);
								}

								try {
												month = Integer.parseInt(splits[1]);
								}
								catch (NumberFormatException e) {
												System.err.println("Ab not a number");
								}
								
								result += "kommt am " + splits[0] + "." + months[month - 1] + "." + splits[2]; 

								result += " - bleibt " + dauerInTagen + " Tage - ";

								if (stammgast) {
												result += "ist Stammgast";
								}
								else {
												result += "ist NICHT Stammgast";
								}

								return result;
				}

				public void setNameGast(String nameGast) {
								this.nameGast = nameGast;
				}

				public String getNameGast() {
								return nameGast;
				}

				public void setAb(String ab) {
								if (!(ab.length() == 10)) {
												System.err.println("String hat nicht vorgegebenes Format");
								} 
								else {
												String[] splits = ab.split("/");
												if (isNumeric(splits[0]) && isNumeric(splits[1]) && isNumeric(splits[2])) {
																/* Unnecessary logic that knon doesn't need
																if (splits[1] <= ""12) {
																				if (splits[1] % 2 == 0) {
																								if (splits[1] == 2) {
																												if (splits[0] == 28) {
																																this.ab = ab;
																												}
																								}
																								else if (splits[1] == 2 && splits[2] % 4 == 0) {
																												if (splits[0] == 29) {
																																this.ab = ab;
																												}
																												else {
																																System.err.println("Days are not equal to 29 in a leap year");
																												}
																								}
																								else {
																												if (splits[0] <= 30) {
																																this.ab = ab;
																												}
																												else {
																																System.err.println("Days are not equal to 30 in even month");
																												}
																								}
																				}
																				else {
																								if (splits[0] <= 31) {
																												this.ab = ab;
																								}
																								else {
																												System.err.println("Days are not equal to 31 in ");
																								}
																				}
																}*/
																this.ab = ab;

												}
								}
				}

				public String getAb() {
								return ab;
				}

				public void setDauerInTagen(int dauerInTagen) {
								this.dauerInTagen = dauerInTagen;
				}

				public int getDauerInTagen() {
								return dauerInTagen;
				}

				public void setStammGast(boolean stammgast) {
								this.stammgast = stammgast;
				}

				public boolean getStammGast() {
								return stammgast;
				}

				public static boolean isNumeric(String strNum) {
								if (strNum == null) {
												return false;
								}

								try {
												double d = Double.parseDouble(strNum);
								}	catch (NumberFormatException e) {
												return false;
								}							
								return true;
				}
}
