package main;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class Login {
    public static Map<String, String> cookies;
    public static void main(String args[])throws IOException{
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("resource/login.properties"))){
            props.load(in);
        }
//        System.out.println(System.getProperty("user.dir"));
        String uin = props.getProperty("username");
        String password = props.getProperty("password");
        String checkStatus = "";
        String verifycode = "";
        String verifysession = "";
        String p = "";
    }
    public static String login(String uin, String p, String checkStatus, String verifycode,
                               String verifysession) throws IOException {
        Connection connection = Jsoup.connect("https://ssl.ptlogin2.qq.com/login?"+
                    "u="+ uin +
                    "&verifycode="+ verifycode +
                    "&pt_vcode_v1="+ checkStatus +
                    "&pt_verifysession_v1="+ verifysession+
                    "&p="+ p +
                    "&pt_randsalt=2"+
                    "&pt_jstoken=3067081339"+
                    "&u1=https%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone"+
                    "&ptredirect=0" +
                    "&h=1"+
                    "&t=1"+
                    "&g=1"+
                    "&from_ui=1"+
                    "&ptlang=2052"+
                    "&action=2-6-1517471528789"+
                    "&js_ver=10233"+
                    "&js_type=1"+
                    "&login_sig=SRPb*QsJZY-3xP*ENVaKEPUOCAWLnhWkLyQZJFnrUp3nD1wDjNOMwez-C2f6Jz8L"+
                    "&pt_uistyle=40"+
                    "&aid=549000912"+
                    "&daid=5");
        connection.timeout(10000000);
        Connection.Response response = connection.execute();
        cookies = response.cookies();
        return response.body();


    }
}
