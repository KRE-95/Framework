package Sdd.java.no.hiof.groupe5.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;


public class Webscrape {
    public static void main(String[] args) {
        // # 0.0 -> to scrape the given url, first we create a contianer called Document so it can store value , call it
        // store_url - stores the HTML contents of web page.
        String url = "https://www.nrk.no/";
        try {
            Document store_Url = Jsoup.connect(url).get();

           // 1.0  get info by element tag  span
            Elements get_Element_Span = store_Url.getElementsByTag("span");
            for (Element e: get_Element_Span) {
                System.out.println(e);
            }

            // 1.0  get info by element tag  flex
            Elements get_Element_Flex_box = store_Url.getElementsByTag("flex");
            for (Element e: get_Element_Flex_box) {
                System.out.println(e);
            }


            System.out.println("///////small - just text////////////");
            //# get info by element tag  for small (nrk is build as that) - just show text
            Elements small_h4 = store_Url.getElementsByTag("small");
            for (Element e: small_h4) {
                //System.out.println(e.text());
            }

            System.out.println("///////links inside of NRK - a ////////////");
            // # , when scraping links from Nrk we also want to know what does those link show. as external
            Elements show_External_a_links = store_Url.getElementsByTag("a");
            for (Element e: show_External_a_links) {
                //System.out.println("Link: " + e.attr("href"));
            }


            Elements a_links = store_Url.getElementsByTag("a");
            for (Element e: a_links) {
                System.out.println(e.text());

            }
            /**

             // get element by id , end with a structure and save inside of content, little more organized
             **/

            System.out.println();
            Element content = store_Url.getElementById("kur-room-id-729810");
            //System.out.println("Scraped structure of the given id stored as content:" + "\n" + content);


            /**
             more spesified on finding the scraped info "Derfor feirer vi samenes nasjonaldag", instead of using element by id, now we can use
             element by tag inside of the content . the information we have stored in content.
             just changing the name --> dive inside of the content, as text - end with the spesified information - Derfor feirer vi samenes nasjonaldag.
             ***/
            System.out.println();
            Element dive_content = store_Url.getElementById("kur-room-id-729810");

            assert dive_content != null;
            Elements text = dive_content.getElementsByTag("a");
            for (Element e: text
                 ) {
                System.out.println("spesified scrape info : " + e.text());
            }

            // get elemeent bu class - zoomed in level , we find the spesfied info without any date :




        } catch (IOException e) {
            e.printStackTrace();
        }


        // #2 given store_url from NRK , scrape all div elements and save them in a Json file
    }






}

