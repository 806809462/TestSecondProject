package com.qidong.myapplication.mode;

public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面

    public static INoodles createNoodle(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new GankouNoodles();
        }
        return new LzNoodles();
    }

}
