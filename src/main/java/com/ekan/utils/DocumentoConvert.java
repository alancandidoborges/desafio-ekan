package com.ekan.utils;

import com.ekan.domain.beneficiario.Beneficiario;
import com.ekan.domain.beneficiario.BeneficiarioDto;
import com.ekan.domain.documento.Documento;
import com.ekan.domain.documento.DocumentoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentoConvert {
    public Documento toDocumentoEntity(DocumentoDto documento){
        var convBenefeciario   = new BeneficiarioConvert();
        Documento newDocuemnto = new Documento();

        newDocuemnto.setId(documento.getId());
        newDocuemnto.setTipoDocumento(documento.getTipoDocumento());
        newDocuemnto.setDescricao(documento.getDescricao());
        newDocuemnto.setDataInclusao(documento.getDataInclusao());
        newDocuemnto.setDataAtualizacao(documento.getDataAtualizacao());
        newDocuemnto.setBeneficiario(convBenefeciario.toBeneficiarioEntity(documento.getBeneficiario()));
        return  newDocuemnto;
    }
    public List<DocumentoDto> convertListDocumentoDto(List<Documento> documentoList) {
        List<DocumentoDto> tempList = null;
        if (!documentoList.isEmpty()){
            documentoList.forEach(temp-> tempList.add(toDocumentoDTO(temp)));
        }
        return tempList;
    }
    public DocumentoDto toDocumentoDTO(Documento documento){
        var dto = new DocumentoDto();
        BeanUtils.copyProperties(documento, dto);
        return dto;
    }
}
