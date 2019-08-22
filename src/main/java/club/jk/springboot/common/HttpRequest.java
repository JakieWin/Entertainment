package club.jk.springboot.common;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequest {
    public static String sendGet(String url, Map<String,String> param){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            //创建uri
            URIBuilder builder = new URIBuilder(url);
            if(param != null){
                for (String key : param.keySet()){
                    builder.addParameter(key,param.get(key));
                }
            }
            URI uri = builder.build();

            //创建HttpGet请求
            HttpGet httpGet = new HttpGet(uri);
            //执行请求
            response = httpClient.execute(httpGet);
            //判断返回状态是否为200
            if(response.getStatusLine().getStatusCode() == 200){
                resultString = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(response != null){
                    response.close();
                }
                httpClient.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String sendGet(String url){
        return sendGet(url,null);
    }

    public static String sendPost(String url,Map<String,String> param){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost();
            //创建参数列表
            if(param != null){
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()){
                    paramList.add(new BasicNameValuePair(key,param.get(key)));
                }
                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String sendPost(String url){
        return sendPost(url,null);
    }

    public static String sendPostJson(String url,String json){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString ="";
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(),"UTF-8");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultString;
    }
}
