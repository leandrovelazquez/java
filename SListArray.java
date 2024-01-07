import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class SListArray extends SList{

    String[] slst;

    public SListArray(){
    // creates an empty list

    slst = new String[0];
    }

    public SListArray(String[] elements){
    // creates a list with the strings in elements
    // the ordering and size of this list will be the same as in elements

    slst = elements;
    }

    @Override
    public String get(int position){
        
        if (position > slst.length -1){
            
            return "INDEX_OUT_OF_RANGE";
        }
        return slst[position];
    }

    @Override
    public String set(int position, String element){
        
        if (position < slst.length && position >= 0){
            
            String ogstr = slst[position];
            slst[position] = element;
            return ogstr;
        }
        return "INDEX_OUT_OF_RANGE";
    }

    @Override
    public String add(int position, String element){

        if (position <= slst.length && position >= 0){
            
            String[] slst1 = new String[slst.length +1];
            
            int i = 0;
            while(i < slst1.length){
                if(i == position){
                    slst1[position] = element;
                    i += 1;
                
                    while(i< slst1.length){
                        slst1[i] = slst[i-1];
                        i += 1;
                    }
                    slst = slst1;
                    return "INDEX_OK";
                } 
                if (i != position){
                    slst1[i] = slst[i];
                }
                i += 1;
            }
        }
        return "INDEX_OUT_OF_RANGE";
    }

    @Override
    public String remove(int position){

        String p = slst[position];
        if (position < slst.length){  
            String[] slst1 = new String[slst.length -1];
            int i = 0;
            int k = 0;
            while (i < slst1.length){

                if (i != position){
                    slst1[i] = slst[k];
                    i += 1;
                    k +=1;
                }
                if (i == position){
                    k += 1;
                    if(k == slst.length){
                        slst = slst1;
                        return p;
                    }
                    slst1[i] = slst[k];
                    i +=1;
                    k +=1;
                }
            }
            slst = slst1;
            return p;
        }
        return "INDEX_OUT_OF_RANGE";
    }

    @Override
    public int size(){
        return slst.length;
    }

    @Override
    public void append(SList anotherSList){

        int n = slst.length + anotherSList.size();
        String[] slst1 = new String[n];
        int i = 0;
        while (i < slst.length){
            
            slst1[i] = slst[i];
            i += 1;
        }
        int k = 0;
        while (i < n){
            
            slst1[i] = anotherSList.get(k);
            i += 1;
            k += 1;
        }
        slst = slst1;
    }

    @Override
    public String toString(){
        return Arrays.toString(slst);
    }

    @Override
    public SList commonStrings(){

        int l = slst.length;
        int i = 0;
        int most = 0;
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        while (i < l){

            String word = slst[i];
            int k = 0;
            int count = 0;
            while (k < l){

                if (word == slst[k]){
                    count +=1;
                }
                k += 1;
            }
            if (count > most){
                most = count;
            }
            frequencies.put(word, count);
            i += 1;
        }

        int c = 0;
        for (String s : frequencies.keySet()) {
             if (frequencies.get(s) == most){
                c +=1;
             }
          }

        String[] cstr = new String[c];
        i = 0;
        int k = 0;
        while (i < l && k < c){
            String word = slst[i];
            if (frequencies.get(word) == most){
                
                if (k == 0){
                    cstr[k] = word;
                    k += 1;

                }

                if (k != 0){
                    if (word != cstr[k-1]){
                        cstr[k] = word;
                        k += 1;
                    }
                }
            }
            i += 1;
        }
        SListArray com_str = new SListArray(cstr);
        return com_str;
    }

    private static Set<String> getKeys(HashMap<String, Integer> map, Integer value) {

      Set<String> result = new HashSet<>();
      if (map.containsValue(value)) {
          for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
              if (entry.getValue().equals(value)) {
                  result.add(entry.getKey());
              }

          }
      }
      return result;
    }

    private static boolean check(int[] arr, int toCheckValue){

        for (int element : arr) {
            if (element == toCheckValue) {
                return true;
            }
        }
        return false;
    }

    @Override
    public SList[] commonStrings(int n){

        int l = slst.length;
        int i = 0;
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        while (i < (l)){

            String word = slst[i];
            int k = 0;
            int count = 0;
            while (k < l){

                if (word == slst[k]){
                    count +=1;
                }
                k += 1;
            }
            frequencies.put(word, count);
            i += 1;
        }


        int[] freqs = new int[frequencies.size()];

        int c = 0;
        for (String s : frequencies.keySet()) {
             
            if (c == 0){
                freqs[c] = frequencies.get(s);
                c +=1;
            }
            if (c !=0){
                
                if (!check(freqs, frequencies.get(s))){
                    freqs[c] = frequencies.get(s);
                    c +=1;
                }
            }
        }
        

        i = 0;
        int count = 0;
        while(i < freqs.length){
            if (freqs[i] == 0){
                count +=1;
            }
            i += 1;
        }
        
        int[] freqs1 = new int[freqs.length - count];

        i = 0;
        while(i < freqs1.length){
            freqs1[i] = freqs[i];
            i += 1;
        }

        Arrays.sort(freqs1);

        int[] freqs2 = new int[freqs1.length];

        i = 0;
        l = freqs1.length - 1;
        while(i < freqs1.length){

            freqs2[i] = freqs1[l-i];
            i += 1;
        }
        
        
        i = 0;
        int k = 0;
        SListArray[] result = new SListArray[n];
        
        while(i < freqs2.length && k < n && freqs2[i] != 0){
            
            String[] y = new String[0];
            SListArray r1 = new SListArray(y);
            for (String key : getKeys(frequencies, freqs2[i])) {
                
                String[] z = new String[1];
                z[0] = key;
                SListArray z1 = new SListArray(z);
                r1.append(z1);
            } 
            result[k] = r1;
            i +=1;
            k +=1;
        } 
        return result; 
    }


public static void main(String[] args){

    
    String[] elem = {"blue", "green", "red", "yellow"};
    SListArray a1 = new SListArray(elem);
    
    //System.out.println("Check con");
    //System.out.println(a1);
    
    //System.out.println("Check get");
    //String g = a1.get(1);
    //System.out.println(g); 

    //System.out.println("Check set");
    //a1.set(3, "purple");
    //System.out.println(a1); 
    
    System.out.println("Check add");
    a1.add(4, "black");
    System.out.println(a1);
    /* 
    System.out.println("Check rem");
    a1.remove(3);
    System.out.println(a1);

    System.out.println("Check size");
    System.out.println(a1.size());

    String[] elem1 = {"a, b, c"};
    System.out.println("Check ap");
    SListArray a2 = new SListArray(elem1);
    a1.append(a2);
    System.out.println(a1); 

    System.out.println("check comstr");
    //String[] elem2 = {"a", "s", "c", "a", "b", "b", "a", "b", "s", "c", "d"};
    //String[] elem2 = {"a"};
    String[] elem2 = {"G4", "Z3", "A3", "H7", "Y6", "G4", "Z3", "H7", "D1", "E6", "L1", "E6", "H7", "Y6", "H7", "N1", "I1", "A3", "B2", "Z3", "Y6", "K1", "B2", "H7", "F1", "C2", "J1", "H7", "G4", "E6", "A3", "E6", "B3", "G4", "C2", "B3", "H7", "E6", "M1", "Y6", "Y6", "Q1", "B3", "P1", "E6", "Y6"};
    SListArray a3 = new SListArray(elem2);
    System.out.println(a3.commonStrings());

    System.out.println("check comstrint");
    System.out.println(Arrays.deepToString(a3.commonStrings(4))); */





}
}


