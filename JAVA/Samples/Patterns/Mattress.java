import java.util.*;

class Solution {
    public static int sortedSum(List<Integer> a) {
        // Write your code here
        int[] arr=new int[a.size()];
        for(int i=1;i<=a.size();i++)
        {
            int[] ar=new int[i];
            for(int j=0;j<i;j++)
            {
                ar[j]=a.get(j);
                //arr[i-1]+=(a.get(j))*(j+1);
            }
            Arrays.sort(ar);
            int sm=0;
            int c=1;
            for(int j:ar)
            {
                sm+=(j*c);
                c++;
            }
            arr[i-1]=sm;
        }
        int sum=0;
        for(int i:arr)
        {
            sum+=i;
        }
        return sum;
        }
    public static void main(String[] args){
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(sortedSum(a));
    }
}
