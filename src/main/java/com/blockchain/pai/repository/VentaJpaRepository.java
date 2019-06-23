package com.blockchain.pai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.pai.entity.Venta;

@Repository
public interface VentaJpaRepository extends JpaRepository<Venta, Long> {

	public List<Venta> findAll();

	public Venta save(Venta venta);

	public void delete(Venta venta);

}
