package com.smalldot.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.String.format;

@SpringBootTest
class SmalldotWebApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    @Test
    void contextLoads() throws InterruptedException, JSONException, FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(new File("F:\\workspace\\mywork\\small-dot-backend\\smalldot-web\\src\\test\\java\\com\\smalldot\\web\\a.json")));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()){
            sb.append(sc.nextLine());
        }
        String jsonString = sb.toString();
        JSONArray parse = JSONArray.parseArray(jsonString);
        for (Object o : parse) {
            JSONObject json = (JSONObject) o;
            //先关后开
            updateProd(json.getLong("prodId"), json.getString("prodName"),-1);
            updateProd(json.getLong("prodId"), json.getString("prodName"),1);
        }
    }

    private void updateProd(Long prodId, String prodName, int flg) {
        String url = format("https://ncpm.zhaopin.com/v9CrmCtrl/updateProdAttr?prodId=%s&prodName=%s&flg=%s&saleType=3&isCampus=0", prodId, prodName,flg);
        HttpHeaders headers = new HttpHeaders();
        String token = "5bbb779f-3072-4028-8345-162a8c55c3f6";
        headers.add("token", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        System.out.println(prodId+"/"+prodName+"/"+response.getBody());
    }

}
