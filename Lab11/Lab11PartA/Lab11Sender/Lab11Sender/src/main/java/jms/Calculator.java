package jms;

public class Calculator {
private int num;
private String operator;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Calculator(int num, String operator) {
        this.num = num;
        this.operator = operator;
    }
}
