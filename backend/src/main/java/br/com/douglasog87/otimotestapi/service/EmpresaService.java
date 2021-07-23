package br.com.douglasog87.otimotestapi.service;

import br.com.douglasog87.otimotestapi.entity.EmpresaEntity;
import br.com.douglasog87.otimotestapi.enums.TipoEmpresa;
import br.com.douglasog87.otimotestapi.filter.EmpresaQuery;
import br.com.douglasog87.otimotestapi.model.Empresa;
import br.com.douglasog87.otimotestapi.repository.EmpresaRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Page<Empresa> list(Optional<Integer> page, Optional<Integer> size, Optional<EmpresaQuery> query) {

        //falta implementar filtros
        return empresaRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(5)
                )
        ).map(Empresa::parseEmpresa);
    }

    public Empresa findById(Integer id) {
        return empresaRepository.findById(id)
                .map(Empresa::parseEmpresa)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Empresa register(Empresa model) {
        EmpresaEntity entity = EmpresaEntity.parseEmpresaEntity(model);

        if (TipoEmpresa.FILIAL.equals(entity.getTipo())) {
            EmpresaEntity matriz = empresaRepository.findById(model.getMatriz())
                    .orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
            entity.setMatriz(matriz);
        }

        empresaRepository.save(entity);
        return Empresa.parseEmpresa(entity);
    }

    public void delete(Integer id) {
        EmpresaEntity exists = empresaRepository.findById(id)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));

        if (TipoEmpresa.MATRIZ.equals(exists.getTipo())) {
            throw new HttpServerErrorException(HttpStatus.FORBIDDEN, "Operação inválida. Empresa do tipo Matriz não podem ser excluídas");
        }

        empresaRepository.deleteById(exists.getId());
    }
}
