package com.signet.schema.validation.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.signet.schema.validation.Parser;
import com.signet.schema.validation.ValidationErrorDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

public class CustomTypeValidator extends TypeValidator {

	public CustomTypeValidator(Parser parser) {
		super(parser);
	}

	@Override
	public List<ValidationErrorDetail> validate(Entry<String, JsonNode> instanceNode, JsonNode schemaNode) {
		final List<ValidationErrorDetail> validationErrorDetails = new ArrayList<>();
		
		return validationErrorDetails;
	}

}
