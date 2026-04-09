package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.models.Participante;
import br.com.ucsal.olimpiadas.models.Tentativa;

import java.util.ArrayList;
import java.util.List;

public class TentativaRepository {
    private final List<Tentativa> tentativas = new ArrayList<>();

    public void salvar(Tentativa p) {
        tentativas.add(p);
    }

    public List<Tentativa> listar() {
        return tentativas;
    }
}
