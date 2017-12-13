/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


/**
 *
 * @author vsawg
 */

public class Tweet {
    
 //("INSERT INTO `tweet`(`id`, `id_tweet`, `name`, `id_usuario`, `Text`, `Lat`, `Lng`) VALUES (null,?,?,?,?,?,?)");
    
    private Integer id;
    private String id_tweet;
    private String name;
    private Long id_usuario;
    private String ProfileLocal;
    private String text;
    private double lat;
    private double lng;
    
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //--
    public String getid_tweet() {
        return id_tweet;
    }
    public void setid_tweet(String id_tweet) {
        this.id_tweet = id_tweet;
    }
    //--
      public String getUser() {
        return name;
    } 
    public void setUser(String name) {
        this.name = name;
    }
    //--
    public Long getid_usuario() {
        return id_usuario;
    }
    public void setid_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    //--
    public String getProfileLocal() {
        return ProfileLocal;
    }
    public void setProfileLocal(String ProfileLocal) {
        this.ProfileLocal = ProfileLocal;
    }
    //--
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    //--
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    //--
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
}
