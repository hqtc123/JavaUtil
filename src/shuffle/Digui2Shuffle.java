package shuffle;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-30
 * Time: 下午9:32
 * To change this template use File | Settings | File Templates.
 */
public class Digui2Shuffle {
    int max_len=10;
    char[] testArr={'a','b','c','d','e','A','B','C','D','E'};
    char recurArr[]=new char[10];

    int cnt=0;

    private void shuffleArrayRecursiveTmp(char[] arr,int len){
        if(cnt>max_len||len<=0){
            return;
        }

        //todo
    }
    public static void main(String[] args){

    }
}
