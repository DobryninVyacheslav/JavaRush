package ru.lvl19.lecture11.task6;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Xml {
    public static void main(String[] args) {
        System.out.println(sendGet());
    }

    private  static String sendGet() {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials("v.dobrynin", "ZaX9MQgwQp");
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();

            HttpResponse response = client.execute(
                    new HttpGet("http://wnc.ruselprom.local/Windchill/servlet/WindchillGW/" +
                            "wt.fv.master.StandardMasterService/doDirectDownload/00281746_drw.pdf?" +
                            "folderId=84477713&amp&ft=FF&amp&userid=54086371&amp&adId=86563643&amp&" +
                            "fileName=0000000043ec19&amp&refsize=50473&amp&mime=application/pdf&amp&" +
                            "mk=wt.fv.master.StandardMasterService&amp&ofn=00281746_drw.pdf&amp&c=1&" +
                            "amp&riid=-1&amp&sT=1595829808&amp&sign=ras%2FKMCs1qcUgNjVwaXIrg%3D%3D&amp&" +
                            "site=http%3A%2F%2Fwnc.ruselprom.local%2FWindchill%2Fservlet%2FWindchillGW&amp&" +
                            "AUTH_CODE=HmacMD5&amp&isProxy=true"));
            int statusCode = response.getStatusLine()
                    .getStatusCode();
            return String.valueOf(statusCode);
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
//    private static String getStringValue(InputStream stream) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
//        while (reader.ready()) {
//            sb.append(reader.readLine()).append("\n");
//        }
//
//        return sb.toString();
//    }
}
