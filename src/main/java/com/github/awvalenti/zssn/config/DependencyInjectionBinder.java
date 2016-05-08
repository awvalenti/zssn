package com.github.awvalenti.zssn.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.github.awvalenti.zssn.domain.service.TradeService;

public class DependencyInjectionBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(TradeService.class).to(TradeService.class);
	}
}
