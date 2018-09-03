package util;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
	public static void setEncoding(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		//�������ǰ̨����������������
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
	}
	
	
	   
    /** 
     * ���ַ���md5����(��д+����) 
     * 
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
      
    public static String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {  
            byte[] btInput = s.getBytes();  
            // ���MD5ժҪ�㷨�� MessageDigest ����  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // ʹ��ָ�����ֽڸ���ժҪ  
            mdInst.update(btInput);  
            // �������  
            byte[] md = mdInst.digest();  
            // ������ת����ʮ�����Ƶ��ַ�����ʽ  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  

}
