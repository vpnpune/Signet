package com.signet.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.io.Resources;
import com.signet.dto.AreaDto;
import com.signet.exception.SchemaValidationException;
import com.signet.schema.validation.SchemaParser;
import com.signet.schema.validation.SchemaValidator;
import com.signet.schema.validation.ValidationErrorDetail;

/**
 * 
 * Validation service is for doing validations.
 *
 */
@Service
public class ValidationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationService.class);

	private SchemaValidator schemaValidator;
	private Map<Class<?>, JSONObject> schemaParserMap = new HashMap<>();
	private Schema schema;

//	@Autowired
//	private AccountRepository accountRepository;

	public ValidationService() throws IOException, JSONException {
		JSONObject rawSchema = new JSONObject(new JSONTokener(
				Resources.toString(Resources.getResource("schema/Area.json"), Charset.defaultCharset())));
		Schema schema = SchemaLoader.load(rawSchema);
	}

	/**
	 * Validate create account details.
	 * 
	 * @param accountDto
	 */
	public void validateArea(final AreaDto accountDto) throws IOException {
		JSONObject rawSchema = new JSONObject(new JSONTokener(
				Resources.toString(Resources.getResource("schema/Area.json"), Charset.defaultCharset())));
		Schema schema = SchemaLoader.load(rawSchema);
		schema.validate(new JSONObject(accountDto));
//		validateSchema(schemaParserMap.get(accountDto.getClass()), accountDto);
//		validateUniqueAccount(accountDto);
	}

	/**
	 * This method checks if account already exists or not.
	 * 
	 * @param accountDto
	 */
//	private void validateUniqueAccount(final AccountDto accountDto) {
////		if(null != accountRepository.findOne(accountDto.getAccountName())) {
////			throw new ValidationException("accountName", "Account already exists with same details", ErrorCodeConstants.BV_ACCOUNT_AlREADY_EXISTS);
////		}
//	}

	/**
	 * 
	 * @param schemaParser
	 * @param dto
	 * @exception SchemaValidationException On invalid input.
	 */
	private void validateSchema(SchemaParser schemaParser, Object dto) {
		LOGGER.debug("validateSchema called with DTO: " + dto);
		final List<ValidationErrorDetail> validationErrorDetails = schemaValidator.getErrorDetails(schemaParser, dto);
		if (!validationErrorDetails.isEmpty()) {
			LOGGER.error("The provided DTO did not match the schema, and returned errors: " + validationErrorDetails);
			throw new SchemaValidationException(validationErrorDetails);
		}
	}

	/**
	 * Validate
	 * 
	 * @param TransferDTO: Data transfer object used to get details of transfer.
	 */
//	public void validateTransferAmount(TransferDto transferDto) {
//		validateSchema(schemaParserMap.get(transferDto.getClass()), transferDto);
//	}

}
