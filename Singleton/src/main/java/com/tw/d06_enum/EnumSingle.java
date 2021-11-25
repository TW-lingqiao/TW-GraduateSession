package com.tw.d06_enum;

/**
 * enum：本身也是一个类（jdk1.5）,自带单例
 *
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
