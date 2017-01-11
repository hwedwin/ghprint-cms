package com.ghprint.cms.common.util;

/**
 * 
* @ClassName: FsfsConstant
* @Description: fastDfs常量
* @author Tangyinbo
* @date 2014-1-2 下午2:50:40
*
 */
public class FdfsConstant{
	public static final String COMMON_PATH = "common";
	//保存storage群组名称
	public static final String FDFS_UPLOAD_GROUPNAME="group_name";
	//远程文件名
	public static final String FDFS_UPLOAD_REMOTEFILENAME="file_name";
	/**
	 * fdfs服务器ip,port
	 */
	public static final String FASTDFS_SERVER_URL = ConfigReader.readConfig(COMMON_PATH, "FASTDFS_SERVER_URL");
}
