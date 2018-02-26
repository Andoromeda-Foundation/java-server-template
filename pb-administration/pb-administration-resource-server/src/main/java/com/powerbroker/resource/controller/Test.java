package com.powerbroker.resource.controller;

/**
 * @author william
 */
public class Test {
    int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};    //十七位数字本体码权重
    char[] validate = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};    //mod11,对应校验码字符值

    public char getValidateCode(String id17) {
        int sum = 0;
        int mode = 0;
        for (int i = 0; i < id17.length(); i++) {
            sum = sum + Integer.parseInt(String.valueOf(id17.charAt(i))) * weight[i];
        }
        mode = sum % 11;
        return validate[mode];
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("该身份证验证码：" + test.getValidateCode("31010819840330008"));    //该身份证校验码：3
    }
}
