package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Asset;

public interface AssetRepo extends JpaRepository<Asset, Long> {

}
