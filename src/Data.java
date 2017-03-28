import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.text.html.ListView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Data {

    static Document doc;
    static String name;
    static String productImg;
    static String DeVecchiGiuseppe;
    static String NovaRicambi;
    static List<String> data;

    public static /*String[]*/void data(String catname, String link) {
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        name = doc.select("body h2").first().html();
        //System.out.println(prodName);
        Elements productName = doc.select(".stndTbl tr");
        for (Element name : productName) {
            Elements sl = name.select("td");
            String gui = name.html();
            if (gui.contains("De Vecchi Giuseppe")) {
                int p = 0;
                for(Element s:sl) {
                    if(p==0) {
                        //System.out.println(s.html());
                    }
                    if(p==2) {
                        DeVecchiGiuseppe = s.html();
                    }
                    p++;
                }
            }
            if (gui.contains("Nuova Ricambi")) {
                int p = 0;
                for(Element s:sl) {
                    if(p==0) {
                        //System.out.println(s.html());
                    }
                    if(p==2) {
                        NovaRicambi = s.html();
                    }
                    p++;
                }
            }
            if(doc.select(".cp-imgrow-2 img").first() != null) {
                productImg = "https://profzip.com/" + doc.select(".cp-imgrow-2 img").first().attr("src");
            } else {
                productImg = null;
            }
            //return doc;
        }
        System.out.println(catname + " " + name + " " + DeVecchiGiuseppe + " " + NovaRicambi + " " + productImg);
        if(productImg != null) {
            loadImage(productImg);
        }
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private static Image loadImage(String imgURL) {
        try(InputStream in = new URL(imgURL).openStream()){
            Files.copy(in, Paths.get("C:\\Users\\sa9ya\\IdeaProjects\\Web_Parser\\img\\"+imgURL.substring(33,imgURL.length())));
        } catch (IOException e) {
        }
        return null;
    }
}