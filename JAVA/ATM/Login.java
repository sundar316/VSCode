package ATM;

public class Login {
    public static void main(String[] args) {
        int arr[]={5, 3, 1, 5, 1, 3, 4, 7, 4, 8, 8};
        for(int i=0;i<arr.length;i++)
        {
            int a=0;
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j)
                {
                    if(arr[i]==arr[j])
                    {
                        a++;
                        break;
                    }
                }
            }
            if(a==0)
                System.out.println(arr[i]);
        }
    }
}
