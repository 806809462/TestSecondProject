package com.qidong.myapplication.adapter;

import java.util.ArrayList;

public interface MultiTypeSupportImp<T> {
    /**
     * 根据position对应的数据 判断返回对应的具体item的类型
     */
    int getViewItemType(ArrayList<T> datas, int position);

    /**
     * 根据不同的类型返回不同布局id
     */
    int getLayoutId(int viewType);
}
