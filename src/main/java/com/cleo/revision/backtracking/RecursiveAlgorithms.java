package com.cleo.revision.backtracking;

public class RecursiveAlgorithms {

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b,a%b);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    public static int noOfdigits(int n){
        int answer = 0;
        while(n!=0){
            n/=10;
            answer++;
        }
        return answer;
    }

    public static int reverse(int n){
        if(n/10==0)
            return n;
        else{
            return reverse(n/10)*n/10+n%10;
        }
    }
    static int rev_num = 0;
    static int base_pos = 1;
    static int reverseDigits(int num)
    {
        if (num > 0) {
            reverseDigits(num / 10);
            rev_num += (num % 10) * base_pos;
            base_pos *= 10;
        }
        return rev_num;
    }

    public static int karatsubaMultiplication(int n, int m){
        int n1 = noOfdigits(n);
        int temp = n1;
        int n2 = noOfdigits(m);
     //   System.out.println(n1);
        n = reverseDigits(n);
        rev_num = 0;
        base_pos = 1;
        m = reverseDigits(m);
        System.out.println(m);
        System.out.println();
        int a=0, c=0,b=0,d=0;
        int mid1 = 0,mid2=0;
        while(mid1<=n1/2){
            //10^n1*
            a=(int) Math.pow(10,mid1)*a + n%10;
    //        System.out.println(Math.pow(10,mid1)+ " " + n%10);
      //      System.out.println(a);
            n/=10;
            mid1+=1;
            n1-=1;
        }
     //   System.out.println(a);
        while(mid1>=0){
            b=(int) Math.pow(10,mid1)*b+n%10;
            n/=10;
            mid1-=1;

        }
        while(mid2<=n2/2){
            //10^n1*
            c=(int) Math.pow(10,mid2) *c+ m%10;
            System.out.println(c);
            m/=10;
            mid2+=1;
            n2-=1;
        }
        while(mid2>=0){
            d=(int) Math.pow(10,mid2)*d+m%10;
            m/=10;
            mid2-=1;
        }

        //Step 1
        int ac = a*c;
        int bd = b*d;
        int ad = a*d;
        int bc = b*c;
             return (int) (Math.pow(10,temp)*ac+(int)(Math.pow(10,(double) temp/2))*(ad+bc)+bd);



    }

    public static void main(String[] args) {
       System.out.println(gcd(10,15));
        System.out.println(gcd(100,12325));
        System.out.println(lcm(10,15));
        System.out.println(karatsubaMultiplication(1234,5678));
        //System.out.println(reverse(1234));
       // System.out.println(reverseDigits(1234));
    }
}
