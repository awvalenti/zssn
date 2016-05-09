package com.github.awvalenti.zssn.config.serializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.github.awvalenti.zssn.domain.entity.Item;
import com.github.awvalenti.zssn.domain.entity.ItemAmount;
import com.github.awvalenti.zssn.domain.entity.ItemCollection;

public class ItemCollectionDeserializer extends JsonDeserializer<ItemCollection> {

	@Override
	public ItemCollection deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		TreeNode node = p.getCodec().readTree(p);

		Set<ItemAmount> amounts = new TreeSet<>();
		for (Iterator<String> iterator = node.fieldNames(); iterator.hasNext();) {
			String itemName = iterator.next();
			int quantity = ((NumericNode) node.get(itemName)).asInt();
			amounts.add(new ItemAmount(Item.valueOf(itemName), quantity));
		}

		return new ItemCollection(amounts);
	}

}
