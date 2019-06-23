package com.blockchain.pai.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.pai.entity.Venta;
import com.blockchain.pai.repository.VentaJpaRepository;

@RestController
@RequestMapping("/ventas")
@CrossOrigin
public class VentaController {

	@Autowired
	private VentaJpaRepository repository;

	@GetMapping()
	public Collection<Venta> getVentas() {
		return repository.findAll().stream().collect(Collectors.toList());
	}

	@GetMapping(path = { "/{id}" })
	public Venta getVentaById(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}

	@PostMapping()
	public Venta create(@RequestBody Venta venta) {
		return repository.save(venta);

	}

	@PutMapping("/{id}")
	public Venta update(@PathVariable("id") Long id, @RequestBody Venta venta) {
		return repository.save(repository.findById(venta.getId()).get());
	}

	@DeleteMapping(path = { "/{id}" })
	public Venta delete(@PathVariable("id") Long id) {
		Optional<Venta> venta = repository.findById(id);
		repository.delete(venta.get());
		return venta.get();
	}

}
