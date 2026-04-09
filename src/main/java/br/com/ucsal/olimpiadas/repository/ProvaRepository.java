package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.models.Participante;
import br.com.ucsal.olimpiadas.models.Prova;

import java.util.ArrayList;
import java.util.List;

public class ProvaRepository {
    private final List<Prova> Provas = new ArrayList<>();

    public void salvar(Prova p) {
        Provas.add(p);
    }

    public List<Prova> listar() {
        return Provas;
    }
}
