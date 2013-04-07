package shuffle;

import util.PrintArr;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-4-7
 * Time: 上午9:31
 * To change this template use File | Settings | File Templates.
 */
public class FisherYates {
    private Random r=new Random();
    public void shuffle(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int j=r.nextInt(i+1);
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }


    public static void main(String [] args){
        FisherYates f=new FisherYates();
        int[] arr={2,1,3,4,5,6,7,8,9,10,12,11};
        PrintArr.printArr(arr);
        for (int i=0;i<10;i++){
            f.shuffle(arr);
            PrintArr.printArr(arr);
        }
    }
}
