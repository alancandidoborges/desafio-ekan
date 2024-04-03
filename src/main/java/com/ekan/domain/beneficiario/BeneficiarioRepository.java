package com.ekan.domain.beneficiario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    boolean existsByNome(String value);
    boolean existsById(Long id);
}
