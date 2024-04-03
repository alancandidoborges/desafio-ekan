package com.ekan.utils;

import com.ekan.domain.beneficiario.Beneficiario;
import com.ekan.domain.beneficiario.BeneficiarioDto;
import com.ekan.domain.beneficiario.BeneficiarioSimpleDto;
import com.ekan.domain.documento.Documento;
import com.ekan.domain.documento.DocumentoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BeneficiarioConvert {
    public Beneficiario toBeneficiarioEntity(BeneficiarioDto beneficiario){

        Beneficiario newBeneficiario = new Beneficiario();
        newBeneficiario.setNome(beneficiario.getNome());
        newBeneficiario.setTelefone(beneficiario.getTelefone());
        newBeneficiario.setDataNascimento(beneficiario.getDataNascimento());
        newBeneficiario.setDataInclusao(beneficiario.getDataInclusao());
        newBeneficiario.setDataAtualizacao(beneficiario.getDataAtualizacao());

        List<Documento> lista = new ArrayList<>();

        for (DocumentoDto docs:beneficiario.getDocumentos()){
            var doc = new Documento();

            doc.setBeneficiario(newBeneficiario);
            doc.setDescricao(docs.getDescricao());
            doc.setTipoDocumento(docs.getTipoDocumento());
            doc.setDataInclusao(docs.getDataInclusao());
            doc.setDataAtualizacao(docs.getDataAtualizacao());
            lista.add(doc);
        }
        newBeneficiario.setDocumentos(lista);
        return newBeneficiario;
    }
    public List<BeneficiarioDto> convertListBeneficiario(List<Beneficiario> BeneficiarioList) {
        List<BeneficiarioDto> tempList = new ArrayList<>();
        if (!BeneficiarioList.isEmpty()){
            BeneficiarioList.forEach(temp-> tempList.add(toBeneficiarioDto(temp)));
        }
        return tempList;
    }
    public List<BeneficiarioSimpleDto> convertListBeneficiarioSimple(List<Beneficiario> BeneficiarioList) {
        List<BeneficiarioSimpleDto> tempList = new ArrayList<>();
        if (!BeneficiarioList.isEmpty()){
            BeneficiarioList.forEach(temp-> tempList.add(toBeneficiarioSimpeDto(temp)));
        }
        return tempList;
    }
    public BeneficiarioDto toBeneficiarioDto(Beneficiario beneficiario){
        var dto = new BeneficiarioDto();
        dto.setId(beneficiario.getId());
        dto.setNome(beneficiario.getNome());
        dto.setTelefone(beneficiario.getTelefone());
        dto.setDataNascimento(beneficiario.getDataNascimento());
        dto.setDataInclusao(beneficiario.getDataInclusao());
        dto.setDataAtualizacao(beneficiario.getDataAtualizacao());

        List<DocumentoDto> lista = new ArrayList<>();

        for (Documento docs:beneficiario.getDocumentos()){
            var doc = new DocumentoDto();
            doc.setId(docs.getId());
            doc.setBeneficiario(dto);
            doc.setDescricao(docs.getDescricao());
            doc.setTipoDocumento(docs.getTipoDocumento());
            doc.setDataInclusao(docs.getDataInclusao());
            doc.setDataAtualizacao(docs.getDataAtualizacao());
            lista.add(doc);
        }
        dto.setDocumentos(lista);
        return dto;
    }

    public BeneficiarioSimpleDto toBeneficiarioSimpeDto(Beneficiario beneficiario){
        var dto = new BeneficiarioSimpleDto();
        dto.setId(beneficiario.getId());
        dto.setNome(beneficiario.getNome());
        dto.setTelefone(beneficiario.getTelefone());
        dto.setDataNascimento(beneficiario.getDataNascimento());
        dto.setDataInclusao(beneficiario.getDataInclusao());
        dto.setDataAtualizacao(beneficiario.getDataAtualizacao());
        return dto;
    }

}
