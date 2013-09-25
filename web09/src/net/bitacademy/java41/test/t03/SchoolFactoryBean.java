package net.bitacademy.java41.test.t03;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class SchoolFactoryBean<T> extends AbstractFactoryBean<T> {
	@Override
	protected T createInstance() throws Exception {
		School s = new School();
		s.setName("비트고등학교");
		return (T)s;
	}

	@Override
	public Class<?> getObjectType() {
		return School.class;
	}
}
