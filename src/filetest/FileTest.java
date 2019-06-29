package filetest;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {

        File file = new File("C:/Users/admin/Desktop/PNG序列");
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            File item = fileList[i];
            item.renameTo(new File( "D:/baiduapa/radar_" + i+".png"));
        }


    }


}
