package proxy;

import java.util.Arrays;
import java.util.List;

public class Segurado implements ISegurado {

    private Integer codigo;
    private String nome;
    private String cidade;
    private Float sinistro1;
    private Float sinistro2;

    public Segurado(int codigo) {
        this.codigo = codigo;
        Segurado objeto = BD.getSegurado(codigo);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.sinistro1 = objeto.sinistro1;
        this.sinistro2 = objeto.sinistro2;
    }

    public Segurado(Integer codigo, String nome, String cidade, Float sinistro1, Float sinistro2) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.sinistro1 = sinistro1;
        this.sinistro2 = sinistro2;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterValoresSinistros(Funcionario funcionario) {
        return Arrays.asList(this.sinistro1, this.sinistro2);
    }
}
