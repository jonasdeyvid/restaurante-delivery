package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurante.model.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
