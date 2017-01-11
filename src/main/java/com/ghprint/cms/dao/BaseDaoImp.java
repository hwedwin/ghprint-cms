package com.ghprint.cms.dao;

import com.ghprint.cms.pagination.Page;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseDaoImp
 * @Description: iBatis DAO层泛型基类，实现了基本的DAO功能 利用了Spring的SqlSessionTemplate功能
 * @author 庞超
 * @param <T>
 *            实体类
 * @param <PK>
 *            主键类，必须实现Serializable接口
 * @date 2013-11-15 上午10:09:33
 * 
 */
public abstract class BaseDaoImp<T, PK extends Serializable> implements
		BaseDao<T, PK> {
	/**
	* @Fields SQLID_INSERT : 添加默认值设置
    * @Fields SQLID_UPDATE : 更新默认值设置
	* @Fields SQLID_DELETE : 删除默认值设置
	* @Fields SQLID_TRUNCATE : 删除结构默认值设置
	* @Fields SQLID_SELECT : 查询默认值设置
	* @Fields SQLID_SELECT_PAGE : 分页查询默认值设置
	* @Fields SQLID_SELECT_PK : 主键查询默认值设置
	* @Fields SQLID_COUNT : 查询记录数默认值设置
	*/
	public static final String SQLID_INSERT = "insert";
	public static final String SQLID_UPDATE = "update";
	public static final String SQLID_DELETE = "delete";
	public static final String SQLID_TRUNCATE = "truncate";
	public static final String SQLID_SELECT = "select";
	public static final String SQLID_SELECT_PAGE = "selectPage";
	public static final String SQLID_SELECT_PK = "selectPk";
	public static final String SQLID_COUNT = "count";
	/**
	* @Fields sessionTemplate : 把sessionTemplate注入 ,从而使用它下面的CRUD方法进行操作
	* @Fields spaceName : 获取mybatis命名空间名字
	*/
	@Autowired
	public SqlSessionTemplate sessionTemplate;
	protected String spaceName;
	
	public BaseDaoImp() {
	}
	public BaseDaoImp(String spaceName) {
		this.spaceName=spaceName;
	}
	/** 
	* @Title: 插入操作 
	* @Description: 这里用一句话描述这个方法的作用 
	* @param entity 实体对象
	* @return null
	* @throws 
	*/ 
	public int insert(T entity) {
		return sessionTemplate.insert(spaceName + "." + SQLID_INSERT, entity);
	}
	/** 
	* @Title: 插入操作 
	* @Description: 这里用一句话描述这个方法的作用 
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param entity 实体对象
	* @return null
	* @throws 
	*/ 
	public int insert(String sqlId, T entity) {
		return sessionTemplate.insert(spaceName + "." + sqlId, entity);
	}
	/** 
	* @Title: 插入操作 
	* @Description: 这里用一句话描述这个方法的作用 
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param map 存入多个参数
	* @return null
	* @throws 
	*/ 
	public int insert(String sqlId, Map<String, Object> map) {
		return sessionTemplate.insert(spaceName + "." + sqlId, map);
	}
	
	/** 
	* @Title: 更新操作
	* @Description: 对应实体里的字段作为参数进行更新操作
	* @param entity  实体对象
	* @return int
	* @throws 
	*/
	public int update(T entity) {
		return sessionTemplate.update(spaceName + "." + SQLID_UPDATE, entity);
	}
	/** 
	* @Title: 更新操作
	* @Description: 对应实体里的字段作为参数进行更新操作
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param entity  实体对象
	* @return int
	* @throws 
	*/
	public int update(String sqlId, T entity) {
		return sessionTemplate.update(spaceName + "." + sqlId, entity);
	}
	/** 
	* @Title: 更新操作
	* @Description: 对应实体里的字段作为参数进行更新操作
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param map 存入多个参数
	* @return int
	* @throws 
	*/
	public int update(String sqlId, Map<String, Object> map) {
		return sessionTemplate.update(spaceName + "." + sqlId, map);
	}

	/** 
	* @Title: 删除操作
	* @Description: 根据主键删除记录
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	public int delete(PK primaryKey) {
		int rows = sessionTemplate.delete(spaceName + "." + SQLID_DELETE,
				primaryKey);
		return rows;
	}
	
	/** 
	* @Title: 删除操作
	* @Description: 根据主键删除记录
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	public int delete(String sqlId, PK primaryKey) {
		int rows = sessionTemplate.delete(spaceName + "." + sqlId, primaryKey);
		return rows;
	}
	/**
	 * @Title: 删除操作
	 * @Description: 根据id删除记录
	 * @param sqlId  对应mapper.xml 的方法id名字
	 * @param map 存放参数
	 * @return int
	 * @throws
	 */
	public int deleteByID(String sqlId, Map map) {
		int rows = sessionTemplate.delete(spaceName + "." + sqlId, map);
		return rows;
	}

	/** 
	* @Title: 删除结构操作
	* @Description: 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间）此方法一定要慎用！
	* @return int
	* @throws 
	*/
	public int truncate() {
		int rows = sessionTemplate.delete(spaceName + "." + SQLID_TRUNCATE);
		return rows;
	}
	/** 
	* @Title: 删除结构操作
	* @Description: 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间）此方法一定要慎用！
	* @param sqlId  对应mapper.xml 的方法id名字
	* @return int
	* @throws 
	*/
	public int truncate(String sqlId) {
		int rows = sessionTemplate.delete(spaceName + "." + sqlId);
		return rows;
	}

	/** 
	* @Title: 聚合操作
	* @Description: 查询表记录数
	* @return int
	* @throws 
	*/
	public int count() {
		Integer count = (Integer) sessionTemplate.selectOne(spaceName + "."
				+ SQLID_COUNT);
		return count.intValue();
	}

	/**
	 * @Title: 聚合操作
	 * @Description: 查询表记录数
	 * @return int
	 * @throws
	 */
	public int count(String sqlId) {
		Integer count = (Integer) sessionTemplate.selectOne(spaceName + "."
				+ sqlId);
		return count.intValue();
	}

	/**
	 * @Title: 聚合操作
	 * @Description: 查询表记录数
	 * @return int
	 * @throws
	 */
	public int count(String sqlId, Object Parameter) {
		Integer count = (Integer) sessionTemplate.selectOne(spaceName + "."
				+ sqlId, Parameter);
		return count.intValue();
	}
	
	/** 
	* @Title: 查询操作
	* @Description: 按主键获取记录
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	public T get(PK primaryKey) {
		return (T) sessionTemplate.selectOne(spaceName + "." + SQLID_SELECT_PK,
				primaryKey);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按主键获取记录
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	public T get(String sqlId, PK primaryKey) {
		return (T) sessionTemplate.selectOne(spaceName + "." + sqlId,
				primaryKey);
	}
	/**
	 * @Title: 查询操作
	 * @Description: 根据参数获取记录
	 * @param sqlId  对应mapper.xml 的方法id名字
	 * @param:  传入的参数
	 * @return T
	 * @throws
	 */
	public Map querySingle(String sqlId, String id) {
		return sessionTemplate.selectOne(spaceName + "." + sqlId, id);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按唯一键字段取记录
	* @param name 唯一列的名字
	* @return int
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	public T get(Object Parameter) {
		return (T) sessionTemplate.selectOne(spaceName + "." + SQLID_SELECT_PK,
				Parameter);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按唯一键字段取记录
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param name 唯一列的名字
	* @return int
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	public T get(String sqlId, Object Parameter) {
		return (T) sessionTemplate.selectOne(spaceName + "." + sqlId, Parameter);
	}
	/** 
	* @Title: 查询操作
	* @Description: 获取当前对象的所有记录集合
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select() {
		return sessionTemplate.selectList(spaceName + "." + SQLID_SELECT);
	}
	/** 
	* @Title: 查询操作
	* @Description: 获取当前对象的所有记录集合
	* @param sqlId  对应mapper.xml 的方法id名字
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(String sqlId) {
		return sessionTemplate.selectList(spaceName + "." + sqlId);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param entity 实体对象
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(Object obj) {
		return sessionTemplate.selectList(spaceName + "." + SQLID_SELECT, obj);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param entity 实体对象
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(String sqlId, Object obj) {
		return sessionTemplate.selectList(spaceName + "." + sqlId, obj);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param map 存入多个参数
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(Map<String, Object> map) {
		return sessionTemplate.selectList(spaceName + "." + SQLID_SELECT, map);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param map 存入多个参数
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(String sqlId, Map<String, Object> map) {
		return sessionTemplate.selectList(spaceName + "." + sqlId, map);
	}

	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的分页记录集合
	* @param page 存入查询参数和页码
	* @return List 返回集合
	* @throws 
	*/
	public List<T> selectPage(Page<T> page) {
		return sessionTemplate.selectList(spaceName + "." + SQLID_SELECT_PAGE,
				page);
	}
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的分页记录集合
    * @param sqlId  对应mapper.xml 的方法id名字
	* @param page 存入查询参数和页码
	* @return List 返回集合
	* @throws 
	*/
	public List<T> selectPage(String sqlId, Page<T> page) {
		return sessionTemplate.selectList(spaceName + "." + sqlId, page);
	}

	/** 
	* @Title: 插入操作
	* @Description: 实现批量插入
	* @param list 所要插入的数据
	* @return null
	* @throws 
	*/
	public void batchInsert(final List<T> list) {
		sessionTemplate.insert(spaceName + "." + SQLID_INSERT, list);
	}
	/** 
	* @Title: 插入操作
	* @Description: 实现批量插入
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param list 所要插入的数据集合
	* @return null
	* @throws 
	*/
	public int batchInsert(String sqlId, final List<T> list) {
		return sessionTemplate.insert(spaceName + "." + sqlId, list);
	}

	/** 
	* @Title: 修改操作
	* @Description:实现批量修改
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public void batchUpdate(final List<T> list) {
		sessionTemplate.update(spaceName + "." + SQLID_UPDATE, list);
	}
	/** 
	* @Title: 修改操作
	* @Description:实现批量修改
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public void batchUpdate(String sqlId, final List<T> list) {
		sessionTemplate.update(spaceName + "." + sqlId, list);
	}
	/** 
	* @Title: 删除操作
	* @Description:实现批量删除
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public void batchDelete(final List<PK> list) {
		sessionTemplate.delete(spaceName + "." + SQLID_DELETE, list);
	}
	/** 
	* @Title: 删除操作
	* @Description:实现批量删除
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public void batchDelete(String sqlId, final List<PK> list) {
		sessionTemplate.delete(spaceName + "." + sqlId, list);
	}
	
	/**
	 * 查询一些非list结果
	 * @param sqlId  对应mapper.xml 的方法id名字
	 * @param obj 对象
	 * @return 返回查询结果
	 */
	public String selectOther(String sqlId, Object obj) {
		return sessionTemplate.selectOne(spaceName + "." + sqlId, obj);
	}
	/** 
	* @Title: 删除操作
	* @Description:实现批量删除
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param T 所要更新的实体
	* @return null
	* @throws 
	*/
	public void batchDelete(String sqlId, T entity) {
		sessionTemplate.delete(spaceName + "." + sqlId, entity);
	}
}
