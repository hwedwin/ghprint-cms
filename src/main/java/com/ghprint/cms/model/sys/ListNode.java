package com.ghprint.cms.model.sys;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ListNode</p>
 *
 * <p>Description: 字典项视图 </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: ccit</p>
 *
 * @author huchangqing
 * @version 1.0
 * @since Jun 13, 2009
 */
public class ListNode implements Serializable, Cloneable, Comparable {
	private static Logger logger = LoggerFactory.getLogger(ListNode.class);
	/**
	 * the key object
	 */
	private String key;

	/**
	 * the value object
	 */
	private String value;
	/**
	   * listnode list
	   */
	private List listNodeList;

	/**
	 * parent key
	 */
	private String parentKey;

	/**
	 * listnode description
	 */
	private String description;
	private String grade;
	private String gradeName;

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * default constructor
	 */
	public ListNode() {
	}

	/**
	 * The constructor of having key and value form parameter
	 *
	 * @param key String
	 * @param value String
	 */
	public ListNode(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * get key object
	 *
	 * @return String
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @see getKey method
	 *
	 * @param key String
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * get value object
	 *
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @see getValue method
	 *
	 * @param value String
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * overcast super clone
	 *
	 * @return Object
	 */
	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException exception) {
			logger.error("ListNode is not Cloneable : ", exception);
		}
		return object;
	}

	/**
	 * Compares this object with the specified object for order.
	 *
	 * @param o the Object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *   less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Object o) {
		String value = this.getValue();
		if (value == null) {
			return -1;
		}
		if (!(o instanceof ListNode)) {
			return -1;
		}
		return this.getValue().compareTo(((ListNode) o).getValue());
	}

	/**
	 * overcast super equals method by value
	 *
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		String value = this.getValue();
		if (value == null) {
			return false;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ListNode)) {
			return false;
		}
		return this.getValue().equals(((ListNode) obj).getValue());
	}

	/**
	 * Read Object by stream
	 *
	 * @param ois ObjectInputStream
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
	}

	/**
	 * Write Object by stream
	 *
	 * @param oos ObjectOutputStream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
	}

	public List getListNodeList() {
		return listNodeList;
	}

	public void setListNodeList(List listNodeList) {
		this.listNodeList = listNodeList;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
