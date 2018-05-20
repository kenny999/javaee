package com.wsusertrace;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class UsertraceExtension implements Extension {

	public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> processAnnotatedType) {

		AnnotatedType<T> annotatedType = processAnnotatedType.getAnnotatedType();

		Class<T> javaClass = annotatedType.getJavaClass();
		Package package1 = javaClass.getPackage();
		String name = package1.getName();
		if (name.contains("wsusertrace") && ! name.contains("vetoed")) {
			Annotation auditAnnotation = new Annotation() {
				@Override
				public Class<? extends Annotation> annotationType() {
					return UsertraceInterceptor.class;
				}
			};

			AnnotatedTypeWrapper<T> wrapper = new AnnotatedTypeWrapper<T>(annotatedType,
					annotatedType.getAnnotations());
			wrapper.addAnnotation(auditAnnotation);

			processAnnotatedType.setAnnotatedType(wrapper);
		}
	}

}