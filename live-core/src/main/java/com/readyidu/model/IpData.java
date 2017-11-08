package com.readyidu.model;

/**
 * Created by 123 on 2017/10/28.
 */
public class IpData {
    private int firstNumber;
    private int secondNumber;
    private String operator;

    public IpData() {
    }

    public IpData(String ipAdress){
        String[] segment = ipAdress.split("\\.");
        this.firstNumber = Integer.valueOf(segment[0]);
        this.secondNumber = Integer.valueOf(segment[1]);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
