import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.Console;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa9ya on 16.03.2017.
 */
public class Main {
    static String SITE_URL = "https://profzip.com/";
    private static final String url = "jdbc:mysql://acc00703.mysql.ukraine.com.ua/acc00703_parser";
    private static final String user = "acc00703_cf";
    private static final String password = "2dbt2g9v";
    static Document doc;
    static String[] a;
    public static List<String> allLinks = new ArrayList<String>();

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        /*try {
            doc = Jsoup.connect(SITE_URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select(".lcol ul:nth-child(4) li a");
        int i=0;
        a = new String[newsHeadlines.size()];
        for(Element cart : newsHeadlines) {
            String link = cart.attr("href");
            a[i] = "https://profzip.com/"+link;
            i++;
        }
        //System.out.println(a[1]);
        for(String pages : a) {
            try {
                doc = Jsoup.connect(pages).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements pag = doc.select(".pages a");
                if(doc.select(".pages").size() > 0) {
                    for(Element p : pag) {
                        String link = "https://profzip.com/"+p.attr("href");
                        //System.out.println(link);
                        allLinks.add(link);
                    }
                } else {
                    allLinks.add(pages);
                    //System.out.println(pages);
                }

        }
        for(String link : allLinks) {
            try {
                doc = Jsoup.connect(link).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements product = doc.select(".newCatalogLst .nProdDsc a");
            String productLink = SITE_URL+product.attr("href");
            System.out.println(productLink);
        }
        //System.out.println(allLinks.get(4));
        //String links = newsHeadlines.toString().substring(5,-1);

        String query = "SELECT * FROM oc_parser_s";
        String userid = null;
        String username = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userid = rs.getString("url");
                username = rs.getString("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
        /*
        doc = Jsoup.connect(SITE_URL).get();
        Elements newsHeadlines = doc.select(".lcol ul:nth-child(4) li a");
        for(Element cart : newsHeadlines) {
            String categoryName = cart.html();
            //Database.addCategory(categoryName);
            String linkcategory = cart.attr("href");
            //System.out.println(categoryName);
            linkcategory = "https://profzip.com/"+linkcategory;
            doc = Jsoup.connect(linkcategory).get();
            //System.out.println(link);
            Elements pag = doc.select(".pages a");
            if(doc.select(".pages").size() > 0) {
                for(Element p : pag) {
                    String linkpagin = "https://profzip.com/"+p.attr("href");
                    //System.out.println(linkpagin);
                    doc = Jsoup.connect(linkpagin).get();
                    Elements productLink = doc.select(".nProdDsc a");
                    for (Element product : productLink) {
                        String products = "https://profzip.com/"+product.attr("href");
                        Data.data(categoryName, products);
                        //System.out.println(categoryName+" "+products);
                    }
                }
            } else {
                Elements productLink = doc.select(".nProdDsc a");
                for (Element product : productLink) {
                    String products = "https://profzip.com/"+product.attr("href");
                    Data.data(categoryName, products);
                    //System.out.println(categoryName+" "+products);
                }
                //System.out.println(linkcategory);
            }
        }
        */
        Database.getCategory();
    }
}

/*
Наприклад в тебе є масив:
mas[0] = '<a href=""></a>';
mas[1] = '<a href=""></a>';
mas[2] = '<a href=""></a>';
mas[3] = '<a href=""></a>';
mas[4] = '<a href=""></a>';
mas[5] = '<a href=""></a>';
mas[6] = '<a href=""></a>';
Тобі потрібно добавити дані.
Для того щоб кудись добавити потрібно розбити кожен елемент масиву на ще два.
Там є метод split здається.
for(int i =0, a=mas.length(); i<=a; i++) {
    masNumber2 = mas[i].split('</a>');
    Потім добавляєш дані.
        mas[i] = masNumber2[0]+yourData+masNumber[1];
    І методом виводиш.
        System.out.println(mas[i]);
}
*/