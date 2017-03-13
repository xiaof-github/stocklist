package com.risk.utils;

import com.risk.entity.StockEntity;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaof on 2017/2/3.
 */
public class StockHttpClient {
    private Logger log = LogManager.getLogger(StockHttpClient.class);

    public List<StockEntity> getStockList(String code){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseBody = "";
        String reqCode;
        if (code == null){
            reqCode = "sz000024";
        }else{
            reqCode = StockUtils.stockCode2req(code);
        }

        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("qt.gtimg.cn")
                    .setPath("/")
                    .setParameter("q", reqCode)
                    .build();
            HttpGet httpGet = new HttpGet(uri);
            System.out.println(httpGet.getURI());
            log.info(httpGet.getURI());
            System.out.println("Executing request " + httpGet.getRequestLine());
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            responseBody = httpclient.execute(httpGet, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            log.info(responseBody);
        } catch(Exception e){
            log.error(e.getMessage(), e);
        }

        List<StockEntity> entities = new ArrayList<StockEntity>();
        StockEntity entity = new StockEntity();
        entity.setResult(responseBody);
        entities.add(entity);
        return entities;
    }

}
