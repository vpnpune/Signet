package com.signet.utilities;

import java.io.IOException;
import java.util.List;

import com.amazonaws.services.s3.model.Bucket;


public interface StorageService {

	void test();
	
	List<Bucket> listBuckets();
	
	void uploadObject();

	void listObjects();

	void downloadObject() throws IOException;

	String getResourceURL(String bucketName, String key);
	
	
}
