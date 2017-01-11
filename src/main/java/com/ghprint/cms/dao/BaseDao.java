package com.ghprint.cms.dao;

import com.ghprint.cms.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseDao
 * @Description: BaseDao DAO层泛型接口，定义基本的DAO功能
 * @author 庞超
 * @param <T>
 *            实体类
 * @param <PK>
 *            主键类，必须实现Serializable接口
 * @date 2013-11-15 上午10:09:33
 * 
 */
public abstract interface BaseDao<T, PK extends Serializable> {
	/** 
	* @Title: 插入操作 
	* @Description: 这里用一句话描述这个方法的作用 
	* @param entity 实体对象
	* @return null
	* @throws 
	*/ 
	public abstract int insert(T entity);
	/** 
	* @Title: 插入操作 
	* @Description: 这里用一句话描述这个方法的作用 
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param entity 实体对象
	* @return null
	* @throws 
	*/ 
	public abstract int insert(String sqlId, T entity);
	/** 
	* @Title: 插入操作 
	* @Description: 这里用一句话描述这个方法的作用 
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param map 存入多个参数
	* @return null
	* @throws 
	*/ 
	public abstract int insert(String sqlId, Map<String, Object> map);

	/** 
	* @Title: 更新操作
	* @Description: 对应实体里的字段作为参数进行更新操作
	* @param entity  实体对象
	* @return int
	* @throws 
	*/
	public abstract int update(T entity);
	/** 
	* @Title: 更新操作
	* @Description: 对应实体里的字段作为参数进行更新操作
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param entity  实体对象
	* @return int
	* @throws 
	*/
	public abstract int update(String sqlId, T entity);
	/** 
	* @Title: 更新操作
	* @Description: 对应实体里的字段作为参数进行更新操作
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param map 存入多个参数
	* @return int
	* @throws 
	*/
	public abstract int update(String sqlId, Map<String, Object> map);

	/** 
	* @Title: 删除操作
	* @Description: 根据主键删除记录
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	public abstract int delete(PK primaryKey);
	/** 
	* @Title: 删除操作
	* @Description: 根据主键删除记录
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	public abstract int delete(String sqlId, PK primaryKey);

	/** 
	* @Title: 删除结构操作
	* @Description: 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间）此方法一定要慎用！
	* @return int
	* @throws 
	*/
	public abstract int truncate();
	/** 
	* @Title: 删除结构操作
	* @Description: 清空表，比delete具有更高的效率，而且是从数据库中物理删除（delete是逻辑删除，被删除的记录依然占有空间）此方法一定要慎用！
	* @param sqlId  对应mapper.xml 的方法id名字
	* @return int
	* @throws 
	*/
	public abstract int truncate(String sqlId);

	/** 
	* @Title: 聚合操作
	* @Description: 查询表记录数
	*/
	public abstract int count();
	/** 
	* @Title: 聚合操作
	* @Description: 查询表记录数
	* @return int
	* @throws 
	*/
	public abstract int count(String sqlId);

	/**
	 * @Title: 聚合操作
	 * @Description: 查询表记录数
	 * @return int
	 * @throws
	 */
	public abstract int count(String sqlId, Object Parameter);

	/**
	 * @Title: 查询操作
	 * @Description: 按主键获取记录
	 * @param primaryKey
	 *            主键值
	 * @return int
	 * @throws
	 */
	public abstract T get(PK primaryKey);
	/** 
	* @Title: 查询操作
	* @Description: 按主键获取记录
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param primaryKey 主键值
	* @return int
	* @throws 
	*/
	public abstract T get(String sqlId, PK primaryKey);

	/**
	 * @Title: 查询操作
	 * @Description: 按唯一键字段取记录
	 * @return int
	 * @throws
	 */
	public T get(Object Parameter);

	/**
	 * @Title: 查询操作
	 * @Description: 按唯一键字段取记录
	 * @param sqlId
	 *            对应mapper.xml 的方法id名字
	 * @return int
	 * @throws
	 */
	public T get(String sqlId, Object Parameter);

	/**
	 * @Title: 查询操作
	 * @Description: 获取当前对象的所有记录集合
	 * @return List 返回集合
	 * @throws
	 */
	public abstract List<T> select();
	/** 
	* @Title: 查询操作
	* @Description: 获取当前对象的所有记录集合
	* @param sqlId  对应mapper.xml 的方法id名字
	* @return List 返回集合
	* @throws 
	*/	
	public abstract List<T> select(String sqlId);

	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param entity 实体对象
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(Object entity);
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param entity 实体对象
	* @return List 返回集合
	* @throws 
	*/
	public List<T> select(String sqlId, Object entity);
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param map 存入多个参数
	* @return List 返回集合
	* @throws 
	*/	
	public abstract List<T> select(Map<String, Object> map);
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的记录集合
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param map 存入多个参数
	* @return List 返回集合
	* @throws 
	*/
	public abstract List<T> select(String sqlId, Map<String, Object> map);

	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的分页记录集合
	* @param page 存入查询参数和页码
	* @return List 返回集合
	* @throws 
	*/
	public abstract List<T> selectPage(Page<T> page);
	/** 
	* @Title: 查询操作
	* @Description: 按条件获取当前对象的分页记录集合
    * @param sqlId  对应mapper.xml 的方法id名字
	* @param page 存入查询参数和页码
	* @return List 返回集合
	* @throws 
	*/
	public abstract List<T> selectPage(String sqlId, Page<T> page);

	/** 
	* @Title: 插入操作
	* @Description: 实现批量插入
	* @param list 所要插入的数据
	* @return null
	* @throws 
	*/
	public abstract void batchInsert(final List<T> list);
	/** 
	* @Title: 插入操作
	* @Description: 实现批量插入
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param list 所要插入的数据集合
	* @return null
	* @throws 
	*/
	public abstract int batchInsert(String sqlId, final List<T> list);

	/** 
	* @Title: 修改操作
	* @Description:实现批量修改
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public abstract void batchUpdate(final List<T> list);
	/** 
	* @Title: 修改操作
	* @Description:实现批量修改
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public abstract void batchUpdate(String sqlId, final List<T> list);

	/** 
	* @Title: 删除操作
	* @Description:实现批量删除
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public abstract void batchDelete(final List<PK> list);
	/** 
	* @Title: 删除操作
	* @Description:实现批量删除
	* @param sqlId  对应mapper.xml 的方法id名字
	* @param list 所要更新的数据集合
	* @return null
	* @throws 
	*/
	public abstract void batchDelete(String sqlId, final List<PK> list);
	/** 
	* @Title: 删除操作
	* @Description:实现批量删除
	* @param sqlId  对应mapper.xml 的方法id名字
	* @return null
	* @throws 
	*/
	public void batchDelete(String sqlId, T entity);
}
