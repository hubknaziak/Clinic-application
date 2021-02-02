package lab03_pop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class Rejestracja 
{
	public void zarejestruj(String danep, String danew)
	{
		String tekstp[] = null;
		tekstp = danep.split(",");
		String tekstw[] = null;
		tekstw = danew.split(",");
		String nrGab = null;
		Scanner s1 = null;
		Scanner s2 = null;
		Scanner s3 = null;
		PrintWriter zapis1 = null;
		PrintWriter zapis2 = null;
		LocalDate data = null;
		LocalTime czas1 = null;
		LocalTime czas2 = null;
		LocalTime czas3 = null;
		DayOfWeek dzien1 = null;
		String wynik = "null";
		try
		{
			 File plik1 = new File("Pacjenci.txt");
			 File plik2 = new File("Wizyty.txt");
			 File plik3 = new File("Gabinety.txt");
			 s1 = new Scanner(plik1);
			 s2 = new Scanner(plik2);
			 s3 = new Scanner(plik3);
			 zapis1 = new PrintWriter(new FileWriter("Pacjenci.txt",true));
			 zapis2 = new PrintWriter(new FileWriter("Wizyty.txt",true));
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
		while(s1.hasNextLine())
		{
			String tekst[] = null;
			String linia = s1.nextLine();
			tekst = linia.split(",");
			if(tekstp[2].equals(tekst[2]))
			{
				licznik++;
			}
		}
		if(licznik==0)
		{
			zapis1.println();
			zapis1.print(danep);
		}
		zapis1.close();
		
		licznik=0;
		while(s2.hasNextLine())
		{
			String tekst[] = null;
			String linia = s2.nextLine();
			tekst = linia.split(",");
			if(tekstw[1].equals(tekst[4]) && tekstw[2].equals(tekst[5]))
			{
				licznik++;
			}
		}
		
		while(s3.hasNextLine())
		{
			String tekst[] = null;
			String linia = s3.nextLine();
			tekst = linia.split(",");
			data = LocalDate.parse(tekstw[1]);
			dzien1 = data.getDayOfWeek();;
			czas1 = LocalTime.parse(tekstw[2]);
			czas2 = LocalTime.parse(tekst[6]);
			czas3 = LocalTime.parse(tekst[7]);
			int dod = Integer.parseInt(tekst[8]);
			LocalTime czask = czas1.plusMinutes(dod);
			
			if(tekst[1].equals(tekstw[0]))
			{
				nrGab = tekst[0];
			}
			if(czas1.isBefore(czas2) || czask.isAfter(czas3) )
			{
				licznik++;
			}
			
			
		}
		if(licznik==0 && nrGab!=null)
		{
			zapis2.println();
			zapis2.print("false,"+tekstw[0]+","+tekstp[2]+","+nrGab+","+tekstw[1]+","+tekstw[2]+","+wynik);
			System.out.println("Wizyta zapisana pomyslnie");
		}
		else
		{
			System.out.println("Termin zostal juz zarezerwowany przez innego pacjenta, lub taki nie istnieje , lub podany lekarz nie przyjmuje w przychodni");
		}
		zapis2.close();
	}
	public void wyrejestruj(String linia, String dane)
	{
		String pesel[] = null;
		pesel = linia.split(",");
		String danew[] = null;
		danew = dane.split(",");
		Scanner s1 = null;
		Scanner s2 = null;
		PrintWriter zapis1 = null;
		PrintWriter zapis2 = null;
		try
		{
			 File plik1 = new File("Wizyty.txt");
			 s1 = new Scanner(plik1);
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
		
		int licznik = 0;
		while(s1.hasNextLine())
		{
			String line = s1.nextLine();
			String tekst[] = null;
			tekst = line.split(",");
			if(tekst[2].equals(pesel[2]) && tekst[4].equals(danew[1]) && tekst[5].equals(danew[2]) && tekst[0].equals("false"))
			{
				continue;
			}
			else
			{
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
			licznik++;
		}
		
		zapis1.close();
		zapis2.close();
		s1.close();
		
		PrintWriter zapis3 = null;
		PrintWriter zapis4 = null;
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
			String line = s2.nextLine();
			String tekst[] = null;
			tekst = line.split(",");
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
		s2.close();
	}
}
