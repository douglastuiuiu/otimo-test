package br.com.douglasog87.otimotestapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    //criar um messagebundler pra jogar mensagens
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final String MSG_CAMPO_NULO = "O campo não pode ser nulo";

    //criar um messagebundler pra jogar mensagens
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final String MSG_CAMPO_EM_BRANCO = "O campo não pode estar em branco";

    //criar um messagebundler pra jogar mensagens
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final String MSG_CAMPO_INVALIDO = "O valor do campo é invalido";

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final String REGEX_CEP = "\\d{8}";

    @NotBlank(message = MSG_CAMPO_NULO)
    @Pattern(regexp = REGEX_CEP, message = MSG_CAMPO_INVALIDO)
    @Size(min = 8, max = 8, message = MSG_CAMPO_INVALIDO)
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}
