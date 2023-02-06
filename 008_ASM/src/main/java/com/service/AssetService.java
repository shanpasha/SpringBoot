package com.service;

import java.util.List;

import com.model.Asset;

public interface AssetService {
	void save(Asset asset);
	void delete(Integer id);
	void update(Asset asset);
	Asset getByAssetID(Integer id);
	List<Asset> getAllAssets();


}
