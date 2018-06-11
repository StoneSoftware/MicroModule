package org.springboot.springmvc.mybatis.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SupserMapper<T> {

	/**
	 * <精确匹配查询>
	 * 
	 * @param table
	 * @param map
	 * @return
	 */
	@Select("<script>SELECT * FROM ${tab} WHERE "
			+ "<foreach collection='map.keys' item='key' open='' close='' separator='AND'>${key}=#{map[${key}]}</foreach>"
			+ "</script>")
	List<T> queryByFieldEqual(@Param("tab") String table,
			@Param("map") Map<String, String> map);

	/**
	 * <范围查询>
	 * 
	 * @param table
	 * @param file
	 * @param list
	 * @return
	 */
	@Select("<script>SELECT * FROM ${tab} WHERE ${field} in"
			+ "<foreach collection='list' item='item' open='(' close=')' separator=','>#{item}</foreach>"
			+ "</script>")
	List<T> queryByFieldIn(@Param("tab") String table,
			@Param("field") String file, @Param("list") List<String> list);

	/**
	 * <模糊匹配>
	 * 
	 * @param table
	 * @param map
	 * @return
	 */
	@Select("<script>SELECT * FROM ${tab} WHERE ${field} like '%${str}%' </script>")
	List<T> queryByFieldLike(@Param("tab") String table,
			@Param("field") String field, @Param("str") String str);

	/**
	 * <模糊匹配>
	 * 
	 * @param table
	 * @param map
	 * @return
	 */
	@Select("<script>SELECT * FROM ${tab} WHERE "
			+ "<foreach collection='map.keys' item='key' open='' close='' separator='AND'>${key} like '%${map[${key}]}%'</foreach>"
			+ "</script>")
	List<T> queryByFieldLikeAnd(@Param("tab") String table,
			@Param("map") Map<String, String> map);

	/**
	 * <模糊匹配>
	 * 
	 * @param table
	 * @param map
	 * @return
	 */
	@Select("<script>SELECT * FROM ${tab} WHERE "
			+ "<foreach collection='map.keys' item='key' open='' close='' separator='OR'>${key} like '%${map[${key}]}%'</foreach>"
			+ "</script>")
	List<T> queryByFieldLikeOr(@Param("tab") String table,
			@Param("map") Map<String, String> map);

	/**
	 * <向数据库插入数据>
	 * 
	 * @param table
	 * @param map
	 */
	@Insert("INSERT INTO ${tab} "
			+ "<foreach collection='map.keys' item='key' open='(' close=')' separator=','>#{key}</foreach> "
			+ "VALUES <foreach collection='map.keys' item='key' open='(' close=')' separator=','>#{map[${key}]}</foreach>")
	void insert(@Param("tab") String table,
			@Param("map") Map<String, String> map);

	/**
	 * <向数据库插入数据>
	 * 
	 * @param table
	 * @param obj
	 * @param isInhert
	 */
	public default void insert(String table, T obj, boolean isInhert) {
		Class<?> clazz = obj.getClass();
		List<Field> fields = ReflectionUtil.getEntityField(clazz, isInhert);
		Objects.requireNonNull(table);
		Objects.requireNonNull(obj);
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO").append(table).append("(");
		fields.stream().forEach(e -> {
			builder.append(e.getName()).append(",");
		});
		builder.deleteCharAt(builder.length() - 1).append(")")
				.append("VALUES(");
		try {
			for (Field field : fields) {
				String a = field.getName().substring(0, 1);
				String b = field.getName().replaceFirst(a,
						a.toLowerCase(Locale.CHINA));
				Method getMethod;

				getMethod = clazz.getMethod("get" + b);
				builder.append("'").append(getMethod.invoke(obj)).append("'");
				builder.append(",");
			}
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			e1.printStackTrace();
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(")");
		innerInsert(builder.toString());
	}

	@Deprecated
	@Insert("${sql}")
	void innerInsert(@Param("sql") String sql);
}
