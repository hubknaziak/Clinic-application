package lab03_pop;

import java.util.List;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Gabinet extends Lekarz
{
	public List <Gabinet> Gabinet = new ArrayList<Gabinet>();
	public String nrGabinetu;
	public List <Lekarz> lekarze;
	
	Gabinet(String nrGabinetu, String id, String imie, String nazwisko, String specjalizacja, LocalDate data, LocalTime godzina,
			Duration interwal) 
	{
		super(id, imie, nazwisko, specjalizacja, data, godzina, interwal);
		// TODO Auto-generated constructor stub
		this.nrGabinetu=nrGabinetu;
		lekarze =  new ArrayList<Lekarz>();
	}
}
