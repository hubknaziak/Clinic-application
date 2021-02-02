package lab03_pop;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

public class Lekarz extends Godziny
{

	public List <Lekarz> Lekarz = new ArrayList<Lekarz>();
	public String id;
	public String imie;
	public String nazwisko;
	public String specjalizacja;
	
	Lekarz(String id, String imie, String nazwisko, String specjalizacja, LocalDate data, LocalTime godzina, Duration interwal)
	{
		this.id=id;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.specjalizacja=specjalizacja;
		this.data=data;
		this.godzina=godzina;
		this.interwal=interwal;
	}
}
