package proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Segurado> segurados = new HashMap<>();

    public static Segurado getSegurado(Integer codigo) {
        return segurados.get(codigo);
    }

    public static void addSegurado(Segurado segurado) {
        segurados.put(segurado.getCodigo(), segurado);
    }
}
