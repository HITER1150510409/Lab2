package com.ANT.Library.util;

public class ValidateUtils {
    /**
     * ��֤�����Ƿ�Ϊ��
     * @param data Ҫִ����֤������
     * @return ����Ϊ�շ���false,
     */
    public static boolean validateEmpty(String data){
        if (data == null || "".equals(data)){
            return false;
        }
        return true;
    }
}
