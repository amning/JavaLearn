package com.album.util;
import java.io.InputStream;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;
/**
 * Created by 王宁 on 2017/6/12.
 */
public class FileUtils {
    private static final String ACCESS_KEY = "Kak0lQ3fwpUWeT2tiRxECvwFmMYI3nLkPMdXbhlA";
    private static final String SECRET_KEY = "lE_SvA3tgot2zo1uRqULMUubCXhmwDuEZQ9p8V11";
    private static final String BUCKET_NAME = "myalbum";
    public static void upload(InputStream reader, String fileName) {
        String uptoken;
        try {

            Mac mac= new Mac(ACCESS_KEY,SECRET_KEY);
            PutPolicy putPolicy=new PutPolicy(BUCKET_NAME);
            uptoken=putPolicy.token(mac);
            IoApi.Put(uptoken,fileName,reader,null);
        } catch (AuthException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public static void delete( String key) {
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        RSClient client = new RSClient(mac);
        client.delete(BUCKET_NAME, key);
    }

}
