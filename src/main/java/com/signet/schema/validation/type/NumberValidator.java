package com.signet.schema.validation.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.signet.schema.validation.Parser;
import com.signet.schema.validation.ValidationConstants;
import com.signet.schema.validation.ValidationErrorDetail;

public class NumberValidator extends TypeValidator {

	public NumberValidator(Parser parser) {
		super(parser);
	}

	@Override
	public List<ValidationErrorDetail> validate(Entry<String, JsonNode> instanceNode, JsonNode schemaNode) {
		final List<ValidationErrorDetail> validationErrorDetails = new ArrayList<>();
		
		Object obj = instanceNode.getValue();
		if(!(obj instanceof Integer)) {
			validationErrorDetails.add(new ValidationErrorDetail(instanceNode.getKey(), ValidationConstants.NOT_NUMBER));
		}
		
		JsonNode minimumNode = schemaNode.findValue(ValidationConstants.MINIMUM);
		if (minimumNode != null && instanceNode.getValue().asInt() < minimumNode.asInt()) {
			validationErrorDetails.add(new ValidationErrorDetail(instanceNode.getKey(), ValidationConstants.MINIMUM));
		}
		JsonNode maximumNode = schemaNode.findValue(ValidationConstants.MAXIMUM);
		if (maximumNode != null && instanceNode.getValue().asInt() > maximumNode.asInt()) {
			validationErrorDetails.add(new ValidationErrorDetail(instanceNode.getKey(), ValidationConstants.MAXIMUM));
		}
		return validationErrorDetails;
	}

}