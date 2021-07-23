package br.com.douglasog87.otimotestapi.controller;

import br.com.douglasog87.otimotestapi.filter.EmpresaQuery;
import br.com.douglasog87.otimotestapi.model.Empresa;
import br.com.douglasog87.otimotestapi.service.EmpresaService;
import java.net.URI;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@AllArgsConstructor
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<Page<Empresa>> list(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestBody Optional<EmpresaQuery> query
    ) {
        //falta implementar filtros
        return ResponseEntity.ok(empresaService.list(page, size, query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> get(@PathVariable Integer id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Empresa> register(@RequestBody Empresa request, UriComponentsBuilder uriBuilder) {
        Empresa empresa = empresaService.register(request);
        URI uri = uriBuilder.path("/empresas/{id}")
                .buildAndExpand(empresa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
