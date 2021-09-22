package Arrays;

public class CountBetween {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,4},low={0,2},high={2,4};
        int count1=0,count2=0;
        for(int i:arr)
        {
            if(i>=low[0]&&i<=low[1])
                count1++;
            if(i>=high[0]&&i<=high[1])
                count2++;
        }
        System.out.print(count1+"\t"+count2);
    }
}
