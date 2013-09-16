package net.bitacademy.java41.listeners;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java41.annotations.Component;

public class ContextLoaderListener implements ServletContextListener {
	ServletContext ctx;
	Hashtable<String,Object> objTable = new Hashtable<String,Object>();
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ctx = event.getServletContext();
		ctx.setAttribute("rootPath", ctx.getContextPath());
		
		try {
			loadProperties(
					ctx.getRealPath("/WEB-INF/db.properties"));
			
			prepareObjects( new File(
					ctx.getRealPath("/WEB-INF/classes")) );
			
			prepareDependancy();
			saveToContext();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveToContext() {
		Enumeration<String> keyList = objTable.keys();
		String key = null;
		while(keyList.hasMoreElements()) {
			key = keyList.nextElement();
			ctx.setAttribute(key, objTable.get(key));
		}
	}

	private void prepareDependancy() throws Exception {
		Collection<Object> objList = objTable.values();
		for(Object obj : objList) {
			if (obj.getClass() != java.lang.String.class) {
				injectDependancy(obj);
			}
		}
	}

	private void injectDependancy(Object obj) throws Exception {
		System.out.println(obj.getClass().getName() + "---------");
		Method[] methodList = obj.getClass().getMethods();
		for (Method m : methodList) {
			callSetter(obj, m);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void callSetter(Object instance, Method method) throws Exception {
		Class paramClass = null;
		Object paramObject = null;
		if (method.getName().startsWith("set")) {
			paramClass = method.getParameterTypes()[0];
			if (paramClass == java.lang.String.class) {
				String propertyName = extractPropertyName(method.getName());
				method.invoke(instance, objTable.get(propertyName));
			} else {
				paramObject = findInstanceByClass(paramClass);
				method.invoke(instance, paramObject);
			}
			System.out.println("......" + method.getName());
		}
	}

	private String extractPropertyName(String methodName) {
		return methodName.substring(3, 4).toLowerCase()
				+ methodName.substring(4);
	}

	@SuppressWarnings("rawtypes")
	private Object findInstanceByClass(Class paramClass) {
		Collection<Object> instanceList = objTable.values();
		for(Object obj : instanceList) {
			if (obj.getClass() == paramClass) {
				return obj;
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private void loadProperties(String propPath) throws Exception {
		Properties props = new Properties();
		props.load( new FileReader(propPath));
		
		Enumeration enums = props.keys();
		String key = null;
		while(enums.hasMoreElements()) {
			key = (String)enums.nextElement();
			objTable.put(key, ((String)props.get(key)).trim()); 
		}
	}
	
	/**
	 /WEB-INF/classes 폴더에 들어있는 클래스 파일들을 뒤져서
	@Component라는 애노테이션이 붙은 클래스만 찾아서 
	인스턴스를 생성한다.
			 * 
	 @param file
	 @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private void prepareObjects(File file) throws Exception {
		if (file.isFile()) {
			String className = getQName(file.getPath());
			Class clazz = Class.forName(className);
			String key = getKeyFromClass(clazz);
			if (key != null) {
				System.out.println("====>" + key);
				objTable.put(key, clazz.newInstance());
			}
		} else if (file.isDirectory()) {
			File[] childs = file.listFiles( new FileFilter() {/*FileFilter를 구현한 객체*/
						@Override
						public boolean accept(File file) {
							if (file.getName().endsWith(".class") || 
									file.isDirectory()) {
								return true;
							} else {
								return false;
							}
						}
					} ); 
			for(File f : childs) {
				prepareObjects(f);
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String getKeyFromClass(Class clazz) throws Exception {
		Component compAnno = 
				(Component)clazz.getAnnotation(Component.class);
		if (compAnno != null) {
			String value = compAnno.value();
			if (value.equals("")) {
				String className = clazz.getSimpleName(); 
				// ex) ProjectService -> projectService
				return className.substring(0, 1).toLowerCase() 
						+ className.substring(1);
			} else {
				return value;
			}
		} else {
			return null;
		}
	}
	
	private String getQName(String path) {
		String temp = path.substring( 
				path.indexOf("classes") + 8,
				path.length() - 6);
		temp = temp.replace('/', '.');
		temp = temp.replace('\\', '.');
		return temp;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}






