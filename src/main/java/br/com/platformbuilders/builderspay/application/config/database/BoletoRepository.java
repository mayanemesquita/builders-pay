package br.com.platformbuilders.builderspay.application.config.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<BoletoEntity, String> {
}