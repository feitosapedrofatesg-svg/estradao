package com.agroStartup.estradao.business.caminhao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {

    private final CaminhaoService service;

    public CaminhaoController(CaminhaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CaminhaoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CaminhaoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhaoDTO insert(@RequestBody @Valid CaminhaoDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public CaminhaoDTO update(@PathVariable Long id, @RequestBody @Valid CaminhaoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
