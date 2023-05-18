package finalproject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;

public class PhraseMatch {
    public static int Match(String filename1,String filename2) throws IOException{  
    	int pdr;
    	int sameword = 0;
    	ArrayList<String> sentence1 = ReadWithoutQuote.ReadFile(filename1);
    	ArrayList<String> sentence2 = ReadWithoutQuote.ReadFile(filename2);
    	int total = (sentence1.size()) +(sentence2.size());
        sameword = CalculatePdr(sentence1, sentence2);
        pdr = (200*sameword) / total;
        return pdr;
    }
        public static int CalculatePdr(ArrayList<String> sentence1, ArrayList<String> sentence2) {
        	int sd = 0;
            for (int i = 0; i < sentence1.size(); i++) {
                String word1 = sentence1.get(i);            
                for (int j = 0; j < sentence2.size(); j++) {
                    String word2 = sentence2.get(j);
                    if (word1.equals(word2)) {
                    	int n = 1;
                    	boolean r = false;
                        while (i+n < sentence1.size() && j+n < sentence2.size() && sentence1.get(i+n).equals(sentence2.get(j+n))) {
                        	n++;
                        	if(n == 3 && r == false) {
                        		sd+=3;                       		
                        		r = true;
                        		i+=3;
                        		j+=3;
                        		n-=2;
                        	}
                        	else if(r == true) {
                        		sd+=1;
                        		i++;
                        		j++;
                        		n--;
                        	}
                        }
                    break;
                    }
                }
            }
            return sd;
    }
        public static void PrintPdrMap() throws IOException {
        	Map<String, Integer> hashMap = CreateMap();
            hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()+"%"));
        }
        public static Map<String, Integer> CreateMap() throws IOException{
        	Map<String, Integer> Pdrmap = new HashMap<>();
            for (int p = 0; p < 5; p++) {
                for (int q = p+1; q < 5; q++) {
        			String filename1and2 = demo.filenames[p]+" and "+demo.filenames[q];
        			int Lpdr = Match(demo.filenames[p],demo.filenames[q]);
        			Pdrmap.put(filename1and2,Lpdr);
        		}
        	}
        	return Pdrmap;
        }
}