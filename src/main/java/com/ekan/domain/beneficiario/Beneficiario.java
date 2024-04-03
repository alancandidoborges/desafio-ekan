package com.ekan.domain.beneficiario;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ekan.domain.documento.Documento;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_beneficiario")
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome", nullable = false, length = 255, unique = true)
    private String nome;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "beneficiario")
    private List<Documento> documentos;
}
