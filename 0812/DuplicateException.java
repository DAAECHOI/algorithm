package com.ssafy.java.d0812.hw;

public class DuplicateException extends Exception{
    public DuplicateException(int no) {
        super(no + "은/는 이미 존재하는 상품입니다.");
    }
}
