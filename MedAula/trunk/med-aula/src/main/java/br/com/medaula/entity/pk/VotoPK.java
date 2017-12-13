package br.com.medaula.entity.pk;

import br.com.medaula.entity.Tweet;
import br.com.medaula.entity.Usuario;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VotoPK implements Serializable {

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

    private static final long serialVersionUID = -2020055232989635004L;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tweet")
    private Tweet tweet;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsuario() == null) ? 0 : getUsuario().hashCode());
        result = prime * result + ((getTweet() == null) ? 0 : getTweet().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        VotoPK other = (VotoPK) obj;
        if (getUsuario() == null) {
            if (other.getUsuario() != null) {
                return false;
            }
        } else if (!usuario.equals(other.usuario)) {
            return false;
        }
        if (getTweet() == null) {
            if (other.getTweet() != null) {
                return false;
            }
        } else if (!tweet.equals(other.tweet)) {
            return false;
        }
        return true;
    }

}
