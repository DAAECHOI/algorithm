package com.ssafy.java.d0812.hw;

public class CodeNotFoundException extends Exception{

    public CodeNotFoundException(int no) {
        super(no + "은/는 존재하지 않는 상품입니다.");
    }
}
