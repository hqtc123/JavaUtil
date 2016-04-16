import java.util.Scanner;

public class Main {
    //根据一段的字数算出每段应该占多少行
    public int getRow(int width, int fontSize, int wordNum) {
        int wordsPerRow = width / fontSize;
        int a = wordNum % wordsPerRow;
        if (a == 0) {
            return wordNum / wordsPerRow;
        }
        return wordNum / wordsPerRow + 1;
    }
    //根据设定的fontSize算出页数
    public int getPage(int pNum, int[] wordNumPerP, int width, int height, int fontSize) {
        if (pNum == 0) {
            return 0;
        }
        int rowPerPage = height / fontSize;
        int row = 0;
        for (int worNum : wordNumPerP) {
            row += getRow(width, fontSize, worNum);
        }
        int b = row % rowPerPage;
        if (b == 0) {
            return row / rowPerPage;
        }
        return row / rowPerPage + 1;
    }
    //调整fontSize，直到满足结果
    public int getMaxSize(int pNum, int[] wordNumPerP, int width, int height, int page) {
        int size;
        for (size = width; size > 0; size--) {
            if (size > height) {
                continue;
            }
            if (getPage(pNum, wordNumPerP, width, height, size) <= page) {
                break;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < num; i++) {
                String fLine = sc.nextLine();
                String[] a = fLine.split(" ");
                if (a.length != 4) {
                    return;
                }
                int pNum = Integer.parseInt(a[0]);
                int page = Integer.parseInt(a[1]);
                int width = Integer.parseInt(a[2]);
                int height = Integer.parseInt(a[3]);

                String words = sc.nextLine();
                String[] arr = words.split(" ");
                int[] wordPerP = new int[arr.length];
                for (int j = 0; j < arr.length; j++) {
                    wordPerP[j] = Integer.parseInt(arr[j]);
                }

                System.out.println(main.getMaxSize(pNum, wordPerP, width, height, page));
            }
        }
    }
}
