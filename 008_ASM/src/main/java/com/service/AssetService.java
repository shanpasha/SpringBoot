package com.service;

import java.util.List;

import com.model.Asset;

public interface AssetService {
	void save(Asset asset);
	void delete(Long id);
	void update(Asset asset);
	Asset getByAssetID(Long id);
	List<Asset> getAllAssets();


}
