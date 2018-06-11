package org.springboot.springmvc.mybatis.mapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Ignore;

public class ReflectionUtil {

	public static <K, T> JSONObject getDobuleObjectDiffentJson(K k, T t,
			List<String> commonFieldList) {
		JSONObject jsonObj = new JSONObject();
		Objects.requireNonNull(k);
		Objects.requireNonNull(t);
		Objects.requireNonNull(commonFieldList);
		try {
			Class<?> cla = k.getClass();
			Class<?> clb = t.getClass();
			for (String commField : commonFieldList) {
				String getName = "";
				String firstStr = commField.substring(0, 1);
				if (commField.startsWith("is")) {
					getName = commField;
				} else {
					getName = "get"
							+ commField.replaceFirst(firstStr,
									firstStr.toUpperCase(Locale.CHINA));
				}
				Method method1 = cla.getMethod(getName);
				Method method2 = clb.getMethod(getName);

				Object obj1 = method1.invoke(k);
				Object obj2 = method2.invoke(t);

				String value1 = obj1 == null ? "" : obj1.toString().trim();
				String value2 = obj2 == null ? "" : obj2.toString().trim();
				if (!value1.equals(value2)) {
					jsonObj.put(commField, value1);
				}
			}
			return jsonObj;

		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <K, T> List<String> getDoubleEntityCommonFields(Class<K> cla,
			Class<T> clb, Class<? extends Annotation> annotation, boolean isAll) {
		List<String> commonFieldList = new ArrayList<String>(50);
		Set<String> set = new HashSet<String>();
		List<Field> field1List = getEntityField(cla, isAll);
		for (Field f1 : field1List) {
			if (!f1.isAnnotationPresent(Ignore.class)
					&& !f1.isAnnotationPresent(annotation)) {
				set.add(f1.getName());
			}
		}
		List<Field> field2List = getEntityField(clb, isAll);
		for (Field f2 : field2List) {
			if (!f2.isAnnotationPresent(Ignore.class)
					&& !f2.isAnnotationPresent(annotation)) {
				if (set.contains(f2.getName())) {
					commonFieldList.add(f2.getName());
				}
			}
		}
		return commonFieldList;
	}

	public static <T> List<String> getEntityFieldNames(Class<T> cla,
			boolean isAll) {
		List<Field> allFieldList = new ArrayList<Field>();
		List<String> allFieldNameList = new ArrayList<String>();
		Field[] fields = cla.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			allFieldList.addAll(Arrays.asList(fields));
		}
		if (isAll) {
			get(cla, allFieldList);
		}
		for (Field field : allFieldList) {
			allFieldNameList.add(field.getName());
		}
		return allFieldNameList;
	}

	public static <T> List<Field> getEntityField(Class<T> cla, boolean isAll) {
		List<Field> allFieldList = new ArrayList<Field>();
		Field[] fields = cla.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			allFieldList.addAll(Arrays.asList(fields));
		}
		if (isAll) {
			get(cla, allFieldList);
		}
		return allFieldList;
	}

	public static <T> void get(Class<T> cla, List<Field> fieldList) {
		Class<? super T> superClass = cla.getSuperclass();
		if (superClass == Object.class) {
			return;
		} else {
			Field[] fields = superClass.getDeclaredFields();
			if (fields != null && fields.length > 0) {
				fieldList.addAll(Arrays.asList(fields));
			}
			get(superClass, fieldList);
		}
	}
}
