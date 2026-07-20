package com.agroStartup.estradao.business.localizacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    private final LocalizacaoService service;

    public LocalizacaoController(LocalizacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<LocalizacaoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LocalizacaoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocalizacaoDTO insert(@RequestBody @Valid LocalizacaoDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public LocalizacaoDTO update(@PathVariable Long id, @RequestBody @Valid LocalizacaoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
