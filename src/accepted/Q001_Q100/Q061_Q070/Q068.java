package accepted.Q001_Q100.Q061_Q070;

import java.util.ArrayList;
import java.util.List;

public class Q068 {

public List<String> fullJustify(String[] words, int L) {
        
        int i = 0;
        List<String> strs = new ArrayList<String>();
        while (i < words.length) {
            List<String> sLine = new ArrayList<String>();
            int t = 0;
            while (i < words.length && t + words[i].length() <= L) {
                sLine.add(words[i]);
                t += words[i].length() + 1;
                i++;
            }
            if (i == words.length) {
                strs.add(lastLine(sLine, L, t-1));
            } else {
                strs.add(justify(sLine, L, t-1));
            }
        }
        
        return strs;
    }
    
    private String justify(List<String> sLine, int L, int t) {
        int s = sLine.size();
        int[] spaces = new int[s];
        
        if (s == 1) {
            spaces[0] = L - sLine.get(0).length();
        } else {
            for (int i = 0; i < s - 1; i++) {
                spaces[i] = (L - t) / (s - 1) + 1;
            }
            int r = (L - t) % (s - 1);
            for (int i = 0; i < r; i++) {
                spaces[i]++;
            }
        }
        
        String result = "";
        for (int i = 0; i < s; i++) {
            result += sLine.get(i) + getSpaces(spaces[i]);
        }
        
        return result;
    }
    
    private String lastLine (List<String> sLine, int L, int t) {
    
        String line = "";
        for (int i = 0; i < sLine.size(); i++) {
            line += sLine.get(i);
            if (i < sLine.size() - 1) {
                 line += " ";
            }
        }
        line += getSpaces(L - t);
        return line;
    }
    
    
    private String getSpaces(int L) {
        String result = "";
        for (int i = 0; i < L; i++) {
            result += " ";
        }
        return result;
    }
	
}
