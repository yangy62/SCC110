package finalproject;

import java.io.IOException;
import java.util.Scanner;

public class demo {
	public static String[] filenames = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
	public static void main(String[] args) throws IOException {
		boolean r = true;
		while(r == true) {
			int f = 0;
			System.out.println("select a option(1~3)(1:wordfrequency;2:phrasematch;3:end)");
			Scanner scan = new Scanner(System.in);
			f = scan.nextInt();
			if(f == 1){
				System.out.println("select two files(1~5)");
				Scanner scan1 = new Scanner(System.in);
				int g = scan1.nextInt()-1;
				Scanner scan2 = new Scanner(System.in);
				int h = scan2.nextInt()-1;
				WordFrequency.GetWordFrequency(filenames[g],filenames[h]);
			}
			else if(f == 2){
				System.out.println("compare two files or print pdrList?(1:compare;2:list)");
				Scanner scan3 = new Scanner(System.in);
				int l = scan3.nextInt();
				if(l == 1){
					System.out.println("select two files(1~5)");
					Scanner scan4 = new Scanner(System.in);
					int j = scan4.nextInt()-1;
					Scanner scan5 = new Scanner(System.in);
					int k = scan5.nextInt()-1;
					int answer =PhraseMatch.Match(filenames[j],filenames[k]);
					System.out.println("the pdr of "+"file"+j+" and"+" file"+k+" is "+answer);
				}
				else if(l == 2) {
					PhraseMatch.PrintPdrMap();
				}
				else {
					System.out.println("Wrong");
				}
			}
			else if(f == 3) {
				break;
			}
			else{
				System.out.println("Wrong,select again");
			}
		}
	}
}
