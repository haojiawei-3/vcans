package com.vcans.tool;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.security.*;  
import javax.crypto.Cipher;  
import javax.crypto.CipherInputStream;  
import javax.crypto.CipherOutputStream;  
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESKeySpec;  
import android.util.Base64;
  
public class DESTool {  
    // a weak key  
  
    private static String encoding = "GBK";  
    //DES/ECB/NoPadding
    private final static String CIPHER_ALGORITHM = "DES/ECB/NoPadding";  

    private String sKey = "";  
    
    static DESTool desTool=new DESTool("vcans@58");
  
  
    public DESTool(String sKey) {  
        this.sKey = sKey;  
    }  
      
     public static byte[] encrypto(byte[] sendData)
    {
    	//des����
		byte[] desByte=new byte[1];
		try {
			desByte = desTool.symmetricEncrypto(sendData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    	return desByte;
    }
	    
     public static byte[] decrypto(byte[] receData)
    {
    	//des����
		byte[] desByte=new byte[1];
		try {
			desByte = desTool.symmetricDecrypto(receData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    	return desByte;
    }
    
  
    /** 
     * �����ַ��� 
     */  
    public static String ebotongEncrypto(String str) {  
        String result = str;  
        if (str != null && str.length() > 0) {  
            try {  
                byte[] encodeByte = desTool.symmetricEncrypto(str.getBytes(encoding));  
                result =new String(Base64.encode(encodeByte, 0),encoding);  
  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
    /** 
     * �����ַ��� 
     */  
    public static String ebotongDecrypto(String str) {  
        String result = str;  
        if (str != null && str.length() > 0) {  
            try {  
                byte[] encodeByte = Base64.decode(str, 0);  
  
                byte[] decoder = desTool.symmetricDecrypto(encodeByte);  
                result = new String(decoder, encoding);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
  
    /** 
     * ����byte[] 
     */  
    public byte[] ebotongEncrypto(byte[] str) {  
        byte[] result = null;  
        if (str != null && str.length > 0) {  
            try {  
                byte[] encodeByte = symmetricEncrypto(str);  
                result = Base64.encode(encodeByte, 0);  
  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
    /** 
     * ����byte[] 
     */  
    public byte[] ebotongDecrypto(byte[] str) {  
        byte[] result = null;  
        if (str != null && str.length > 0) {  
            try {  
  
                byte[] encodeByte = Base64.decode(new String(str, encoding), 0);  
                //byte[] encodeByte = base64decoder.decodeBuffer(new String(str));  
                byte[] decoder = symmetricDecrypto(encodeByte);  
                result = new String(decoder).getBytes(encoding);  
               // result = new String(decoder).getBytes();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
  
    /** 
     * �ԳƼ����ֽ����鲢���� 
     * 
     * @param byteSource ��Ҫ���ܵ����� 
     * @return           �������ܵ����� 
     * @throws Exception 
     */  
    public byte[] symmetricEncrypto(byte[] byteSource) throws Exception {  
        try {  
            int mode = Cipher.ENCRYPT_MODE;  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            byte[] keyData = sKey.getBytes();  
            DESKeySpec keySpec = new DESKeySpec(keyData);  
            Key key = keyFactory.generateSecret(keySpec);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(mode, key);  
  
            byte[] result = cipher.doFinal(byteSource);  
            return result;  
        } catch (Exception e) {  
            throw e;  
        } finally {  
        }  
    }  
  
    /** 
     * �Գƽ����ֽ����鲢���� 
     * 
     * @param byteSource ��Ҫ���ܵ����� 
     * @return           �������ܵ����� 
     * @throws Exception 
     */  
    public byte[] symmetricDecrypto(byte[] byteSource) throws Exception {  
        try {  
            int mode = Cipher.DECRYPT_MODE;  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES"); 
            byte[] keyData = sKey.getBytes();  
            DESKeySpec keySpec = new DESKeySpec(keyData);  
            Key key = keyFactory.generateSecret(keySpec);  
            //Cipher cipher = Cipher.getInstance("DES"); //javaĬ�� 
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);//ƥ��c++  
            cipher.init(mode, key);  
            byte[] result = cipher.doFinal(byteSource);  
            return result;  
        } catch (Exception e) {  
            throw e;  
        } finally {  
  
        }  
    }  
  
    /** 
     * ɢ���㷨 
     * 
     * @param byteSource 
     *            ��Ҫɢ�м�������� 
     * @return ����ɢ�м�������� 
     * @throws Exception 
     */  
    public static byte[] hashMethod(byte[] byteSource) throws Exception {  
        try {  
            MessageDigest currentAlgorithm = MessageDigest.getInstance("SHA-1");  
            currentAlgorithm.reset();  
            currentAlgorithm.update(byteSource);  
            return currentAlgorithm.digest();  
        } catch (Exception e) {  
            throw e;  
        }  
    }  
  
  
    /** 
     * ���ļ�srcFile���м���������ļ�distFile 
     * @param srcFile �����ļ� 
     * @param distFile ���ܺ���ļ� 
     * @throws Exception 
     */  
    public void EncryptFile(String srcFile,String distFile) throws Exception{  
  
        InputStream  is=null;  
        OutputStream out  = null;  
        CipherInputStream cis =null;  
        try {  
            int mode = Cipher.ENCRYPT_MODE;  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            byte[] keyData = sKey.getBytes();  
            DESKeySpec keySpec = new DESKeySpec(keyData);  
            Key key = keyFactory.generateSecret(keySpec);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(mode, key);  
            is= new FileInputStream(srcFile);  
            out  = new FileOutputStream(distFile);  
            cis = new CipherInputStream(is,cipher);  
            byte[] buffer = new byte[1024];  
            int r;  
            while((r=cis.read(buffer))>0){  
                out.write(buffer, 0, r);  
            }  
        } catch (Exception e) {  
            throw e;  
        } finally {  
            cis.close();  
            is.close();  
            out.close();  
        }  
    }  
  
    /** 
     * �����ļ�srcFile��Ŀ���ļ�distFile 
     * @param srcFile �����ļ� 
     * @param distFile ���ܺ���ļ� 
     * @throws Exception 
     */  
    public void DecryptFile(String srcFile,String distFile) throws Exception{  
  
        InputStream  is=null;  
        OutputStream out  = null;  
        CipherOutputStream cos =null;  
        try {  
            int mode = Cipher.DECRYPT_MODE;  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            byte[] keyData = sKey.getBytes();  
            DESKeySpec keySpec = new DESKeySpec(keyData);  
            Key key = keyFactory.generateSecret(keySpec);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(mode, key);  
            byte[] buffer = new byte[1024];  
            is= new FileInputStream(srcFile);  
            out  = new FileOutputStream(distFile);  
            cos = new CipherOutputStream(out,cipher);  
  
            int r;  
            while((r=is.read(buffer))>=0){  
                cos.write(buffer, 0, r);  
            }  
  
        } catch (Exception e) {  
            throw e;  
        } finally {  
            cos.close();  
            is.close();  
            out.close();  
        }  
    }  
  
  
    /** 
     * ���ļ����м���64λ���� 
     * @param srcFile Դ�ļ� 
     * @param distFile Ŀ���ļ� 
     */  
    public void  BASE64EncoderFile(String srcFile,String distFile){  
        InputStream inputStream =null;  
        OutputStream out  = null;  
        try {  
            inputStream = new FileInputStream(srcFile);  
  
            out  = new FileOutputStream(distFile);  
            byte[] buffer = new byte[1024];  
            while(inputStream.read(buffer)>0){  
                out.write(ebotongEncrypto(buffer));  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            try {  
                out.close();  
                inputStream.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
  
        }  
  
  
    }  
  
    /** 
     * ���ļ����н���64λ���� 
     * @param srcFile Դ�ļ� 
     * @param distFile Ŀ���ļ� 
     */  
    public void BASE64DecoderFile(String srcFile,String distFile){  
        InputStream inputStream =null;  
        OutputStream out  = null;  
        try {  
            inputStream = new FileInputStream(srcFile);  
  
            out  = new FileOutputStream(distFile);  
            byte[] buffer = new byte[1412];  
  
            while(inputStream.read(buffer)>0){  
                out.write(ebotongDecrypto(buffer));  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            try {  
                out.close();  
                inputStream.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
  
        }  
    }  
  
}  
