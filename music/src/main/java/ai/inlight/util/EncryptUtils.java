package ai.inlight.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import com.google.gson.JsonObject;

import org.apache.commons.codec.binary.Base64;


public class EncryptUtils {

    String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876ae" +
            "a8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685" +
            "b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
    String nonce = "0CoJUm6Qyw8W8jud";
    String pubKey = "010001";

    /**
     * 随机生成数
     */
    private String createSecretKey(int size){
        Double a = 10.0;
        Double b = (double) (size - 1);
        return String.valueOf((long)((Math.random()*9+1)*Math.pow(a,b)));
    }

    /**
     * AES加密
     */
    private String aesEncrypt(String text,String secKey) throws Exception{
        SecretKeySpec sKeySpec = new SecretKeySpec(secKey.getBytes("utf-8"),"AES");
        IvParameterSpec iv=new IvParameterSpec("0102030405060708".getBytes("utf-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,sKeySpec,iv);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(encrypted);
    }


    /**
     * RSA加密
     */
    private String rsaEncrypt(String text,String pubKey,String modulus){
        String res =new StringBuilder(text).reverse().toString();
        BigInteger a = new BigInteger(stringToHex(res),16);
        BigInteger b = new BigInteger(pubKey,16);
        BigInteger c = new BigInteger(modulus,16);
        BigInteger result = a.modPow(b,c);
        return addSign2String("0",result.toString(16),256);
    }

    /**
     * MD5加密
     */
     private String md5Digest(String text){
        byte[] bytes = text.getBytes();
         MessageDigest mDigest = null;
         try {
             mDigest = MessageDigest.getInstance("MD5");
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }

         mDigest.update(bytes);
        byte[] result = mDigest.digest();
        //bytes-->hex-->string
        StringBuilder builder =new StringBuilder();
        for (int i=0;i<result.length;i++){
            byte b = result[i];
            String tmp = Integer.toHexString(0xFF & (int)b);
            if (tmp.length() == 1) tmp = "0" +tmp;
            builder.append(tmp);
        }
        return builder.toString();
    }

    /**
     * 请求数据封装加密
     */
    public HashMap<String,String> encrypted_request(int userType,String username, String password){
        String pwd = md5Digest(password);
        JsonObject text =new JsonObject();
        switch (userType){
            case 0 : {text.addProperty("phone",username);text.addProperty("password",pwd);break;}
            case 1 : {text.addProperty("username",username);text.addProperty("password",pwd);break;}
        default: break;
        }
        String secKey = createSecretKey(16);

        String encText = null;
        try {
            encText = aesEncrypt(aesEncrypt(text.toString(),nonce),secKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String encSecKey = rsaEncrypt(secKey, pubKey,modulus);
        HashMap map = new HashMap<String,String>();
        map.put("params", encText);
        map.put("encSecKey", encSecKey);
        return map;
    }

    /**
     * 评论数据封装加密
     */
    public HashMap<String,String> encrypted_comments(String musicId,int page,int limit){
        JsonObject text =new JsonObject();
        text.addProperty("sid",musicId);
        text.addProperty("limit",limit);

        switch (page){
            case 0: {
                text.addProperty("offset",0);
                text.addProperty("total",true);
            }
            break;
        default:  {
                text.addProperty("offset",(page - 1) * 20);
                text.addProperty("total",false);
            }
        }
        String secKey = createSecretKey(16);
        String encText = null;
        try {
            encText = aesEncrypt(aesEncrypt(text.toString(),nonce),secKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String encSecKey = rsaEncrypt(secKey, pubKey,modulus);
        HashMap map = new HashMap<String,String>();
        map.put("params",encText);
        map.put("encSecKey", encSecKey);
        return map;
    }

    /**
     * 字符串转十六进制
     */
    public String stringToHex(String string){
        StringBuilder str =new StringBuilder();
        for (int i =0;i< string.length();i++) {
            char s = string.toCharArray()[i];
            String w = Integer.toHexString((int)s);
            str.append(w);
        }
//        (0 until string.length)
//            .map { string.toCharArray()[it] }
//            .map { Integer.toHexString(it.toInt()) }
//            .forEach { str.append(it) }
        return str.toString();
    }

    /**
     * 在指定字符前补sign字符
     */
    private String addSign2String(String sign,String str,int len){
        String string = str;
        int length = string.length();
        if (length < len){
            while (length < len){
                StringBuffer builder =new StringBuffer();
                builder.append(sign).append(string);
                string = builder.toString();
                length = string.length();
            }
        }
        return string;
    }


}
