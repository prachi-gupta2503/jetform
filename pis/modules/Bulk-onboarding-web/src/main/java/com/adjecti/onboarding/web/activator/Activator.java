package com.adjecti.onboarding.web.activator;

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
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		try {
			
			String bulkonboardingFormsLocation = PropsUtil.get("jetform.bulkonboarding.location");
			String formDefinationPath = PropsUtil.get("jetform.formDefinition.location");
		
			Path path = Paths.get(bulkonboardingFormsLocation+"/"+formDefinationPath);
			Files.createDirectories(path);

			Enumeration<String> resourcePaths = context.getBundle().getEntryPaths("jetform");
			while (resourcePaths.hasMoreElements()) {

				String resourcePath = (String) resourcePaths.nextElement();

				createJsonFile(resourcePath,bulkonboardingFormsLocation);

			}

		} catch (IOException e1) {

			log.info(e1);
		}

	}

	private void createJsonFile(String resourcePath ,String bulkonboardingFormsLocation) {
		Path filepath = null;
		filepath = Paths.get(bulkonboardingFormsLocation+"/" + resourcePath);
		if (!Files.exists(filepath, LinkOption.NOFOLLOW_LINKS)) {
			try {

				Files.createFile(filepath);
			} catch (IOException e) {
				log.info(e);
			}
		}

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
	

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}
	private Log log = LogFactoryUtil.getLog(this.getClass());
}
