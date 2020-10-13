package com.ssafy.work;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String msg) {
        super(msg + "에 해당하는 상품이 존재하지 않습니다.");
    }
}
