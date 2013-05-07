package io;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-5-7
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
public class IO {
    public static void main(String[] args){
        File f=new File("H://hello.txt");

        try {
            f.createNewFile();      //若文件已经存在不会抛出异常
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        //make a dir
        File dir=new File("D:"+File.separator+"hello");
        dir.mkdir();

        //path: http://www.cnblogs.com/rollenholt/archive/2011/09/11/2173787.html
    }
}
