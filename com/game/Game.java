package com.game;

public class Game {
    public static int score = 500;
    public static int indexAndCharTrue = 0;//字符正确并字符位置对的个数
    public static int charTrue = 0;//字符正确个数
    public static String guessCharTrue ="";

    public Game() {
    }

    /**
     * 比较字符串
     * @param s 随机生成的数组
     * @param s1 输入的数组
     * @return
     */
    public static void compare(String s,String s1) {

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==s1.charAt(i)){
                indexAndCharTrue++;
                if(guessCharTrue.length()==0 || guessCharTrue.length()==s.length()-1)
                    guessCharTrue+= s.charAt(i);
                else{
                    guessCharTrue= guessCharTrue+s.charAt(i)+"、";
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.contains(s1.charAt(i) + "")){
                charTrue++;
            }
        }
    }

    /**
     * 计算分数
     */
    public static int calscore(String s,String s1){
        int mark = 0;
        compare(s,s1);
        mark = indexAndCharTrue+charTrue;
        if(mark==10){
            score += 10;
        }else{
            score -= 10;
        }
        return mark;

    }

    /*
    随机生成5个不区分大小写的26个英文字符随机组成的字符数组
     */
    public static char[] generate() {

        char[] b = new char[5];
        for (int i = 0; i < b.length; i++) {
            b[i] = (char) (Math.random() * 26 + 'a');
            for (int j = 0; j < i; j++) {
                if (b[j] == b[i]) {
                    i--;
                    break;
                }
            }
        }
        return b;
    }
}
