package com.github.ibronsveld.hippo.angular.behaviors;

import com.github.ibronsveld.hippo.angular.AngularPluginContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hippoecm.frontend.session.UserSession;

public class PluginResponse {

    protected String responseBody;
    protected int resultCode;

    public PluginResponse() {
        resultCode = 200;
    }

    public void addResponseBody(String contents) {
        responseBody = contents;
    }

    public void addResponseBody(Object o) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(o);

        this.addResponseBody(json);
    }

    public void setError(int code, String message) {
        responseBody = message;
        resultCode = code;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public int getResultCode() {
        return resultCode;
    }
}
