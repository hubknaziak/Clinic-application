package lab03_pop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Wizyta
{
	public boolean wykonana;
	public Lekarz lekarz;
	public Pacjent pacjent;
	public Gabinet gabinet;
	public Godziny dzien;
	public Godziny godzina;
	public String wynik;
	
	public void zapiszWynik(String dane, String wynik)
	{
		String danew[] = null;
		danew = dane.split(",");
		Scanner s = null;
		PrintWriter zapis1 = null;
		PrintWriter zapis2 = null;
		try
		{
			File plik = new File("Wizyty.txt");
			s = new Scanner(plik);
			zapis1 = new PrintWriter("Pomocniczy.txt");
			zapis2 = new PrintWriter(new FileWriter("Pomocniczy.txt",true));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Blad przy odczycie pliku");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		int licznik=0;
		while(s.hasNextLine())
		{
			String linia = s.nextLine();
			String tekst[] = null;
			tekst = linia.split(",");
			if(tekst[1].equals(danew[0]) && tekst[4].equals(danew[1]) && tekst[5].equals(danew[2]) && tekst[0].equals("false"))
			{
				tekst[0]="true";
				tekst[6]=wynik;
				if(licznik==0)
				{
					zapis1.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]);
				}
				else
				{
					zapis2.println();
					zapis2.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]);
				}
			}
			else
			{
				if(licznik==0)
				{
					zapis2.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]);
				}
				else
				{
					zapis2.println();
					zapis2.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]);
				}
				
			}
			licznik++;
		}
		zapis1.close();
		zapis2.close();
		
		PrintWriter zapis3 = null;
		PrintWriter zapis4 = null;
		Scanner s2 = null;
		try
		{
			File plik2 = new File("Pomocniczy.txt");
			s2 = new Scanner(plik2);
			zapis3 = new PrintWriter("Wizyty.txt");
			zapis4 = new PrintWriter(new FileWriter("Wizyty.txt",true));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Blad przy odczycie pliku");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		licznik=0;
		while(s2.hasNextLine())
		{
			String linia = s2.nextLine();
			String tekst[] = null;
			tekst = linia.split(",");
			if(licznik == 0)
			{
				zapis3.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]);
			}
			else
			{
				zapis4.println();
				zapis4.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]);
			}
			licznik++;
		}
		zapis3.close();
		zapis4.close();
	}
}
