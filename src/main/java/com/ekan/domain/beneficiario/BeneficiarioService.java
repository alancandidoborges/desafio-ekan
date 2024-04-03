package com.ekan.domain.beneficiario;

import com.ekan.enums.Message;
import com.ekan.exceptions.BusinessException;
import com.ekan.exceptions.ConflictException;
import com.ekan.exceptions.NotFoundException;
import com.ekan.exceptions.UnprocessableEntityException;
import com.ekan.utils.BeneficiarioConvert;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BeneficiarioService {
    private final BeneficiarioRepository repository;
    private final BeneficiarioConvert convert;
    public BeneficiarioService(BeneficiarioRepository repository, BeneficiarioConvert convert){
        this.repository = repository;
        this.convert    = convert;
    }
    @Transactional
    public BeneficiarioDto insert(BeneficiarioDto dto){
        try {
            if (dto.getNome().isEmpty()){
                throw new UnprocessableEntityException("Oo objetyo para requisição deve ser válido.");
            }
            if (dto.getNome().isEmpty()){
                throw new UnprocessableEntityException("o campo [nome] deve ser preenchido");
            }
            if (dto.getDataNascimento() ==  null){
                throw new UnprocessableEntityException("o campo [data nascimento] deve ser preenchido");
            }
            if (repository.existsByNome(dto.getNome())){
                throw new ConflictException(Message.RECORD_ALREADY_EXISTS.toString());
            }
            Beneficiario beneficiario = repository.save(convert.toBeneficiarioEntity(dto));
            var ret = new BeneficiarioDto();
            ret = convert.toBeneficiarioDto(beneficiario);
            return ret;
        } catch (UnprocessableEntityException e) {
            throw new UnprocessableEntityException(e.getMessage());
        } catch (ConflictException e) {
            throw new ConflictException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(Message.ERROR_SAVE_RECORD.toString(), e);
        }
    }
    public List<BeneficiarioSimpleDto> listAllSimple(){
        try{
            List<Beneficiario> listTemp = repository.findAll();
            if (listTemp.isEmpty()){
                throw new NotFoundException(Message.RECORD_NOT_FOUND.toString());
            }
            return(convert.convertListBeneficiarioSimple(listTemp));
        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(Message.ERROR_LIST_RECORD.toString(), e);
        }
    }
    public List<BeneficiarioDto> listAll(){
        try{
            List<Beneficiario> listTemp = repository.findAll();
            if (listTemp.isEmpty()){
                throw new NotFoundException(Message.RECORD_NOT_FOUND.toString());
            }
            return(convert.convertListBeneficiario(listTemp));
        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(Message.ERROR_LIST_RECORD.toString(), e);
        }
    }
    public BeneficiarioDto findById(Long id){
        try{
            Optional<Beneficiario> beneficiario = repository.findById(id);
            if (!beneficiario.isPresent()){
                    throw new NotFoundException(Message.RECORD_NOT_FOUND.toString());
            }
            return convert.toBeneficiarioDto(beneficiario.get());
        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(Message.RECORD_NOT_FOUND.toString(), e);
        }
    }
    @Transactional
    public BeneficiarioDto update(Long id, BeneficiarioDto dto){
        try {
            if (dto.getNome().isEmpty()){
                throw new UnprocessableEntityException("O objetyo para requisição deve ser válido.");
            }
            if (dto.getNome().isEmpty()){
                throw new UnprocessableEntityException("O campo [nome] deve ser preenchido");
            }
            if (dto.getDataNascimento() ==  null){
                throw new UnprocessableEntityException("O campo [data nascimento] deve ser preenchido");
            }

            if (!repository.existsById(dto.getId())){
                throw new NotFoundException(Message.RECORD_NOT_FOUND.toString());
            }
            Beneficiario beneficiario = new Beneficiario();
            beneficiario = convert.toBeneficiarioEntity(dto);
            beneficiario.setId(id);
            beneficiario.setDataAtualizacao(LocalDateTime.now());
            repository.save(beneficiario);

            return convert.toBeneficiarioDto(beneficiario);
        } catch (UnprocessableEntityException e){
            throw new UnprocessableEntityException(e.getMessage());
        } catch (ConflictException e) {
            throw new ConflictException(e.getMessage());
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(Message.ERROR_SAVE_RECORD.toString(), e);
        }
    }
    @Transactional
    public void delete(Long id){
        try{
            Optional<Beneficiario> Beneficiario = repository.findById(id);
            if (Beneficiario.isEmpty()){
                throw new NotFoundException(Message.RECORD_NOT_FOUND.toString());
            }
            repository.deleteById(id);
        } catch (UnprocessableEntityException e){
            throw new NotFoundException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(Message.ERROR_DELETE_RECORD.toString(), e);
        }
    }
}
