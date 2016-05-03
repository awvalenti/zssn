package com.github.awvalenti.zssn.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.awvalenti.zssn.model.Survivor;

public class SurvivorRepository {

	private final List<Survivor> data = new ArrayList<>();

	public void add(Survivor survivor) {
		data.add(survivor);
		survivor.setId((long) data.size());
	}

	public List<Survivor> getAll() {
		return Collections.unmodifiableList(data);
	}

}
