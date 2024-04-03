package com.ekan.domain.beneficiario;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarioSimpleDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    @NotEmpty(message = "O campo [Nome] deve ser preenchido.")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("dataNascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo [Data-Nascimento] deve ser preenchido.")
    private LocalDate dataNascimento;

    @JsonProperty("dataAtualizacao")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dataAtualizacao;

    @JsonProperty("dataInclusao")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dataInclusao;
}
