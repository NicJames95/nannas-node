package com.Nannas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nannas.entity.Image;

public interface ImageRepository extends JpaRepository <Image, String> {

}
