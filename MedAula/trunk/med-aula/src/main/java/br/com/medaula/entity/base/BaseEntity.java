package br.com.medaula.entity.base;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public interface BaseEntity<E> extends Serializable, Cloneable {

}
