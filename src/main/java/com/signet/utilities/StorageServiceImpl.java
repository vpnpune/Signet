package com.signet.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class StorageServiceImpl implements StorageService {
	static AWSCredentials credentials = new BasicAWSCredentials("demo", "demo");
	static AmazonS3 s3client;

	static {
		s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_SOUTH_1).build();
	}
	String bucketName = "csism";

	@Override
	public void test() {
		System.out.print("TEST service");

	}

	@Override
	public List<Bucket> listBuckets() {
		return s3client.listBuckets();
	}

	@Override
	public void uploadObject() {
		File curDir = new File(".");
		File[] filesList = curDir.listFiles();
		for (File f : filesList) {
			if (f.isFile()) {
				System.out.println(f.getName());
			}
		}
		PutObjectResult result = s3client.putObject(bucketName, "Document/README.md", new File("README.md"));
		String url = getResourceURL(bucketName, "Document/README.md");
		System.out.println(result);

	}

	@Override
	public void listObjects() {
		ObjectListing objectListing = s3client.listObjects(bucketName);
		for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
			System.out.println(os.getKey());
		}
	}

	@Override
	public void downloadObject() throws IOException {
		S3Object s3object = s3client.getObject(bucketName, "Document/README.md");
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		// FileUtils.copyInputStreamToFile(inputStream, new
		// File("README_COPY.md"));
	}

	@Override
	public String getResourceURL(String bucketName, String key) {
		return String.valueOf(s3client.getUrl(bucketName, key));
	}
}
