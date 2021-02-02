package lab03_pop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;

public class Wyszukaj 
{
	public void lekarz(String spec)
	{
		Scanner s = null;
		try
		{
			File plik = new File("Lekarze.txt");
			s = new Scanner(plik);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Blad przy odczycie pliku");
		} 
		int licznik=0;
		while(s.hasNextLine())
		{
			String linia = s.nextLine();
			String tekst[] = null;
			tekst = linia.split(",");
			if(tekst[3].equals(spec))
			{
				System.out.println("Lekarz o numerze ID:"+tekst[0]+"  Imie:"+tekst[1]+"  Nazwisko:"+tekst[2]);
				licznik++;
			}
		}
		if(licznik==0)
		{
			System.out.println("Przychodnia nie posiada lekarzy o tej specjalizacji");
		}
		s.close();
		
	}
	public void wolnyTermin(String dane)
	{
		String danew[] = null;
		danew = dane.split(",");
		Scanner s1 = null;
		Scanner s2 = null;
		try
		{
			File plik1 = new File("Gabinety.txt");
			File plik2 = new File("Wizyty.txt");
			s1 = new Scanner(plik1);
			s2 = new Scanner(plik2);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Blad przy odczycie pliku");
		} 
		
		while(s1.hasNextLine())
		{
			String linia1 = s1.nextLine();
			String tekst[]= null;
			LocalDate data = null;
			LocalTime czas1 = null;
			LocalTime czas2 = null;
			LocalTime czas3 = null;
			DayOfWeek dzien1 = null;
			tekst = linia1.split(",");
			if(tekst[1].equals(danew[0]))
			{
				int licznik = 0;
				data = LocalDate.parse(danew[1]);
				dzien1 = data.getDayOfWeek();;
				czas1 = LocalTime.parse(danew[2]);
				czas2 = LocalTime.parse(tekst[6]);
				czas3 = LocalTime.parse(tekst[7]);
				int dod = Integer.parseInt(tekst[8]);
				LocalTime czask = czas1.plusMinutes(dod);
				if(czas1.isAfter(czas2) && czask.isBefore(czas3))
				{
					while(s2.hasNextLine())
					{
						String linia2 = s2.nextLine();
						String tekst2[]= null;
						tekst2 = linia2.split(",");
						if(danew[0].equals(tekst2[1]) && danew[1].equals(tekst2[4]) && danew[2].equals(tekst2[5]))
						{
							licznik++;
						}
					}
				}
				if(licznik>0)
				{
					System.out.println("Termin zostal juz zarezerwowany przez innego pacjenta");
				}
				else
				{
					System.out.println("Termin wizyty jest wolny");
				}
				
			}
		}
	}
	public void pacjent(String pesel)
	{
			Scanner s = null;
			try
			{
				File plik = new File("Pacjenci.txt");
				s = new Scanner(plik);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Blad przy odczycie pliku");
			}
			
			int licznik=0;
			while(s.hasNextLine())
			{
				String tekst[] = null;
				String linia = s.nextLine();
				tekst = linia.split(",");
				if(tekst[2].equals(pesel))
				{
					System.out.println("Imie pacjenta:"+tekst[0]+"  Nazwisko:"+tekst[1]+"  nr.PESEL:"+tekst[2]);
					licznik++;
				}
			}
			if(licznik==0)
			{
				System.out.println("Pacjent z podanym nr.PESEL nigdy nie byl na wizycie w tej przychodni");
			}
			s.close();	
	}
}
