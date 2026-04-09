package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.models.Participante;
import br.com.ucsal.olimpiadas.repository.ParticipanteRepository;

public class ParticipanteService {
    private static ParticipanteRepository db = new ParticipanteRepository();
    private static long proximoParticipanteId = 1;


    public void cadastrarParticipante(String nome, String email) {
        if (nome == null || nome.isBlank()) {
            System.out.println("nome inválido");
            return;
        }

        var p = new Participante();
        p.setId(proximoParticipanteId++);
        p.setNome(nome);
        p.setEmail(email);

        db.salvar(p);
        System.out.println("Participante cadastrado: " + p.getId());
    }
}
