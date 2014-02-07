package web.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by davliatov on 07.02.14.
 */
public enum Crawler {

    INSTANCE;

    public static void main(String[] args) {
//        Crawler.INSTANCE.run("http://championat.com/");
        try {
            Crawler.INSTANCE.jsoup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run(String initial) {
        try {
            URL my_url = new URL(initial);
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                System.out.println(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void jsoup() throws IOException {
//        String html = "<html><head><title>First parse</title></head>"
//                + "<body><p>Parsed HTML into a doc.</p></body></html>";
//        Document doc = Jsoup.parse(html);
//        Document doc = Jsoup.parse("http://championat.com/");

        //http://jsoup.org/cookbook/input/load-document-from-url
        Document doc = Jsoup.connect("http://championat.com/").get();
        Element link = doc.select("a").first();
        System.out.println(link == null);
        if (link != null) {
            String linkHref = link.attr("href");
            System.out.println(linkHref);
        }
        else {
            System.out.println("Oops");
        }
    }
}

