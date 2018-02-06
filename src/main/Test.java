package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) throws IOException {
        String urlName = "https://user.qzone.qq.com/491251735/311";
        URL url = new URL(urlName);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36");
        connection.setRequestProperty("cookie","pgv_pvi=4352822272; RK=lV41gaRQUE; ptcz=eadf614914d1d57e9f116ebc40984a35c49a8871151adbc4164edbc9a9e5bd8b; pgv_pvid=3089184839; pac_uid=1_491251735; _ga=GA1.2.882266364.1517475193; _qpsvr_localtk=0.6493751980103146; pgv_si=s1986647040; pgv_info=ssid=s4470880467; Loading=Yes; qz_screen=1366x768; 3255057511_todaycount=0; 3255057511_totalcount=0; QZ_FE_WEBP_SUPPORT=1; __Q_w_s__QZN_TodoMsgCnt=1; ptisp=cnc; cpu_performance_v8=11; ptui_loginuin=491251735; pt2gguin=o0491251735; uin=o0491251735; skey=@KUaU7elWM; p_uin=o0491251735; pt4_token=3w3SF2R3Ezmff7uBCYG2F0w8aZW4rFTN1s2nSiWWCRg_; p_skey=Zqv2jgsQSpz5XA9WBwp8W3L4Re8DnRNDoj4b5jTIesg_; __Q_w_s_hat_seed=1");
        String encoding = connection.getContentEncoding();
        if(encoding == null) encoding = "UTF-8";
        StringBuilder result = new StringBuilder();
        try(Scanner in = new Scanner(connection.getInputStream(),encoding))
        {
           while (in.hasNextLine()){
               result.append(in.nextLine());
               result.append("\n");
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter("QzoneShuoShuo1.html",encoding);
        out.println(result);
    }
}
