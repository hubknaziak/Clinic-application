package lab03_pop;

import java.util.List;
import java.util.ArrayList;

public class Pacjent 
{
	public List <Pacjent> Pacjent = new ArrayList<Pacjent>();
	public String imie;
	public String nazwisko;
	public String nrPesel;
	
	Pacjent(String imie, String nazwisko, String nrPesel)
	{
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.nrPesel=nrPesel;
	}
}
