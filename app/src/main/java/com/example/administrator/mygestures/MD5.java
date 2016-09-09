package com.example.administrator.mygestures;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/9/6 0006.
 */
public class MD5 {
    public static String getMD5(String content){
        try {
            MessageDigest digest=MessageDigest.getInstance("MD5");
            digest.update(content.getBytes());
            return getHashString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getHashString(MessageDigest digest){
        StringBuilder builder=new StringBuilder("");
        for (byte data:digest.digest()){
            builder.append(Integer.toHexString((data>>4)&0xf));
            builder.append(Integer.toHexString(data&0xf));
        }
        return builder.toString();
    }

    public static String getMD5x100(String content){
        String s1 = content;
        for(int i = 0;i < 100;i++){
            s1 = getMD5(s1);
        }
        return s1;
    }
}
