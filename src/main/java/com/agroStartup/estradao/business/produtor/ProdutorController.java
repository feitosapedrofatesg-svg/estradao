package com.agroStartup.estradao.business.produtor;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtores")
public class ProdutorController {

    private final ProdutorService service;

    public ProdutorController(ProdutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutorDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProdutorDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutorDTO insert(@RequestBody @Valid ProdutorDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public ProdutorDTO update(@PathVariable Long id, @RequestBody @Valid ProdutorDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
