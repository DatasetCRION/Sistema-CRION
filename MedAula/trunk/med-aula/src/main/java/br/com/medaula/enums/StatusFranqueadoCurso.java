package br.com.medaula.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;


public enum StatusFranqueadoCurso {

	S,I,N;
	
	
	private static Map<String, StatusFranqueadoCurso> namesMap = new HashMap<String, StatusFranqueadoCurso>(3);

    static {
        namesMap.put("Solicitado", S);
        namesMap.put("Inscrito", I);
        namesMap.put("Reprovado", N);
    }
    
    @JsonCreator
    public static StatusFranqueadoCurso forValue(String value) {
        return namesMap.get(value);
    }
	
    @JsonValue
    public String toValue() {
        for (Entry<String, StatusFranqueadoCurso> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null; // or fail
    }
	
}
