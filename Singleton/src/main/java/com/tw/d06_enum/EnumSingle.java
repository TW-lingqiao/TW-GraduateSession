package com.tw.d06_enum;

/**
 * enum：本身也是一个类（jdk1.5）,自带单例  ---反射不能破坏枚举
 */
public enum EnumSingle {

    INSTANCE;  //默认就是单例

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
