package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ArrOrder {

    /*
        input:  3 4 1 2 3 7 4
        output: 3 3 4 4 1 2 7
    */
    public static void main(String[] args) {
        TreeMap<Integer, ArrayList<Integer>> l = new TreeMap<>();
        ArrayList<Integer> arr = new ArrayList<>(List.of(4,7,2,4,1,3,3,9));
        for(int i:arr){
            int fq = Collections.frequency(arr,i);
            if(l.containsKey(fq)){
                l.get(fq).add(i);
            }
            else{
                ArrayList<Integer> tp = new ArrayList<>();
                tp.add(i);
                l.put(fq,tp);
            }
        }
        String ans = "";
        ArrayList<Integer> keys = new ArrayList<>(l.keySet());
        for(int i=keys.size()-1;i>=0;i--){
            ans+=l.get(keys.get(i));
        }
        ans = ans.replaceAll(", "," ");
        ans = ans.replaceAll("\\["," ");
        ans = ans.replaceAll("]","");
        System.out.println(ans);
    }

}
