package proxy;

import java.util.List;

public class SeguradoProxy implements ISegurado {

    private Segurado segurado;

    private Integer codigo;

    public SeguradoProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.segurado == null) {
            this.segurado = new Segurado(this.codigo);
        }
        return this.segurado.obterDadosPessoais();
    }

    @Override
    public List<Float> obterValoresSinistros(Funcionario funcionario) {
        if (!funcionario.isAutorizado()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.segurado == null) {
            this.segurado = new Segurado(this.codigo);
        }
        return this.segurado.obterValoresSinistros(funcionario);
    }
}
