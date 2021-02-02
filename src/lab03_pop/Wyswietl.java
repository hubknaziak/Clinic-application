package lab03_pop;

import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Wyswietl
{
	public boolean haslo()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Podaj haslo administratora systemu");
		String haslo = s.nextLine();
		if(haslo.equals("admin"))
		{
			System.out.println("Haslo prawidlowe");
			return true;
		}
		else
		{
			System.out.println("Haslo nieprawidlowe");
			return false;	
		}
	}
	public String daneLekarza()
	{
		Scanner s = new Scanner (System.in);
		String dane = null;
		System.out.println("Podaj kolejno ID lekarza imie, nazwisko i specjalizacje, oddzielajac je przecinkami");
		dane = s.nextLine();
		return dane;
	}
	public String edycjaGodziny()
	{
		Scanner s = new Scanner (System.in);
		System.out.println("Podaj kolejno ID lekarza, nowy gabinet, dzien przyjmowania, godzine poczatkowa, koncowa, oraz interwal");
		String dane = s.nextLine();
		return dane;
	}
	public int edycjaLekarz()
	{
		Scanner s = new Scanner (System.in);
		System.out.println("1. Dodaj lekarza");
		System.out.println("2. Usun lekarza");
		int wybor = s.nextInt();
		if(wybor==1)
		{
			return 1;
		}
		if(wybor==2)
		{
			return 2;
		}
		else
		{
			System.out.println("Nieobslugiwany znak");
			return -1;
		}
		
	}
	public String specjalizacja()
	{
		System.out.println("Wprowadz specjalizacje wyszukiwanego lekarza");
		Scanner s = new Scanner(System.in);
		String spec = s.nextLine();
		s.close();
		return spec;
	}
	public String pesel()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Wprowadz PESEL szukanego pacjenta");
		String pesel = s.nextLine();
		s.close();
		return pesel;
	}
	public String danePacjenta()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Wprowadz kolejno imie, nazwisko, oraz PESEL pacjenta, oddzielajac je znakiem \",\"");
		String linia = s.nextLine();
		return linia;
	}
	public String daneWizyty()
	{
		Scanner s = new Scanner(System.in);
		String dane;
		System.out.println("Wprowadz kolejno dane wizyty: ID lekarza, date wizyty, godzine wizyty, oddzielajac je znakiem \",\"");
		dane=s.nextLine();
		return dane;
	}
	public String wynik()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Wprowadz wynik przeprowadzonej wizyty");
		String wynik = s.nextLine();
		return wynik;
	}
	
	public void interfejs()
	{
		System.out.println("Witaj! \nProgram ten obsluguje rejestracje pacjentow w przychodni");
		System.out.println("Wybierz jedna z ponizszych czynnosc, wprowadzajac do konsoli numer danej instrukcji:");
		
		
			Scanner s = new Scanner (System.in);
			int znak = 0;
			System.out.println("1. Wyszukaj lekarza specjaliste");
			System.out.println("2. Wyszukaj termin u danego lekarza");
			System.out.println("3. Wyszukaj pacjenta");
			System.out.println("4. Zarejestruj pacjenta");
			System.out.println("5. Wyrejestruj pacjenta");
			System.out.println("6. Zapisz wynik wizyty");
			System.out.println("7. Edytuj liste lekarzy (tylko administrator) ");
			System.out.println("8. Edytuj listy godzin przyjec z gabinetami (tylko administrator)");
			System.out.println("0. Wyjdz z programu");
			
			znak=s.nextInt();
			if(znak==1) 
			{
				Wyszukaj w1 = new Wyszukaj();
				w1.lekarz(specjalizacja());
			}
			else if(znak==2)
			{
				Wyszukaj w1 = new Wyszukaj();
				w1.wolnyTermin(daneWizyty());
			}
			else if(znak==3)
			{
				Wyszukaj w1 = new Wyszukaj();
				w1.pacjent(pesel());
			}
			else if(znak==4)
			{
				Rejestracja r1 = new Rejestracja();
				r1.zarejestruj(danePacjenta(),daneWizyty());
			}
			else if(znak==5)
			{
				Rejestracja r1 = new Rejestracja();
				r1.wyrejestruj(danePacjenta(),daneWizyty());
			}
			else if(znak==6)
			{
				Wizyta w1 = new Wizyta();
				w1.zapiszWynik(daneWizyty(), wynik());
			}
			else if(znak==7)
			{
				Edycja e1 = new Edycja();
				int wartosc =edycjaLekarz();
				if(wartosc==1) 
				{
					e1.dodajLekarza(haslo(),daneLekarza());
				}
				if(wartosc==2)
				{
					e1.usunLekarza(haslo(),daneLekarza());
				}
				
			}
			else if(znak==8)
			{
				Edycja e1 = new Edycja();
				e1.godzinyPrzyjec(haslo(),edycjaGodziny());
			}
			else
			{
				return ;
			}
	}
}
