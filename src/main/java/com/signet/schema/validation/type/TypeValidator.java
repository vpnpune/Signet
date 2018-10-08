package com.signet.schema.validation.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.signet.schema.validation.Parser;
import com.signet.schema.validation.ValidationErrorDetail;

import java.util.List;
import java.util.Map.Entry;

public abstract class TypeValidator {
	protected Parser parser;

	@SuppressWarnings("unused")
	private TypeValidator() {
	}

	public TypeValidator(Parser parser) {
		this.parser = parser;
	}

	public abstract List<ValidationErrorDetail> validate(Entry<String, JsonNode> instanceNode, JsonNode schemaNode);

}
