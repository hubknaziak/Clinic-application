package lab03_pop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Edycja 
{
	public void dodajLekarza(boolean pop, String dane)
	{
		if(pop==false)
		{
			return;
		}
		
		String danel[] = null;
		danel = dane.split(",");
		PrintWriter zapis = null;
		try
		{
			 zapis = new PrintWriter(new FileWriter("Lekarze.txt",true));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Blad przy odczycie pliku");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		zapis.println();
		zapis.print(danel[0]+","+danel[1]+","+danel[2]+","+danel[3]);
		zapis.close();
	}
	public void usunLekarza(boolean pop, String dane)
	{
		if(pop==false)
		{
			return;
		}
		
		String danel[] = null;
		danel = dane.split(",");
		Scanner s1 = null;
		Scanner s2 = null;
		PrintWriter zapis1 = null;
		PrintWriter zapis2 = null;
		try
		{
			 File plik1 = new File("Lekarze.txt");
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
		
		int licznik=0;
		while(s1.hasNextLine())
		{
			String line = s1.nextLine();
			String tekst[] = null;
			tekst = line.split(",");
			if(danel[0].equals(tekst[0]))
			{
				continue;
			}
			else
			{
				if(licznik==0)
				{
					zapis1.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]);
				}
				else
				{
					zapis2.println();
					zapis2.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]);
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
			zapis3 = new PrintWriter("Lekarze.txt");
			zapis4 = new PrintWriter(new FileWriter("Lekarze.txt",true));
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
				zapis3.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]);
			}
			else
			{
				zapis4.println();
				zapis4.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]);
			}
			licznik++;
		}
		zapis3.close();
		zapis4.close();
		s2.close();
		
		
	}
	public void godzinyPrzyjec(boolean pop, String dane)
	{
		if(pop==false)
		{
			return;
		}
		
		String daneg[] = null;
		daneg = dane.split(",");
		Scanner s1 = null;
		Scanner s2 = null;
		PrintWriter zapis1 = null;
		PrintWriter zapis2 = null;
		try
		{
			 File plik1 = new File("Gabinety.txt");
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
		
		int licznik=0;
		while(s1.hasNextLine())
		{
			String line = s1.nextLine();
			String tekst[] = null;
			tekst = line.split(",");
			if(daneg[0].equals(tekst[1]))
			{
				if(licznik==0)
				{
					zapis1.print(daneg[1]+","+daneg[0]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+daneg[2]+","+daneg[3]+","+daneg[4]+","+daneg[5]);
				}
				else
				{
					zapis2.println();
					zapis2.print(daneg[1]+","+daneg[0]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+daneg[2]+","+daneg[3]+","+daneg[4]+","+daneg[5]);
				}
			}
			else
			{
				if(licznik==0)
				{
					zapis1.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]+","+tekst[7]+","+tekst[8]);
				}
				else
				{
					zapis2.println();
					zapis2.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]+","+tekst[7]+","+tekst[8]);
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
			zapis3 = new PrintWriter("Gabinety.txt");
			zapis4 = new PrintWriter(new FileWriter("Gabinety.txt",true));
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
				zapis3.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]+","+tekst[7]+","+tekst[8]);
			}
			else
			{
				zapis4.println();
				zapis4.print(tekst[0]+","+tekst[1]+","+tekst[2]+","+tekst[3]+","+tekst[4]+","+tekst[5]+","+tekst[6]+","+tekst[7]+","+tekst[8]);
			}
			licznik++;
		}
		zapis3.close();
		zapis4.close();
		s2.close();
		
	}
}
