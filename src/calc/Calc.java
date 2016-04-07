package calc;

public class Calc {
	private StringBuilder liczba1Str = new StringBuilder(); 
	private StringBuilder liczba2Str = new StringBuilder();
	private boolean drugaLiczba = false;
	private boolean newCalc = false;
	private boolean dotSet = false;
	private boolean error = false;
	
	private String resultText = "0";
	private String choosenParam ="";

	private double liczba1;
	private double liczba2;
	private double wynik;
		
	public String getResultText(){
		return resultText;
	}
	
	public void setResultText(String resultText){
		this.resultText = resultText;
	}
	
	public boolean getError(){
		return error;
	}
	
	//========================BUTTON PARAM========================================
	public void setBtnParam(String s){
		//Gdy wcisnelismy przycisk odpowiadajacy za Parametr dzialania
		if (liczba1Str.length()!=0){
			drugaLiczba = true; //ustawienie zmiennej boolean, ktora odpowiada za wpisanie drugiej liczby
			choosenParam = s;
			dotSet = false;
		}
		
		else if (!drugaLiczba&&(liczba1Str.length()==0)){
			liczba1Str.append(resultText);
			drugaLiczba = true; //ustawienie zmiennej boolean, ktora odpowiada za wpisanie drugiej liczby
			choosenParam = s;
			dotSet = false;
		}
		newCalc();
	}
	
	//======================BUTTON RESULT==========================================
	public void setBtnResult(String s){
		//OBLICZENIA WYNIKOWE
		if ((s.contains("=")&&liczba1Str.length()!=0&&liczba2Str.length()!=0)){
			drugaLiczba = false;
			liczba1 = Double.valueOf(liczba1Str.toString());
			liczba2 = Double.valueOf(liczba2Str.toString());
			
			if (choosenParam.equals("+")){
				wynik = liczba1 + liczba2;
				resultText = String.valueOf(wynik);
				newCalc = true;
			}
			
			else if (choosenParam.equals("-")){
				wynik = liczba1 - liczba2;
				resultText = String.valueOf(wynik);
				newCalc = true;
			}
			else if (choosenParam.equals("/")){
				wynik = liczba1 / liczba2;
				resultText = String.valueOf(wynik);
				newCalc = true;
			}
			else if (choosenParam.equals("*")){
				wynik = liczba1 * liczba2;
				resultText = String.valueOf(wynik);
				newCalc = true;
			}			
			checkError();
			newCalc();
		}		
	}


	//================WYBOR BTN================================================================
	public void setBtn(String s){
		if (s.contains("C")){
			error = false;
			newCalc = true;
			drugaLiczba=false;
			resultText = "";
		}
		//Sprawdzenie czy wpisujemy pierwsza liczbe
		if (!error){
			if (!drugaLiczba){
				if (s.matches("\\d+")){
					liczba1Str.append(s);
					resultText = liczba1Str.toString();
				}
				
				else if (s.contains("+/-")){
					if ((liczba1Str.length()==0)){
						liczba1Str.append(resultText);
					}

					if(liczba1Str.charAt(0)=='-'){
						liczba1Str.deleteCharAt(0);
					}
					else{
						liczba1Str.insert(0, '-');
					}
					resultText = liczba1Str.toString();
				}
				
				else if (s.contains(".")&&!dotSet){
					liczba1Str.append(".");
					dotSet = true;
					resultText = liczba1Str.toString();
				}
				
				else if (s.contains("sqrt")){
					if (!drugaLiczba&&(liczba1Str.length()==0)){
						liczba1Str.append(resultText);
						double liczbaSqrt = Math.sqrt(Double.valueOf(liczba1Str.toString()));
						liczba1Str.setLength(0);
						liczba1Str.append(liczbaSqrt);
						resultText = liczba1Str.toString();
						checkError();
					}
					else{
						double liczbaSqrt = Math.sqrt(Double.valueOf(liczba1Str.toString()));
						liczba1Str.setLength(0);
						liczba1Str.append(liczbaSqrt);
						resultText = liczba1Str.toString();
						checkError();

					}
				}
				
				else if (s.contains("%")){
					liczba1Str.setLength(0);
					resultText = "";
				}
			}
			
			else{
				if (s.matches("\\d+")){
					liczba2Str.append(s);
					System.out.println("L2: "+liczba2Str.toString());
					resultText = liczba2Str.toString();
				}
				
				else if (s.contains(".")&&!dotSet){
					liczba2Str.append(".");
					dotSet = true;
					resultText = liczba2Str.toString();
				}
				
				else if (s.contains("%")){
					double liczbaPom = (Double.valueOf(liczba1Str.toString())*Double.valueOf(liczba2Str.toString()))/100;
					liczba2Str.setLength(0);
					liczba2Str.append(liczbaPom);
					resultText = liczba2Str.toString();
				}
				
				else if (s.contains("sqrt")){
					double liczbaSqrt = Math.sqrt(Double.valueOf(liczba2Str.toString()));
					liczba2Str.setLength(0);
					liczba2Str.append(liczbaSqrt);
					resultText = liczba2Str.toString();
					checkError();

				}
				else if (s.contains("+/-")&&liczba2Str.length()!=0){
					if(liczba2Str.charAt(0)=='-'){
						liczba2Str.deleteCharAt(0);
					}
					else{
						liczba2Str.insert(0, '-');
					}
					resultText = liczba2Str.toString();
				}
			}	
			newCalc();
		}
	}
	
	
	private void newCalc(){
		//zerowanie zmiennych liczbowych po wcisnieciu result
		if (newCalc == true){
			liczba1Str.setLength(0);
			liczba2Str.setLength(0);
			drugaLiczba = false;
			newCalc = false;
			dotSet = false;			
	}
	}
		
	private void checkError() {
		if (resultText.equals("Infinity")||resultText.equals("NaN")){
			error = true;
			resultText = "Error";
		}
		
	}

}
