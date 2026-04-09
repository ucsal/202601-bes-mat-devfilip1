package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.models.Participante;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepository {
    private final List<Participante> participantes = new ArrayList<>();

    public void salvar(Participante p) {
        participantes.add(p);
    }

    public List<Participante> listar() {
        return participantes;
    }
}
