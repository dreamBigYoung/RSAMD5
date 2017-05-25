package com.example.bigyoung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bigyoung.myapplication.utils.MD5Utils;
import com.example.bigyoung.myapplication.utils.RSAUtils;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int j=0;
        int jj;
        int hh;
        System.out.println(MD5Utils.md5("jack rose"));
        //继续主干上的开发
        //it is branch one
        //修复版本1的bug
        //再一次在主线上开发
        //继续修复bug
        RSAUtils rsa=new RSAUtils();
        String name="jackson";
        try {
            RSAPublicKey rsaPublicKey = rsa.getRSAPublicKey();
            RSAPrivateKey rsaPrivateKey = rsa.getRSAPrivateKey();
            byte[] encrypt = rsa.encrypt(rsaPublicKey, name.getBytes());
            System.out.println(new String(encrypt,"UTF-8"));
            byte[] decrypt = rsa.decrypt(rsaPrivateKey, encrypt);
            System.out.println(new String(decrypt,"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
