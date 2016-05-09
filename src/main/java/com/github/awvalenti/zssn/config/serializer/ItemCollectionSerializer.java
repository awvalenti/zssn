package com.github.awvalenti.zssn.config.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.awvalenti.zssn.domain.entity.ItemSlot;
import com.github.awvalenti.zssn.domain.entity.ItemCollection;

public class ItemCollectionSerializer extends JsonSerializer<ItemCollection> {

	@Override
	public void serialize(ItemCollection itemCollection, JsonGenerator gen,
			SerializerProvider serializers) throws IOException, JsonProcessingException {
		gen.writeStartObject();
		for (ItemSlot slot : itemCollection) {
			gen.writeNumberField(slot.getItem().name(), slot.getQuantity());
		}
		gen.writeEndObject();
	}

}
