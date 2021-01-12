package com.caiodesouza.truslychallenge.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.caiodesouza.truslychallenge.dto.GithubFileDTO;
import com.caiodesouza.truslychallenge.services.exceptions.ResourceNotFoundException;

public class ZipScraperUtils {

	 private ZipScraperUtils() {
		    throw new IllegalStateException("Utility class");
		  }
	 
	 public static List<GithubFileDTO> findRepositoryByOwnerAndRepoName(String baseURL) throws IOException {
			List<GithubFileDTO> list = new ArrayList<>();

			
			URL url = new URL(baseURL);
			try ( 
				InputStream inputStream = url.openStream();
				ZipInputStream zipInS = new ZipInputStream(inputStream);
				BufferedReader reader = new BufferedReader(new InputStreamReader(zipInS))
						){
				
				
				ZipEntry zipEntry;

				while ((zipEntry = zipInS.getNextEntry()) != null) {
					GithubFileDTO githubFile = new GithubFileDTO();

					if (zipEntry.getSize() > 0) {
						String[] path = zipEntry.getName().split("/");
						String[] fileExtension = path[path.length - 1].split("[.]");

						githubFile.setType(fileExtension[fileExtension.length - 1]);
						githubFile.setLines(reader.lines().count());
						githubFile.setSize(FormatUtils.convertToStringRepresentation(zipEntry.getSize()));
						githubFile.setPath(zipEntry.getName());

						list.add(githubFile);

					}

				}

			} catch (FileNotFoundException e) {
				throw new ResourceNotFoundException("Repository or Owner was not found.");

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			return list;
		}
}
