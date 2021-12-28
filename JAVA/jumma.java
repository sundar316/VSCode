import java.util.*;

class solution {
    private static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) {
		// Write your code here
		// int n=sc.nextInt();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++)
        // {
        //         arr[i]=sc.nextInt();
        // }
        // for(int i=0;i<arr.length-1;i++)
        // {
        //     if(arr[i]>arr[i+1])
        //     {
        //         System.out.print(arr[i]+" ");
        //     }
        //     if(i+1==arr.length-1)
        //         System.out.print(arr[i+1]);
        // }

		// int n=sc.nextInt();
        // for(int i=0;i<n;i++)
        // {
        //     int a=1;
        //     for(int j=0;j<n;j++)
        //     {
        //         if(i+j>=n-1)
        //         {
        //             System.out.print(a++);
        //         }
        //         else
        //         {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }

        // int n=sc.nextInt();
        // int a=5;
        // int c=0;
        // for(int i=0;i<n;i++)
        // {
        //     if(c==0)
        //     {
        //         System.out.print(a+" ");
        //         a+=6;
        //     }
        //     else if(c<3)
        //     {
        //         System.out.print(a+" ");
        //         a+=3;
        //     }
        //     c++;
        //     if(c==3)
        //         c=0;
        // }
        // System.out.print(Integer.toString(sc.nextInt()));

        // for(int i=36;i<=582;i+=78)
        // {
        //     int p=((i-32)*5)/9;
        //     System.out.println(i+" "+p);
        // }


        int p=sc.nextInt();
        int[][] arr=new int[p][p];
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<p;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j || i+j==n-1 || i==0 || i==n-1 || j==0 || j==n-1)
                {
                    if((i==n/2 && j==n/2) && n%2!=0)
                        continue;
                    sum+=arr[i][j];
                }
            }
        }
        if(n%2!=0)
        	System.out.println(sum+arr[n/2][n/2]);
        else
            System.out.println(sum);
	}
}