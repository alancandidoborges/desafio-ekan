package com.ekan.domain.documento;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ekan.domain.beneficiario.Beneficiario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tab_documento")
public class Documento implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "tipoDocumento", nullable = false, length = 20)
    private String tipoDocumento;

    @Column(name = "descricao", nullable = false, length = 150, unique = false)
    private String descricao;

    @Column(name = "dataAtualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "dataInclusao")
    private LocalDateTime dataInclusao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "beneficiario_id", referencedColumnName="id", nullable = false)
    @JsonIgnore
    private Beneficiario beneficiario;
}
