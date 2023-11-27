package com.adjecti.jetform.liferay.activator;

import com.adjecti.common.util.JetFormResourceCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public abstract class JetformActivator{
	
	
	protected String formsLocation;
	protected String formDefinationPath;
	
	
	public void start(BundleContext context) {
		log.info("jetFormActivator::");
		try {
			Path path = Paths.get(formsLocation+"/"+formDefinationPath);
			Files.createDirectories(path);
			
			Enumeration<String> resourcePaths = context.getBundle().getEntryPaths(formDefinationPath);
			while (resourcePaths.hasMoreElements()) {
				
				String resourcePath = (String) resourcePaths.nextElement();
				
				createJsonFile(resourcePath,formsLocation);
				
			}
		

		} catch (IOException e1) {

			log.info(e1);
		}

	}

	private void createJsonFile(String resourcePath,String mdmFormsLocation) {
		Path filepath = null;
		filepath = Paths.get(mdmFormsLocation+"/"+ resourcePath);
		
		try (InputStream resource = getClass().getClassLoader().getResourceAsStream(resourcePath);

				InputStreamReader isr = new InputStreamReader(resource, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);

				FileWriter filewriter = new FileWriter(filepath.toFile());
				BufferedWriter outputStream = new BufferedWriter(filewriter);

		) {

			String fileContent;
			while ((fileContent = br.readLine()) != null) {
				outputStream.write(fileContent);

			}

		} catch (IOException e) {

			log.info(e);
		}

		JetFormResourceCache.registerJetFormResourceCache(resourcePath, filepath.toFile().getAbsolutePath());
	}

	
	
	public void stop(BundleContext context) throws Exception {
		log.info("Bundle stoped");
	}
	
	public abstract void registerFormEntity() ;

	private Log log = LogFactoryUtil.getLog(this.getClass());
}
