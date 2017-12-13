/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasettwitter;

import java.io.IOException;
import java.util.List;
import jdk.nashorn.internal.objects.NativeDate;
import model.DAO.TweetDAO;
import model.bean.Tweet;
import model.tdidf.ContaVoto;
import model.tdidf.MatrizConfusao;
import model.tdidf.TFIDFCalculator;
import model.tdidf.TweetFrequencia;
import twitter4j.FilterQuery;
import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author vsawg
 */
public class DataSetTwitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException, IOException  {

        Tweet t = new Tweet();
        TweetDAO dao = new TweetDAO();
//        //Chamada para remover Stopword e criar banco sem stopword
//        TweetFrequencia freq = new TweetFrequencia();
//        freq.readTweet();
//        
//        //Chamada para TF IDF
//        TFIDFCalculator doc = new TFIDFCalculator();
//        doc.CreateDoc();
//        doc.CalculaTweet();
        
        
        
//        //Cria DOC votação
//        ContaVoto contador = new ContaVoto();
//        contador.contarVotos();
//
        //Método matriz de confusão
        MatrizConfusao matriz = new MatrizConfusao();
        matriz.ResultadoMatrizConfusao();


//////        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
//////        configurationBuilder.setDaemonEnabled(true)
//////                .setOAuthConsumerKey("h6rh8m7wVey64Qw2AYajrBuKD")
//////                .setOAuthConsumerSecret("Clb8KEuPOikwNT2WCYL9dFtGjmQbvjHkLlDXNbcz68T6uKIlml")
//////                .setOAuthAccessToken("58221406-a9MRE718Keg2PThjC47xzo4UodoBrC3HzMxRKzUyt")
//////                .setOAuthAccessTokenSecret("Hw4Ud1MqW8tTW9qINrrnpoIj6U6elefF1vFW9t4Pc6dcb");
//////       
//////         TwitterStream twitterStream = new    TwitterStreamFactory(configurationBuilder.build()).getInstance();
//////   
//////        //Classe Listener
//////        StatusListener listener = new StatusListener(){
//////            @Override
//////            public void onStatus(Status status) {
//////            User user = status.getUser(); 
//////            //NAME TWITTER
//////            String nameTwiter = status.getUser() .getScreenName();
////////            System.out.println("\n @" + nameTwiter);
//////            //USERNAME
//////            String username = status.getUser().getName(); 
////////            System.out.println("\n USER: " + username);
//////            //LOCAL PROFILE
//////            String profileLocation = user.getLocation();
//////            if(profileLocation.equals(null))
//////               profileLocation = "null"; 
////////            System.out.println("\nLOCATION: " + profileLocation);
//////            //TWEET ID
//////            long tweetId = status.getId();
////////            System.out.println("\nTweet ID: " + tweetId);
//////            //TEXT
//////            String content = status.getText();
////////            System.out.println("\nText: " + content +"\n");   
//////            //Gets Georreference
//////            /*
//////            double geolatitude = status.getGeoLocation() .getLatitude(); 
//////            System.out.println("\nLongidute: " + geolatitude);
//////            double geolongitude = status.getGeoLocation() .getLongitude();
//////            System.out.println("\nLatitude: " + geolongitude);*/
//////            
////////            GeoLocation teste = status.getGeoLocation();            
//////            
//////            t.setid_tweet("@"+nameTwiter);
//////            t.setUser(username);
//////            t.setid_usuario(tweetId);
//////            t.setProfileLocal(profileLocation);
//////            t.setText(content);
//////            t.setLat(0);
//////            t.setLng(0);        
//////            dao.create(t);
//////            
//////            
////////            System.out.println("\nGEOLOCAL: " + teste +"\n -----------------------------------");
//////}
//////
//////            @Override
//////            public void onDeletionNotice(StatusDeletionNotice sdn) {
//////               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//////            }
//////
//////            @Override
//////            public void onTrackLimitationNotice(int i) {
//////                System.out.println(">>>>>Got track limitation notice:" + i);            
//////            }
//////
//////            @Override
//////            public void onScrubGeo(long l, long l1) {
//////               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//////            }
//////
//////            @Override
//////            public void onStallWarning(StallWarning sw) {
//////                      System.out.println("onStallWarning" +"\n");
//////            }
//////
//////            @Override
//////            public void onException(Exception excptn) {
//////                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//////            }
//////        }; 
//////        
//////        twitterStream.addListener(listener);
//////        
//////        double lat = -19.8890751;
//////        double longitude = -43.9886602;
//////        double lat1 = lat - 0.2;
//////        double longitude1 =
//////                longitude - 0.2;
//////        double lat2 = lat + 0.2;
//////        double longitude2 = longitude + 0.2;
//////
//////        double[][] bb = {{longitude1, lat1}, {longitude2, lat2}};
//////
//////        FilterQuery fq = new FilterQuery();
//////        //fq.locations(bb);
//////        fq.track(new String[]{"arma", "assalto", "assaltantes", "assassinado","homicidios","golpes","sequestrada","assassinatos","pedofilos","assalta","estupro","roubos",
//////            "arrastao","assassinada", "pedofilo", "pedofilia", "preto", "tiroteio", "apologia", "crime", "viado", "bicha", "corno"}); // OR on keywords
//////        fq.language(new String[]{"pt"});
//////        
//////
//////        twitterStream.filter(fq); 
        
         
//        for(Status s:status){    
//            if(s.getText().contains("Robinho") || s.getText().contains("Verstappen")  ){
//            System.out.println("\n ("+ sequence + ") USER:"+s.getUser() .getName() +"\n LOCATION:"+  s.getGeoLocation() +"\n TEXT:"+ s.getText() /*s.getGeoLocation() .getLatitude() +"   "+ s.getGeoLocation() .getLongitude()*/);
//            sequence++;}
//            
//            t.setId(sequence++);
//            t.setUser(s.getUser() .getName());
//            t.setText(s.getText());         
//            //t.setLat(s.getGeoLocation() .getLatitude());
//            t.setLat(0);
//            //t.setLng(s.getGeoLocation() .getLongitude());
//            t.setLng(0);
//            
//            dao.create(t);
//        }

     
        
    }
        
}
