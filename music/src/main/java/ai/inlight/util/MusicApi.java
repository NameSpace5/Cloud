package ai.inlight.util;

import model.bean.*;
import util.OkHttpManager;

import java.io.IOException;
import java.util.HashMap;
import com.google.gson.*;

public class MusicApi {

    private static String ACTION_URL_TOP = "api/playlist/detail";
    private static String BASE_URL_163 = "http://music.163.com";
    private static String ACTION_URL_SEARCH = "api/search/get/";
    private static String ACTION_URL_LOGIN_CELLPHONE = "weapi/login/cellphone";
    private static String ACTION_URL_LOGIN = "weapi/login";
    private static String ACTION_URL_COMMENTS = "weapi/v1/resource/comments/R_SO_4_";
    private static OkHttpManager client = OkHttpManager.instance;
    private static EncryptUtils encryptUtils = new EncryptUtils();



    /**
     * 音乐搜索，返回SongResult
     * @Param name 搜索名
     * @param type 搜索类型 1-> 单曲  10->专辑 100->歌手 1000->歌单 1002->用户
     * @param count 搜索结果数目
     * @param page 显示页数
     */
    public SongsResult songSearch(String name, int type, int count, int page) throws IOException {
        HashMap map = new HashMap<String,String>();
        map.put("s", name);
        map.put("limit", count);
        map.put("type", type);
        map.put("offset", page);


        String temp = client.requestPostSyn(BASE_URL_163, ACTION_URL_SEARCH,map);
        String json = new JsonParser().parse(temp).getAsJsonObject().get("result").toString();
        return new Gson().fromJson(json,SongsResult.class);
    }
    /**
     * 手机登陆，封装加密方式
     * @Param phone
     * @Param password
     */
   public LoginResult loginPhone(String phone,String password) throws IOException {
        HashMap map = encryptUtils.encrypted_request(0,phone,password);
        String result = client.requestPostSyn(BASE_URL_163, ACTION_URL_LOGIN_CELLPHONE,map);

        return new Gson().fromJson(result,LoginResult.class);
    }

    /**
     * 邮箱登录?存在问题：非法登陆（云盾动态加密身份验证，由于资金问题先搁置）
     */
    public String login(String username,String password) throws IOException {
        HashMap<String, String> map = encryptUtils.encrypted_request(1,username,password);
        return client.requestPostSyn(BASE_URL_163, ACTION_URL_LOGIN,map);
    }

    /**
     * 热门评论获取,返回CommentResult
     * @param musicId 目标评论的音乐Id
     */
    public HotCommentResult hotComments(String musicId) throws IOException {
        String action_url = ACTION_URL_COMMENTS + musicId;
        HashMap<String, String> map = encryptUtils.encrypted_comments(musicId,1,20);
        String result = client.requestPostSyn(BASE_URL_163, action_url,map);
        return new Gson().fromJson(result, HotCommentResult.class);
    }

    /**
     * 评论获取，第一页comments为最新评论，hotComments为热门评论，第二页之后不再有hotComments
     * @param musicId 目标评论的音乐Id
     * @param page 页数
     * @param count 获取评论数量
     */
    public CommentResult comments(String musicId, int page,int count) throws IOException {
        String action_url = ACTION_URL_COMMENTS + musicId;
        HashMap<String,String> map = encryptUtils.encrypted_comments(musicId,page,count);
        String result = client.requestPostSyn(BASE_URL_163, action_url,map);
        return new Gson().fromJson(result, CommentResult.class);
    }


    /**
     * 获取歌单歌曲，地址已内置，引用 类TopList.变量名 即可，如(TopList.MUSIC_HOT)
     * 当然也可以自定义地址，如自己创建的歌单id
     * @param id 歌曲id
     */
    public TracksResult TracksMusic(String id) throws IOException {
        HashMap map = new HashMap<String,String>();
        map.put("id",id);
        String temp =  client.requestGetSyn(BASE_URL_163, ACTION_URL_TOP,map);
        String json = new JsonParser().parse(temp).getAsJsonObject().get("result").toString();

        return new Gson().fromJson(json,TracksResult.class);
    }
}
