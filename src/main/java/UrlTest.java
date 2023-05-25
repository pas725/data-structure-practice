import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by psagar on 3/10/2018.
 */
public class UrlTest {
    public static void main(String[] args) {
        URL aURL = null;
        try {
            aURL = new URL("https://www.linkedin.com/in/kiran-minnasandram-8616a76");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("protocol = " + aURL.getProtocol()); //http
        System.out.println("authority = " + aURL.getAuthority()); //example.com:80
        System.out.println("host = " + aURL.getHost()); //example.com
        System.out.println("port = " + aURL.getPort()); //80
        System.out.println("path = " + aURL.getPath()); //  /docs/books/tutorial/index.html
        System.out.println("query = " + aURL.getQuery()); //name=networking
        System.out.println("filename = " + aURL.getFile()); ///docs/books/tutorial/index.html?name=networking
        System.out.println("ref = " + aURL.toString()); //DOWNLOADING
    }
}
