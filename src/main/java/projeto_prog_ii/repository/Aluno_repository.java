package projeto_prog_ii.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import projeto_prog_ii.model.Aluno;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Aluno_repository {
    private final File file = new File("alunos.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Aluno> loadAlunos() {
        try {
            if (!file.exists()) {
                return new ArrayList<>();
            }
                return objectMapper.readValue(file, new TypeReference<List<Aluno>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void salvar(List<Aluno> alunos) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, alunos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}