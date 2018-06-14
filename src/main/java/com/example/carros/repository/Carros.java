package com.example.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carros.model.Carro;


public interface Carros extends JpaRepository<Carro,Long>{}
