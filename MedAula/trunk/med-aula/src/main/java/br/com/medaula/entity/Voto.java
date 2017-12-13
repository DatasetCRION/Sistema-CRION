package br.com.medaula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.medaula.entity.base.BaseEntityImpl;
import br.com.medaula.entity.pk.VotoPK;
import java.util.List;
import javax.persistence.EmbeddedId;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "votacao")
public class Voto extends BaseEntityImpl<Voto> {

    private static final long serialVersionUID = -90563202302656760L;

    @EmbeddedId
    private VotoPK idvoto;

    @ManyToOne
    @JoinColumn(name = "id_usuario",  insertable=false, updatable=false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tweet",  insertable=false, updatable=false)
    private Tweet tweet;

    @Column(name = "crime")
    private Long crime;

    @Column(name = "naocrime")
    private Long naocrime;

    @Column(name = "flag")
    private Long flag;

    /**
     * @return the crime
     */
    public Long getCrime() {
        return crime;
    }

    /**
     * @param crime the crime to set
     */
    public void setCrime(Long crime) {
        this.crime = crime;
    }

    /**
     * @return the naocrime
     */
    public Long getNaocrime() {
        return naocrime;
    }

    /**
     * @param naocrime the naocrime to set
     */
    public void setNaocrime(Long naocrime) {
        this.naocrime = naocrime;
    }

    /**
     * @return the flag
     */
    public Long getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(Long flag) {
        this.flag = flag;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tweet
     */
    public Tweet getTweet() {
        return tweet;
    }

    /**
     * @param tweet the tweet to set
     */
    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    /**
     * @return the idvoto
     */
    public VotoPK getIdvoto() {
        return idvoto;
    }

    /**
     * @param idvoto the idvoto to set
     */
    public void setIdvoto(VotoPK idvoto) {
        this.idvoto = idvoto;
    }

}
