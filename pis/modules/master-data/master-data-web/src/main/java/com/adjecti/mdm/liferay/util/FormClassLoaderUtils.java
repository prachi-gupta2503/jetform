package com.adjecti.mdm.liferay.util;

import com.adjecti.common.util.FormEntityCache;
import com.adjecti.jetform.annotation.HtmlForm;
import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class FormClassLoaderUtils {
	private final static Log LOGGER = LogFactoryUtil.getLog(FormClassLoaderUtils.class.getName());

	/**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
    
    public static void registerFormClasses(String[] packages) {
    	for(String pkg:packages) {
    		try {
	    		List<Class> formClasses = getClasses(pkg);
				
	    		for(Class formClass:formClasses) {
	    			if(formClass.isAnnotationPresent(HtmlForm.class) || formClass.isAnnotationPresent(ImplementationClassName.class)) {
	    				FormEntityCache.registerFormClass(formClass);
	    			}
	    		}
    		} catch (ClassNotFoundException e) {
				LOGGER.error(e);
			} catch (IOException e) {
				LOGGER.error(e);
			}
    	}
    }
}
