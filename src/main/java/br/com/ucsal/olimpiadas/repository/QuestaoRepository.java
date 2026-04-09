package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.models.Participante;
import br.com.ucsal.olimpiadas.models.Questao;

import java.util.ArrayList;
import java.util.List;

public class QuestaoRepository {
    private final List<Questao> Questoes = new ArrayList<>();

    public void salvar(Questao p) {
        Questoes.add(p);
    }

    public List<Questao> listar() {
        return Questoes;
    }
}
