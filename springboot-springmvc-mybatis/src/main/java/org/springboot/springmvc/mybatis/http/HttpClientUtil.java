package org.springboot.springmvc.mybatis.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil
{
    
    /**
     * <pre>
     * 方法体说明：向远程接口发起请求，返回字符串类型结果
     * @param url 接口地址
     * @param requestMethod 请求类型
     * @param params 传递参数
     * @return String 返回结果
     * </pre>
     */
    public static String httpRequestToString(String url, String requestMethod,
        Map<String, String> headers, Map<String, String> params)
    {
        String result = null;
        try
        {
            String parameters = "";
            boolean hasParams = false;
            // 将参数集合拼接成特定格式，如name=zhangsan&age=24
            for (String key : params.keySet())
            {
                String value = URLEncoder.encode(params.get(key), "UTF-8");
                parameters += key + "=" + value + "&";
                hasParams = true;
            }
            if (hasParams)
            {
                parameters = parameters.substring(0, parameters.length() - 1);
            }
            // 是否为GET方式请求
            boolean isGet = "get".equalsIgnoreCase(requestMethod);
            boolean isPost = "post".equalsIgnoreCase(requestMethod);
            boolean isPut = "put".equalsIgnoreCase(requestMethod);
            boolean isDelete = "delete".equalsIgnoreCase(requestMethod);
            
            // 创建HttpClient连接对象
            HttpClient client = HttpClients.createDefault();
            HttpRequestBase method = null;
            if (isGet)
            {
                url += "?" + parameters;
                method = new HttpGet(url);
            }
            else if (isPost)
            {
                method = new HttpPost(url);
                HttpPost postMethod = (HttpPost)method;
                StringEntity entity = new StringEntity(parameters);
                postMethod.setEntity(entity);
            }
            else if (isPut)
            {
                method = new HttpPut(url);
                HttpPut putMethod = (HttpPut)method;
                StringEntity entity = new StringEntity(parameters);
                putMethod.setEntity(entity);
            }
            else if (isDelete)
            {
                url += "?" + parameters;
                method = new HttpDelete(url);
            }
            // 设置Header
            method.setHeader("Content-Type", "application/json");
            if (headers != null)
            {
                for (Map.Entry<String, String> entry : headers.entrySet())
                {
                    method.setHeader(entry.getKey(), entry.getValue());
                }
            }
            // method.addHeader("Content-Type",
            // "application/x-www-form-urlencoded");
            // httpClient本地上下文
            // HttpClientContext context = null;
            /*
             * if (!(auth == null || auth.length == 0)) { String username =
             * auth[0]; String password = auth[1]; UsernamePasswordCredentials
             * credt = new UsernamePasswordCredentials(username, password); //
             * 凭据提供器 CredentialsProvider provider = new
             * BasicCredentialsProvider(); // 凭据的匹配范围
             * provider.setCredentials(AuthScope.ANY, credt); context =
             * HttpClientContext.create();
             * context.setCredentialsProvider(provider); }
             */
            // 访问接口，返回状态码
            // HttpResponse response = client.execute(method, context);
            HttpResponse response = client.execute(method);
            // 返回状态码200，则访问接口成功
            if (response.getStatusLine().getStatusCode() == 200)
            {
                result = EntityUtils.toString(response.getEntity());
            }
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}