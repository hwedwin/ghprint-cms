package com.ghprint.cms.common.util;/*
package cn.com.bestpay.cms.common.util;

import FileUpload;
import FDFSException;
import CommonException;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FdfsUtil {
	private static Logger log = LoggerFactory.getLogger(FdfsUtil.class);
	private static TrackerClient trackerClient = null;
	private static StorageClient storageClient;

	// 初始化配置信息
	public static void init() {
		String classPath = new File(FdfsUtil.class.getResource("/").getFile()).getPath();
		log.info("==>>fastdfs初始化配置信息");
		log.info("==>>类路径: " + classPath);
		String configFilePath = classPath + File.separator + "fdfs_client.conf";
		log.info("==>>配置文件:" + configFilePath);
		try {
			ClientGlobal.init(configFilePath);
			trackerClient = new TrackerClient();
			boolean valib = ProtoCommon.activeTest(trackerClient.getConnection().getSocket());
			log.info("valib:" + valib);
			log.info("==>>fastdfs配置信息初始化成功");
			storageClient = new StorageClient(trackerClient.getConnection(), null);

		} catch (Exception e) {
			log.error("===>>>初始化fastdfs配置信息失败");
			throw new RuntimeException("初始化fastdfs配置信息失败");
		}
	}

	*/
/**
	 * @throws Exception
	 * @throws FDFSException
	 * 
	 * @Title: upLoad
	 * @Description: 文件上传
	 * @param @param ins
	 * @param fileName
	 *                 文件后
	 * @param @return
	 * @param @throws IOException
	 * @param @throws MyException
	 * @return FileUpload
	 * @author Tangyinbo
	 * @throws
	 *//*

	@SuppressWarnings("finally")
	public static Map<String, String> upLoad(String fileName, InputStream ins) throws Exception {
		// 保存文件存储的详细信息
		Map<String, String> uploadmes = new HashMap<String, String>();
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient storageClient = null;
		try {
			trackerServer = trackerClient.getConnection();
			storageClient = new StorageClient(trackerServer, storageServer);

			String fileId = "";
			String fileExtName = "";
			if (fileName.contains(".")) {
				fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
			} else {
				log.error("Fail to upload file, because the format of filename is illegal.");
				throw new FDFSException("fdfs文件上传指定了非法的文件名");
			}
			NameValuePair[] meta_list = new NameValuePair[3];
			InputStream fis = ins;
			byte[] file_buff = null;
			if (fis != null) {
				meta_list[0] = new NameValuePair("fileName", fileName);
				meta_list[1] = new NameValuePair("fileExtName", fileExtName);
				meta_list[2] = new NameValuePair("fileLength", String.valueOf(ins.available()));
				int len = fis.available();
				file_buff = new byte[len];
				fis.read(file_buff);
			} else {
				log.error("===>>>上传的文件不能为空");
				throw new FDFSException("上传的文件不能为空");
			}
			log.info("==>>file length: " + file_buff.length);

			String group_name = null;
			StorageServer[] storageServers = trackerClient.getStoreStorages(trackerServer, group_name);
			if (storageServers == null) {
				log.error("===>>>get store storage servers fail, error code: " + storageClient.getErrorCode());
				throw new FDFSException("获取storage servers 失败");
			} else {
				log.info("==>>store storage servers count: " + storageServers.length);
				for (int k = 0; k < storageServers.length; k++) {
					log.info("==>>" + k + 1 + ". " + storageServers[k].getInetSocketAddress().getAddress().getHostAddress() + ":" + storageServers[k].getInetSocketAddress().getPort());
				}
			}

			long startTime = System.currentTimeMillis();
			String[] results = storageClient.upload_file(file_buff, fileExtName, meta_list);
			log.info("==>>upload_file time used: " + (System.currentTimeMillis() - startTime) + " ms");

			if (results == null) {
				log.error("===>>>upload file fail, error code: " + storageClient.getErrorCode());
				throw new FDFSException("文件上传失败");
			}

			group_name = results[0];
			String remote_filename = results[1];
			uploadmes.put(FdfsConstant.FDFS_UPLOAD_GROUPNAME, group_name);
			uploadmes.put(FdfsConstant.FDFS_UPLOAD_REMOTEFILENAME, remote_filename);
			log.info("==>>group_name: " + group_name + ", remote_filename: " + remote_filename);
			log.info("==>>" + storageClient.get_file_info(group_name, remote_filename));
			*/
/*
			 * ServerInfo[] servers = trackerClient.getFetchStorages(trackerServer, group_name, remote_filename); if (servers == null){ log.info("===>>>get storage servers fail, error code: " + trackerClient.getErrorCode()); } else { log.info("storage servers count: " + servers.length); for (int k = 0; k < servers.length; k++){ log.info("==>>>"+k + 1 + ". " + servers[k].getIpAddr() + ":" + servers[k].getPort()); } }
			 *//*


		} catch (FDFSException e) {
			log.error(e.getMessage());
			throw new FDFSException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (trackerServer != null)
					trackerServer.close();
			} catch (IOException e) {
				log.error("===>>>trackerServer关闭失败");
				e.printStackTrace();
			}
			try {
				if (storageServer != null)
					storageServer.close();
			} catch (IOException e) {
				log.error("===>>>storageServer关闭失败");
				e.printStackTrace();
			}
			return uploadmes;
		}
	}

	*/
/**
	 * @throws Exception
	 * @throws FDFSException
	 * 
	 * @Title: upLoad
	 * @Description: 文件上传,可以修改
	 * @param @param ins
	 * @param fileName
	 * @param @return
	 * @param @throws IOException
	 * @param @throws MyException
	 * @return FileUpload
	 * @author Tangyinbo
	 * @throws
	 *//*

	@SuppressWarnings("finally")
	public static Map<String, String> upLoad_appender_file(String fileName, InputStream ins) throws Exception {
		// 保存文件存储的详细信息
		Map<String, String> uploadmes = new HashMap<String, String>();
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient storageClient = null;
		try {
			trackerServer = trackerClient.getConnection();
			storageClient = new StorageClient(trackerServer, storageServer);

			String fileId = "";
			String fileExtName = "";
			if (fileName.contains(".")) {
				fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
			} else {
				log.error("Fail to upload file, because the format of filename is illegal.");
				throw new FDFSException("fdfs文件上传指定了非法的文件名");
			}
			NameValuePair[] meta_list = new NameValuePair[3];
			InputStream fis = ins;
			byte[] file_buff = null;
			if (fis != null) {
				meta_list[0] = new NameValuePair("fileName", fileName);
				meta_list[1] = new NameValuePair("fileExtName", fileExtName);
				meta_list[2] = new NameValuePair("fileLength", String.valueOf(ins.available()));
				int len = fis.available();
				file_buff = new byte[len];
				fis.read(file_buff);
			} else {
				log.error("===>>>上传的文件不能为空");
				throw new FDFSException("上传的文件不能为空");
			}
			log.info("==>>file length: " + file_buff.length);

			String group_name = null;
			StorageServer[] storageServers = trackerClient.getStoreStorages(trackerServer, group_name);
			if (storageServers == null) {
				log.error("===>>>get store storage servers fail, error code: " + storageClient.getErrorCode());
				throw new FDFSException("获取storage servers 失败");
			} else {
				log.info("==>>store storage servers count: " + storageServers.length);
				for (int k = 0; k < storageServers.length; k++) {
					log.info("==>>" + k + 1 + ". " + storageServers[k].getInetSocketAddress().getAddress().getHostAddress() + ":" + storageServers[k].getInetSocketAddress().getPort());
				}
			}

			long startTime = System.currentTimeMillis();
			String[] results = storageClient.upload_appender_file(file_buff, fileExtName, meta_list);
			log.info("==>>upload_file time used: " + (System.currentTimeMillis() - startTime) + " ms");

			if (results == null) {
				log.error("===>>>upload file fail, error code: " + storageClient.getErrorCode());
				throw new FDFSException("文件上传失败");
			}

			group_name = results[0];
			String remote_filename = results[1];
			uploadmes.put(FdfsConstant.FDFS_UPLOAD_GROUPNAME, group_name);
			uploadmes.put(FdfsConstant.FDFS_UPLOAD_REMOTEFILENAME, remote_filename);
			log.info("==>>group_name: " + group_name + ", remote_filename: " + remote_filename);
			log.info("==>>" + storageClient.get_file_info(group_name, remote_filename));
			*/
/*
			 * ServerInfo[] servers = trackerClient.getFetchStorages(trackerServer, group_name, remote_filename); if (servers == null){ log.info("===>>>get storage servers fail, error code: " + trackerClient.getErrorCode()); } else { log.info("storage servers count: " + servers.length); for (int k = 0; k < servers.length; k++){ log.info("==>>>"+k + 1 + ". " + servers[k].getIpAddr() + ":" + servers[k].getPort()); } }
			 *//*


		} catch (FDFSException e) {
			log.error(e.getMessage());
			throw new FDFSException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (trackerServer != null)
					trackerServer.close();
			} catch (IOException e) {
				log.error("===>>>trackerServer关闭失败");
				e.printStackTrace();
			}
			try {
				if (storageServer != null)
					storageServer.close();
			} catch (IOException e) {
				log.error("===>>>storageServer关闭失败");
				e.printStackTrace();
			}
			return uploadmes;
		}
	}

	*/
/**
	 * 
	 * @Title: download
	 * @Description: 下载文件获取字节数组
	 * @param @param groupName
	 * @param @param remoteFileName
	 * @param @return
	 * @return byte[]
	 * @author Tangyinbo
	 * @throws
	 *//*

	public static byte[] download(String groupName, String remoteFileName) {
		TrackerServer trackerServer = null;
		StorageClient storageClient = null;
		try {
			log.info("==>文件下载开始,组名:" + groupName + "   文件id" + remoteFileName);
			trackerServer = trackerClient.getConnection();
			StorageServer storageServer = null;
			storageClient = new StorageClient(trackerServer, storageServer);
			byte[] b = storageClient.download_file(groupName, remoteFileName);
			log.info("==>文件大小:" + b.length / 1024.0 + "k");
			return b;
		} catch (Exception e) {
			log.error("===>>>文件下载失败",e);
			return null;
		} finally {
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					log.error("===>>>trackerServer 关闭失败...", e);
				}
			}
		}
	}

	*/
/**
	 * @throws CommonException
	 * 
	 * @Title: deleteFile
	 * @Description: 删除文件
	 * @param @param groupName
	 * @param @param remoteFileName
	 * @param @return
	 * @param @throws IOException
	 * @param @throws MyException
	 * @return int
	 * @author Tangyinbo
	 * @throws
	 *//*

	public static void deleteFile(String groupName, String remoteFileName) throws CommonException {
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		try {
			trackerServer = trackerClient.getConnection();
			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			int effect = storageClient.delete_file(groupName, remoteFileName);
			if (effect == 0) {
				log.info("==>>fdfs删除  [" + groupName + "/" + remoteFileName + " ] 成功");
			} else {
				log.info("==>>fdfs删除  [" + groupName + "/" + remoteFileName + " ] 失败");
				throw new CommonException("===>>>fdfs删除文件 失败");
			}
		} catch (IOException e) {
			log.error("===>>> fdfs获取trackerServer 异常", e);
			throw new CommonException("fdfs获取trackerServer 异常");
		} catch (MyException e) {
			log.error("===>>> fdfs删除文件 [" + groupName + "/" + remoteFileName + " ]异常", e);
			throw new CommonException("fdfs删除文件  异常");
		} finally {
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					log.error("===>>>trackerServer 关闭失败...", e);
				}
			}
		}
	}

	*/
/**
	 * 
	 * @Title: testDelete
	 * @Description: fastdfs 删除文件
	 * @param @param model
	 * @param @throws Exception
	 * @return void
	 * @author Tangyinbo
	 * @throws
	 *//*

	public static void testDelete(FileUpload model) throws Exception {
		try {
			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;

			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			int i = storageClient.delete_file(model.getGroupId(), model.getPath());
			log.info(i == 0 ? "删除成功" : "删除失败:" + i);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	*/
/**
	 * 
	 * @Title: modify_file
	 * @Description: 清空资源文件,并且重新写入
	 * @param @param groupName
	 * @param @param remoteFileName
	 * @param @param bt
	 * @param @throws Exception
	 * @return void
	 * @author Tangyinbo
	 * @throws
	 *//*

	public static void modify_file_truncate(String groupName, String remoteFileName, byte[] bt) throws Exception {
		StorageServer storageServer = null;
		StorageClient storageClient = null;
		try {
			TrackerServer trackerServer = trackerClient.getConnection();
			storageClient = new StorageClient(trackerServer, storageServer);
			int truncate = storageClient.truncate_file(groupName, remoteFileName);
			if (truncate == 0) {
				log.info("==>>格式化  ->" + groupName + "/" + remoteFileName + "成功");
				int i = storageClient.modify_file(groupName, remoteFileName, 0, bt);
				if (i == 0) {
					log.info("==>>修改 ->" + groupName + "/" + remoteFileName + "成功");
				} else {
					log.info("==>>修改 ->" + groupName + "/" + remoteFileName + "失败");
					throw new CommonException("fdfs文件修改失败");
				}
			} else {
				log.info("==>>格式化  ->" + groupName + "/" + remoteFileName + "失败");
				throw new CommonException("fdfs文件格式化失败");
			}

		} catch (Exception e) {
			log.error("", e);
			throw e;
		} finally {
			if (storageServer != null) {
				storageServer.close();
			}
		}
	}
}
*/
