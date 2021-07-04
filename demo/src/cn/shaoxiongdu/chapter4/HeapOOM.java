package cn.shaoxiongdu.chapter4;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    //占1M
    byte [] bytes = new byte[1024 * 1024 * 1];

    public static void main(String[] args) {

        List list = new ArrayList();
        int count = 0;
        try {
            while (true){
                list.add(new HeapOOM());
                count++;
            }
        }catch (Throwable t){
            System.out.println(count);
            t.printStackTrace();
        }
    }
}
