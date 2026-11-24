package proxy;

import java.util.List;

public interface ISegurado {
    List<String> obterDadosPessoais();
    List<Float> obterValoresSinistros(Funcionario funcionario);
}
