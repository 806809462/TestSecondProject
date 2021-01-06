package com.qidong.myapplication.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qidong.myapplication.mode.UserMessage;

import java.lang.reflect.Type;
import java.util.List;

public class GsonUtil extends abGson{
    String Data = "{students:[{name:'小名',age:25},{name:'阿名',age:26}],classX:'大班'}";
    UserMessage gson = new Gson().fromJson(Data, UserMessage.class);


    Type type = new TypeToken<List<UserMessage>>() {
    }.getType();
    List<UserMessage> userMessages = new Gson().fromJson(Data, type);

    Gson gson1 = new Gson();

    @Override
    public void getuser() {

    }
}
