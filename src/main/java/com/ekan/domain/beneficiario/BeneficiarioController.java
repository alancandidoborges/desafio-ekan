package com.ekan.domain.beneficiario;

import com.ekan.enums.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@Tag(name = "ekan-beneficiario-api")
public class BeneficiarioController {
    private final BeneficiarioService service;
    public BeneficiarioController(BeneficiarioService service) {
        this.service = service;
    }
    @Operation(summary = "insere um novo beneficiario", method ="POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registro inserido com sucesso."),
            @ApiResponse(responseCode = "409", description = "A solicitação atual conflitou com o recurso que está no servidor, formato dos dados inválido."),
            @ApiResponse(responseCode = "422", description = "O servido não pode processar sua requisição."),
            @ApiResponse(responseCode = "500", description = "Houve uma dificuldade de processamento do servidor, a partir de uma incompatibilidade ou configuração incorreta."),
    })
    @PostMapping("/post")
    public ResponseEntity<Object> insert(@RequestBody @Valid BeneficiarioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @Operation(summary = "Lista todos os beneficiarios com os documentos", method ="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registros não Encontrado"),
            @ApiResponse(responseCode = "409", description = "A solicitação atual conflitou com o recurso que está no servidor, formato dos dados inválido."),
            @ApiResponse(responseCode = "422", description = "O servido não pode processar sua requisição."),
            @ApiResponse(responseCode = "500", description = "Houve uma dificuldade de processamento do servidor, a partir de uma incompatibilidade ou configuração incorreta."),
    })
    @GetMapping("/listAll")
    public ResponseEntity<List<BeneficiarioDto>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }
    @Operation(summary = "Lista todos os beneficiarios sem os documentos", method ="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registros não Encontrado"),
            @ApiResponse(responseCode = "409", description = "A solicitação atual conflitou com o recurso que está no servidor, formato dos dados inválido."),
            @ApiResponse(responseCode = "422", description = "O servido não pode processar sua requisição."),
            @ApiResponse(responseCode = "500", description = "Houve uma dificuldade de processamento do servidor, a partir de uma incompatibilidade ou configuração incorreta."),
    })
    @GetMapping("/listAllSimple")
    public ResponseEntity<List<BeneficiarioSimpleDto>> listAllSimple() {
        return ResponseEntity.ok(service.listAllSimple());
    }
    @Operation(summary = "Busca um beneficiario pelo código", method ="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registros não Encontrado"),
            @ApiResponse(responseCode = "409", description = "A solicitação atual conflitou com o recurso que está no servidor, formato dos dados inválido."),
            @ApiResponse(responseCode = "422", description = "O servido não pode processar sua requisição."),
            @ApiResponse(responseCode = "500", description = "Houve uma dificuldade de processamento do servidor, a partir de uma incompatibilidade ou configuração incorreta."),
    })
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Atualiza um beneficiario existente", method ="PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Beneficiario atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registros não Encontrado"),
            @ApiResponse(responseCode = "409", description = "A solicitação atual conflitou com o recurso que está no servidor, formato dos dados inválido."),
            @ApiResponse(responseCode = "422", description = "O servido não pode processar sua requisição."),
            @ApiResponse(responseCode = "500", description = "Houve uma dificuldade de processamento do servidor, a partir de uma incompatibilidade ou configuração incorreta."),
    })
    @PutMapping("/put/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id,  @RequestBody @Valid BeneficiarioDto dto){
        service.update(id, dto);
        return ResponseEntity.ok(Message.RECORD_UPDATED.toString());
    }
    @Operation(summary = "Deleta um beneficiario pelo id", method ="DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Beneficiario deletrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Registros não Encontrado"),
            @ApiResponse(responseCode = "409", description = "A solicitação atual conflitou com o recurso que está no servidor, formato dos dados inválido."),
            @ApiResponse(responseCode = "422", description = "O servido não pode processar sua requisição."),
            @ApiResponse(responseCode = "500", description = "Houve uma dificuldade de processamento do servidor, a partir de uma incompatibilidade ou configuração incorreta."),

    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
