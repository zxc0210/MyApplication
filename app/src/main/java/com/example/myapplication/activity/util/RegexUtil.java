package com.example.myapplication.activity.util;

public class RegexUtil {
    private  static  final String Float_REGEX="^-?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$";
    public  static  boolean isFloat(String value){return value.matches((Float_REGEX));}
}
