package br.com.medaula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.medaula.entity.base.BaseEntityImpl;

@Entity
@Table(name = "tweet")
public class Tweet extends BaseEntityImpl<Tweet> {

    private static final long serialVersionUID = -90563202302656760L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_tweet")
    private String nametwet;
    
    @Column(name = "name")
    private String name;

    @Column(name = "id_usuario")
    private String idusuario;
    
    @Column(name = "ProfileLocation")
    private String profileLocation;
    
    @Column(name = "Text")
    private String text;

    @Column(name = "Lat")
    private double lat;

    @Column(name = "Lng")
    private double lng;
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nametwet
     */
    public String getNametwet() {
        return nametwet;
    }

    /**
     * @param nametwet the nametwet to set
     */
    public void setNametwet(String nametwet) {
        this.nametwet = nametwet;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the idusuario
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the profileLocation
     */
    public String getProfileLocation() {
        return profileLocation;
    }

    /**
     * @param profileLocation the profileLocation to set
     */
    public void setProfileLocation(String profileLocation) {
        this.profileLocation = profileLocation;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    

    
}
