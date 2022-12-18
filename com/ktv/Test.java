package com.ktv;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        welcomeUser();
        HashMap<String, Integer> musicList = new HashMap<>();
        addMusicList(musicList);

        while (true) {
            System.out.println();
            System.out.print("请输入要执行的操作：");
            Scanner scanner = new Scanner(System.in);
            int chooseNum = scanner.nextInt();
            switch (chooseNum) {
                case 0://添加歌曲至列表
                    addMusic(musicList);
                    break;
                case 1://将歌曲置顶
                    setTop(musicList);
                    break;
                case 2://将歌曲前移一位
                    setBefore(musicList);
                    break;
                case 3://退出
                    exit();
                    break;
                default://不合法的输入
                    System.out.println("您的输入不合法，请按照说明输入！");
                    break;
            }
        }

    }
    private static void setTop(HashMap<String, Integer> hm) {
        System.out.print("请输入置顶歌曲：");
        String musicName = new Scanner(System.in).nextLine();
        boolean position = hm.containsKey(musicName);
        int i = hm.get(musicName);
        if (!position) {
            System.out.println("不存在该歌曲，请重新输入");
        } else {
            //将歌曲往后移动一位
            hm.forEach((key,value) -> {
                if(value<i) {
                    value++;
                    hm.put(key,value);
                }
            });
            hm.put(musicName,0);
            System.out.println("已将歌曲《" + musicName + "》置顶");
            System.out.println("当前歌曲列表：" + printList(hm));
        }
    }
    private static void setBefore(HashMap<String, Integer> hm) {
        System.out.print("请输入前移歌曲：");
        String musicName = new Scanner(System.in).nextLine();
        boolean position = hm.containsKey(musicName);
        int i = hm.get(musicName);
        if (!position) {
            System.out.println("不存在该歌曲，请重新输入");
        } else if (i==0) {
            System.out.println("已位于首位，不需要前移");
        } else {
            hm.forEach((key,value) -> {
                if(value == i-1){
                    hm.put(key,i);
                }
                if(value == i){
                    hm.put(key,i-1);
                }
            });

            System.out.println("已将歌曲《" + musicName + "》前移一位");
            System.out.println("当前歌曲列表：" + printList(hm));
        }
    }


    private static void addMusic(HashMap<String, Integer> hm) {
        System.out.print("请输入要添加的歌曲：");
        String musicName = new Scanner(System.in).nextLine();
        hm.put(musicName,hm.size());
        System.out.println("已添加歌曲：" + musicName);
        System.out.println("当前歌曲列表:" + printList(hm));

    }

    private static void addMusicList(HashMap<String, Integer> hm) {
        hm.put("稻香",0);
        hm.put("夜曲",1);
        hm.put("夜的第七章",2);
        hm.put("听妈妈的话",3);
        hm.put("龙卷风",4);
        System.out.println("初始化歌曲列表:" + printList(hm));
    }

    private static void welcomeUser() {
        System.out.println("-------------欢迎来到点歌系统-------------");
        System.out.println("0.添加歌曲到列表");
        System.out.println("1.将歌曲置顶");
        System.out.println("2.将歌曲前移一位");
        System.out.println("3.退出");
    }

    private static void exit() {
        System.out.println("--------------- 退出 -----------------");
        System.out.println("您已退出该系统");
        System.exit(0);
    }
    private static ArrayList<String> printList(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        ArrayList<String> al = new ArrayList<>();
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> s : list)
        {
            al.add(s.getKey());
        }
        return al;
    }
}
