package segundoteste;

import java.util.ArrayList;
import java.util.List;

public class Segundo {
    private int nextId = 0;
    private List<Candidato> candidatos = new ArrayList<>();

    public static void main(String[] args) {
        Segundo segundo = new Segundo();
    }

    public int iniciarProcesso(String nome) {
        // if (nome == null || nome.isEmpty()) {
        // System.out.println("Cadidato Não encontrado");
        // }
        for (Candidato candidato : candidatos) {
            if (candidatoParticipaDoProcesso(candidato.getNome())) {
                throw new IllegalArgumentException("Candidato já participa do processo");
            }
        }
        int id = nextId++;
        Candidato candidato = new Candidato(id, nome, "Recebido");
        candidatos.add(candidato);
        return id;
    }

    public void marcarEntrevista(int codCandidato) {
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato == null) {
            throw new IllegalAccessError("Candidato não ncontrado");
        }
        candidato.setStatus("Qualificado");

    }

    public void desqualificarCandidato(int codCandidato) {
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato == null) {
            throw new IllegalArgumentException("Candidato não encontrado");
        }
        candidatos.remove(codCandidato);
    }

    public String verificarStatusCandidato(int codCandidato) {
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato == null) {
            throw new IllegalArgumentException("Candidato não encontrado");
        }
        if (candidatoParticipaDoProcesso(candidato.getNome())) {
            throw new IllegalArgumentException("Candidato já participa do processo");
        }
        return candidato.getStatus();
    }

    public void aprovarCandidato(int codCandidato) {
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato == null) {
            throw new IllegalArgumentException("Candidato não encontrado");

        }
        candidato.setStatus("Aprovado");
    }

    public List<String> obterAprovados() {
        List<String> cadidatosAprovados = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if (candidato.getStatus().equals("Aprovado")) {
                cadidatosAprovados.add(candidato.getNome());
            }
        }
        return cadidatosAprovados;
    }

    public boolean candidatoParticipaDoProcesso(String nome) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public class Candidato {
        private int id;
        private String nome;
        private String status;

        public Candidato(int id, String nome, String status) {
            this.id = id;
            this.nome = nome;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
