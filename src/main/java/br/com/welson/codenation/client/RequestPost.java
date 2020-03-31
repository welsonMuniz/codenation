package br.com.welson.codenation.client;

import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RequestPost {

	 public void postJson(String url, String file) throws Exception {

         CloseableHttpClient httpclient = HttpClients.createDefault();
         try {
            HttpPost post = new HttpPost(url);
            FileBody fileJson = new FileBody(new File(file));
            HttpEntity requestEntity = MultipartEntityBuilder.create().addPart("answer", fileJson).build();
            post.setEntity(requestEntity );
            CloseableHttpResponse response = httpclient.execute(post);
          try {
               System.out.println(response.getStatusLine());
               HttpEntity resEntity = response.getEntity();               
               if (resEntity != null) {
                    System.out.println(EntityUtils.toString(resEntity, "UTF-8"));              
               }
             EntityUtils.consume(resEntity);
            } finally {
                response.close();
           }
      } finally {
         httpclient.close();
     }
  }
}