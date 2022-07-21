
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import sirius.scribe.L;
import sirius.scribe.Message;


public class Testiko {
    
    public static void main(String[] args) {
        String tildaUrl = "https://forms.tildacdn.com/payment/custom/ps352998";
        String reference = "";
        String amount = "";
        String order_status = "approved";
        String signature = crypt2(reference + "|approved").toUpperCase();
        String secretNotif = "Yigim2NotificationSecret";
        try {
            URL url = new URL(tildaUrl);
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("reference", reference);
            params.put("amount", amount);
            params.put("order_status", order_status);
            params.put("secret", secretNotif);
            params.put("signature", signature);
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0;) {
                sb.append((char) c);
            }

            System.out.println("Result:  " + sb.toString());
        } catch (IOException e) {
           L.write(Message.Type.Error, "  |- Message: %s", e.getMessage());
        }
    }
    
    private static String crypt2(String string) {
        try {
            MessageDigest digest
                    = MessageDigest.getInstance("MD5");
            digest.update(string.getBytes(Charset.forName("UTF-8")), 0, string.length());
            return String.format(
                    "%32s",
                    new BigInteger(1, digest.digest()).toString(16)
            ).replace(' ', '0');
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
