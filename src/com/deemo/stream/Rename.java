package com.deemo.stream;

import java.io.File;
import java.io.IOException;

public class Rename {
    public static void main(String[] args) throws IOException {
        File dir = new File("\\\\10.10.10.25\\Video\\Naruto HDTV 1920x1080 x264 AAC\\火影忍者466-720 [1920x1080]");

        System.out.println(dir.isFile());
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files == null) {
                return;
            }

            System.out.println(files.length);
            StringBuilder newName = new StringBuilder();
            boolean renameTo;
            int success = 0;
            for (File file : files) {
                /*System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
                System.out.println(file.getCanonicalPath());
                System.out.println(file.getPath());
                System.out.println(file.getParent());*/

                newName.setLength(0);
                newName.append(file.getName().replaceAll("\\[猪猪字幕组]", "").replaceAll("\\[HDTV 1920x1080]", ""));
                renameTo = file.renameTo(new File(file.getParent() + "\\" + newName.toString()));
                success += renameTo ? 1 : 0;
                System.out.println("文件：" + file.getName() + "重命名为：" + newName + (renameTo ? "成功！" : "失败！"));
            }

            System.out.println("成功重命名" + success + "个文件！");
        }

    }
}
