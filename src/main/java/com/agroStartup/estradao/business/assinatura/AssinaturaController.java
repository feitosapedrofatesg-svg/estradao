package com.agroStartup.estradao.business.assinatura;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaService service;

    public AssinaturaController(AssinaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AssinaturaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AssinaturaDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssinaturaDTO insert(@RequestBody @Valid AssinaturaDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public AssinaturaDTO update(@PathVariable Long id, @RequestBody @Valid AssinaturaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
