package br.com.douglasog87.otimotestapi.filter;

import br.com.douglasog87.otimotestapi.model.Empresa;
import java.io.Serializable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class EmpresaQuery implements Serializable {

    private static final long serialVersionUID = -2177784986643303482L;

    @Size(max = 50)
    private String nome;

    @Pattern(regexp = Empresa.REGEX_CNPJ, message = Empresa.MSG_CAMPO_INVALIDO)
    @Size(min = 14, max = 14, message = Empresa.MSG_CAMPO_INVALIDO)
    private String cnpj;

    private String tipo;

}
