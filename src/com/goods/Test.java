package com.goods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
//        Clothing clothing = new Clothing(200,1,"男装");
//        System.out.println(clothing);
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(today);
        Date parse = sdf.parse(format);
        String format1 = sdf.format(parse);
        System.out.println(format1);
    }
}
