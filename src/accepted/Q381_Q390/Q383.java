package accepted.Q381_Q390;

/**
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters
 * from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom  
 * note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
 * <p>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        char[] rArr = ransomNote.toCharArray();
        char[] mArr = magazine.toCharArray();
        for (char c : mArr) {
            cnt[c - 'a']++;
        }
        for (char c : rArr) {
            cnt[c - 'a']--;
        }
        for (int i : cnt) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
