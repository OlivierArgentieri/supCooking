package com.supinfo.supcooking.dao;

import java.util.List;

import com.supinfo.supcooking.entity.Rate;

public interface RateDAO {
		// D�finition des m�thodes de l'interface
		void addRate(Rate aRate);
		Rate findRateById(Long id, String IpAddress);
		List<Rate> getAllRates();
		void updateRate(Rate aRate);
		void removeRate(Rate aRate);
	}