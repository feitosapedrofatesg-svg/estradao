package com.agroStartup.estradao.business.caminhoneiro;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhoneiros")
public class CaminhoneiroController {

    private final CaminhoneiroService service;

    public CaminhoneiroController(CaminhoneiroService service) {
        this.service = service;
    }

    @GetMapping
    public List<CaminhoneiroDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CaminhoneiroDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhoneiroDTO insert(@RequestBody @Valid CaminhoneiroDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public CaminhoneiroDTO update(@PathVariable Long id, @RequestBody @Valid CaminhoneiroDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
