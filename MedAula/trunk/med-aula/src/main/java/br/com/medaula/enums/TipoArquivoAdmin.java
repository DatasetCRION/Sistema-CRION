package br.com.medaula.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;


public enum TipoArquivoAdmin {

	M,C;
	
	
	private static Map<String, TipoArquivoAdmin> namesMap = new HashMap<String, TipoArquivoAdmin>(3);

    static {
        namesMap.put("Manual", M);
        namesMap.put("Catálogo", C);
    }
    
    @JsonCreator
    public static TipoArquivoAdmin forValue(String value) {
        return namesMap.get(value);
    }
	
    @JsonValue
    public String toValue() {
        for (Entry<String, TipoArquivoAdmin> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null; // or fail
    }
	
}
