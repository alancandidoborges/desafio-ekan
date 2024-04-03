package com.ekan.domain.documento;

import com.ekan.domain.beneficiario.Beneficiario;
import com.ekan.domain.beneficiario.BeneficiarioDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentoDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("tipoDocumento")
    @NotEmpty(message = "O campo [Tipo-Documento] deve ser preenchido.")
    private String tipoDocumento;

    @JsonProperty("descricao")
    @NotEmpty(message = "O campo [Descrição] deve ser preenchido.")
    private String descricao;

    @JsonProperty("dataAtualizacao")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dataAtualizacao;

    @JsonProperty("dataInclusao")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dataInclusao;

    @JsonIgnore
    private BeneficiarioDto beneficiario;
}
