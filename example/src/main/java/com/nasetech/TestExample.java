package com.nasetech;

import com.nasetech.request.GetManageListRequest;
import com.nasetech.sdk.NaSetechClient;
import com.nasetech.sdk.impl.NaSetechClientImpl;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lipingan
 * @date 2021/06/17
 */

public class TestExample {
    public static void main(String[] args) {
        NaSetechClient naSetechClient = new NaSetechClientImpl(TestConst.URL, TestConst.appId, TestConst.appSecret);

        GetManageListRequest getManageListRequest = new GetManageListRequest();
        getManageListRequest.setLimit("10");
        getManageListRequest.setSkip("0");
        ArrayList<String> metas = new ArrayList<String>();
        metas.add("MZId");
        getManageListRequest.setMetas(metas);
        ArrayList<String> status = new ArrayList<String>();
        status.add("publish");
        status.add("stopSelling");
        status.add("draft");
        getManageListRequest.setStatus(status);
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("演出");
        getManageListRequest.setCategories(categories);
        getManageListRequest.setCateIsAlias(true);

        ResponseBody execute = naSetechClient.execute(getManageListRequest);
        try {
            if (execute != null) {
                System.out.println(execute.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
