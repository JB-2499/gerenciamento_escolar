package projeto_prog_ii.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //gera o construtor normalmente
@NoArgsConstructor //gera o construtor vazio
@Entity
@Table (name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantiaAluno;
    //Tipo de relacionamento com a classe professor
    @ManyToMany
    @JoinTable(
            name = "turma_professor",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores;
    //Tipo de relacionamento com a classe aluno
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
}
