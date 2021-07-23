package br.com.douglasog87.otimotestapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.douglasog87.otimotestapi.entity.EmpresaEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Empresa implements Serializable {

    private static final long serialVersionUID = 99484748054556763L;

    //criar um messagebundler pra jogar mensagens
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    public static final String MSG_CAMPO_NULO = "O campo não pode ser nulo";

    //criar um messagebundler pra jogar mensagens
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    public static final String MSG_CAMPO_EM_BRANCO = "O campo não pode estar em branco";

    //criar um messagebundler pra jogar mensagens
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    public static final String MSG_CAMPO_INVALIDO = "O valor do campo é invalido";

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    public static final String REGEX_CEP = "\\d{8}";

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    public static final String REGEX_CNPJ = "\\d{14}";


    private Integer id;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 50)
    private String nome;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Pattern(regexp = REGEX_CNPJ, message = MSG_CAMPO_INVALIDO)
    @Size(min = 14, max = 14, message = MSG_CAMPO_INVALIDO)
    private String cnpj;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    private String tipo;

    private Integer matriz;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    private String razaoSocial;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    private String contato;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    @Email(message = MSG_CAMPO_INVALIDO)
    private String email;

    @NotBlank(message = MSG_CAMPO_NULO)
    @Pattern(regexp = REGEX_CEP, message = MSG_CAMPO_INVALIDO)
    @Size(min = 8, max = 8, message = MSG_CAMPO_INVALIDO)
    private String cep;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    private String estado;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    private String bairro;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    private String cidade;

    @NotBlank(message = MSG_CAMPO_EM_BRANCO)
    @Size(max = 40)
    private String logradouro;

    @Size(max = 40)
    private String complemento;

    public static Empresa parseEmpresa(EmpresaEntity entity) {
        return Empresa.builder()
            .id(entity.getId())
            .nome(entity.getNome())
            .cnpj(entity.getCnpj())
            .tipo(entity.getTipo().toString())
            .matriz(Objects.nonNull(entity.getMatriz()) ? entity.getMatriz().getId() : null)
            .razaoSocial(entity.getRazaoSocial())
            .contato(entity.getContato())
            .email(entity.getEmail())
            .cep(entity.getCep())
            .estado(entity.getEstado())
            .bairro(entity.getBairro())
            .cidade(entity.getCidade())
            .logradouro(entity.getLogradouro())
            .complemento(entity.getComplemento())
            .build();
    }

}
