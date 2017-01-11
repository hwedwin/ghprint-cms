package com.ghprint.cms.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Ftp工具类
 */
public class FtpUtil {

    private static Logger logger = LoggerFactory.getLogger(FtpUtil.class);

    /**
     * 上传文件到指定目录
     *
     * @param ip
     * @param port
     * @param userName
     * @param userpwd
     * @param serverpath
     * @param file
     * @return
     */
    public static boolean uploadFile(String ip, int port, String userName, String userpwd, String serverpath,
                                     String file) {
        logger.info("method name : uploadFile");
        System.out.println("method name : uploadFile");
        InputStream input = null;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply = 0;
            ftp.connect(ip, port);
            boolean flag = ftp.login(userName, userpwd);
            if (!flag) {
                logger.info("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + userName + "->userpwd:" + userpwd);
                System.out.println("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + userName + "->userpwd:" + userpwd);
                return false;
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));

            if (!dirExits(ftp, iso8859ToGbk(serverpath))) {
                System.out.println("Create Directory failed:" + serverpath);
                return false;
            }

            file = gbkToIso8859(file);
            input = new FileInputStream(iso8859ToGbk(file));

            file = iso8859ToGbk(file);

            String fileAddr = iso8859ToGbk(serverpath) + "/" + iso8859ToGbk(getFilename(file));
            if (ftp.storeFile(fileAddr + ".ing", input)) {
                logger.info("开始重命名" + file + ".ing to " + file);
                ftp.rename(fileAddr + ".ing", fileAddr);
                return true;
            } else {
                logger.info("上传失败");
            }
        } catch (SocketException e) {
            logger.error(file + "上传文件SocketException，错误原因为" + e);
        } catch (IOException e) {
            logger.error(file + "上传文件IOException，错误原因为" + e);
        } finally {
            try {
                if (null != input) {
                    input.close();
                }
                if (null != ftp && ftp.isConnected()) {
                    ftp.logout();
                }
            } catch (IOException e) {
                logger.error(file + "上传文件finally IOException，错误原因为" + e);
            }
        }
        return false;
    }

    /**
     * 上传文件到指定目录
     *
     * @param ip
     * @param port
     * @param userName
     * @param userpwd
     * @param fileName
     * @param serverpath
     * @param file
     * @return
     */
    public static boolean uploadFile(String ip, int port, String userName, String userpwd, String serverpath,
                                     String file,String fileName) {
        System.out.println("ip:"+ip+"port:"+port+"userName:"+userName+"userpwd:"+userpwd+"serverpath:"+serverpath+"file:"+file+"fileName:"+fileName);
        logger.info("method name : uploadFile");
        System.out.println("method name : uploadFile");
        InputStream input = null;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply = 0;
            ftp.connect(ip, port);
            boolean flag = ftp.login(userName, userpwd);
            if (!flag) {
                logger.info("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + userName + "->userpwd:" + userpwd);
                System.out.println("登录Ftp失败 , ip:" + ip + "->port:" + port + "->username:" + userName + "->userpwd:" + userpwd);
                return false;
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));

            if (!dirExits(ftp, iso8859ToGbk(serverpath))) {
                System.out.println("Create Directory failed:" + serverpath);
                return false;
            }

            file = gbkToIso8859(file);
            input = new FileInputStream(iso8859ToGbk(file));

            String fileAddr = iso8859ToGbk(serverpath) + "/" + iso8859ToGbk(fileName);
            if (ftp.storeFile(fileAddr + ".ing", input)) {
                logger.info("开始重命名" + fileName + ".ing to " + fileName);
                ftp.rename(fileAddr + ".ing", fileAddr);
                return true;
            } else {
                logger.info("上传失败");
            }
        } catch (SocketException e) {
            logger.error(file + "上传文件SocketException，错误原因为" + e);
        } catch (IOException e) {
            logger.error(file + "上传文件IOException，错误原因为" + e);
        } finally {
            try {
                if (null != input) {
                    input.close();
                }
                if (null != ftp && ftp.isConnected()) {
                    ftp.logout();
                }
            } catch (IOException e) {
                logger.error(file + "上传文件finally IOException，错误原因为" + e);
            }
        }
        return false;
    }


    /**
     * 从指定FTP服务器下载文件到本地
     *
     * @param ip
     * @param username
     * @param password
     * @param serverPath
     * @param localPath
     * @return
     */
    public static boolean downFile(String ip, int port, String username, String password, String serverPath, String localPath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            serverPath = gbkToIso8859(serverPath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverPath));

            FTPFile[] fs = ftp.listFiles();
            localPath = gbkToIso8859(localPath);

            for (FTPFile f : fs) {
                File localFile = new File(iso8859ToGbk(localPath) + "/" + f.getName());
                File localFileDir = new File(iso8859ToGbk(localPath));
                if (!localFileDir.exists()) {
                    localFileDir.mkdirs();
                }
                OutputStream is = new FileOutputStream(localFile);
                success = ftp.retrieveFile(f.getName(), is);
                is.close();
            }
            ftp.logout();
        } catch (SocketException e) {
            logger.error("下载文件到本地失败", e);
        } catch (IOException e) {
            logger.error("下载文件到本地失败", e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return true;
    }

    /**
     * 从指定FTP服务器查询某文件是否存在
     *
     * @param ip
     * @param username
     * @param password
     * @param serverpath
     * @param fileName
     * @return
     */
    public static FTPFile checkFile(String ip, int port, String username, String password, String serverpath,
                                    String fileName) {

        FTPFile ftpFile = null;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");

        try {
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return ftpFile;
            }

            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));
            fileName = gbkToIso8859(fileName);
            FTPFile[] fs;
            if (fileName.indexOf("009_RECHARGE.BALANCE") >= 0) {
                fs = ftp.listFiles("ac");
                for (FTPFile f : fs) {
                    if (f.getName().matches(".*" + fileName + ".*")) {
                        ftpFile = f;
                        break;
                    }
                }

            } else {
                fs = ftp.listFiles(fileName);
                if (fs != null && fs.length == 1) {
                    ftpFile = fs[0];
                }

            }
            ftp.logout();
        } catch (SocketException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return ftpFile;
    }


    /**
     * 从指定FTP服务器查询某文件是否存在
     *
     * @param ip
     * @param username
     * @param password
     * @param serverpath
     * @param fileName
     * @return
     */
    public static List<FTPFile> checkFiles(String ip, int port, String username, String password, String serverpath,
                                           String fileName) {
        List<FTPFile> fileList = new ArrayList<FTPFile>();
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            ftp.connect(ip, port);
            ftp.login(username, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return fileList;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));
            fileName = gbkToIso8859(fileName);
            FTPFile[] fs;
            fs = ftp.listFiles();
            for (FTPFile f : fs) {
                if (f.getName().matches(".*" + fileName + ".*")) {
                    fileList.add(f);

                }
            }
            ftp.logout();
            return fileList;
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return fileList;
    }
    /**
     * 从指定FTP服务器查询文件列表
     *
     */
    public static List<String> filesNameList(String ip, int port, String username, String password, String serverpath) {
        List<String> fileList = new ArrayList<String>();
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            ftp.connect(ip, port);
            ftp.login(username, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            serverpath = gbkToIso8859(serverpath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverpath));
            FTPFile[] fs;
            fs = ftp.listFiles();
            for (FTPFile f : fs) {
                fileList.add(f.getName());
            }
            ftp.logout();
            return fileList;
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return fileList;
    }
    /**
     * 批量下载
     *
     * @param ip
     * @param port
     * @param userName
     * @param password
     * @param serverPath
     * @param localPath
     * @param fileNames
     * @return
     */
    public static boolean batchDownFile(String ip, int port, String userName, String password, String serverPath,
                                        String localPath, String[] fileNames) {
        logger.info("sss==" + ip + " " + port + "" + "" + serverPath);
        if (null != fileNames && fileNames.length > 0) {
            boolean flag;
            for (String fName : fileNames) {
                flag = downFileByName(ip, port, userName, password, serverPath, localPath, fName);
                if (!flag) {
                    logger.warn("远程文件：{}下载失败", serverPath + fName);
                }
            }
        }
        return true;
    }

    /**
     * 通过文件名，获取单个文件
     *
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param serverPath
     * @param localPath
     * @param fileName
     * @return
     */
    public static boolean downFileByName(String ip, int port, String username, String password, String serverPath,
                                         String localPath, String fileName) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        OutputStream is = null;
        try {
            ftp.setControlEncoding("UTF-8");
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            serverPath = gbkToIso8859(serverPath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverPath));


            fileName = gbkToIso8859(fileName);
            localPath = gbkToIso8859(localPath);

            File localFile = new File(iso8859ToGbk(localPath) + "/" + fileName);
            File localFileDir = new File(iso8859ToGbk(localPath));
            if (!localFileDir.exists()) {
                logger.info(localFileDir.getAbsolutePath() + "创建成功!");
                localFileDir.mkdirs();
            }
            is = new FileOutputStream(localFile);
            if (ftp.retrieveFile(fileName, is)) {
                logger.info("本地文件路径：" + localFile.getAbsolutePath());
                return true;
            } else {
                if (localFile.exists()) {
                    is.close();
                    is = null;
                    localFile.deleteOnExit();
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                }
                return false;
            }
        } catch (SocketException e) {
            logger.error(fileName + "下载文件SocketException，错误原因"+ e);
        } catch (IOException e) {
            logger.error(fileName + "下载文件IOException，错误原因"+ e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                    logger.error("", e);
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    logger.error("", ioe);
                }
            }
        }
        return false;
    }


    public static boolean downFileByDimName(String ip, int port, String username, String password, String serverPath,
                                            String localPath, String fileName) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        OutputStream is = null;
        List<String> fileNames = new ArrayList<String>();
        try {
            ftp.setControlEncoding("UTF-8");
            int reply;
            ftp.connect(ip, port);
            ftp.login(username, password);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 生产环境有防火墙 用该方法才能远程取文件
            // FTPClient为被动传输模式即可解决线程挂起问题。
            ftp.enterLocalPassiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            serverPath = gbkToIso8859(serverPath);
            ftp.changeWorkingDirectory(iso8859ToGbk(serverPath));
            FTPFile[] ftpFiles = ftp.listFiles();
            for (FTPFile file : ftpFiles) {
                String fName = file.getName();
                if (fName.matches(".*" + fileName + ".*")) {
                    fileNames.add(fName);
                }
            }
            if (fileNames.isEmpty()) {
                logger.warn("文件下载失败，匹配包含【{}】文件不存在！", fileName);
                success = false;
                return success;
            }
            for (String fn : fileNames) {
                fileName = gbkToIso8859(fn);
                localPath = gbkToIso8859(localPath);
                File localFile = new File(iso8859ToGbk(localPath) + File.separator + fileName);
                File localFileDir = new File(iso8859ToGbk(localPath));
                if (!localFileDir.exists()) {
                    localFileDir.mkdirs();
                    logger.info(localFileDir.getAbsolutePath() + "创建成功!");
                }
                is = new FileOutputStream(localFile);
                if (ftp.retrieveFile(fileName, is)) {
                    logger.info("本地文件路径：" + localFile.getAbsolutePath());
                    if (!success) {
                        success = true;
                    }
                } else {
                    if (localFile.exists()) {
                        logger.warn("【{}】本地已存在该文件!", localFile.getAbsolutePath());
                    } else {
                        logger.error("文件【{}】下载失败!", localFile.getAbsolutePath());
                    }
                }
            }
            return success;
        } catch (SocketException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ftp) {
                try {
                    ftp.logout();
                } catch (IOException e) {
                    logger.error("", e);
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    logger.error("", ioe);
                }
            }
        }
        return false;
    }

    private static String getFilename(String file) {
        String filename = "";
        if (file != null && !file.equals("")) {
            file = file.replaceAll(Matcher.quoteReplacement("//"), "/");
            String[] strs = file.split("/");
            filename = strs[strs.length - 1];
        }
        filename = gbkToIso8859(filename);
        return filename;
    }

    private static String gbkToIso8859(Object obj) {
        try {
            if (obj == null) {
                return "";
            } else {
                return new String(obj.toString().getBytes("GBK"), "iso-8859-1");
            }
        } catch (Exception e) {
            return "";
        }
    }

    private static String iso8859ToGbk(Object obj) {
        try {
            if (obj == null) {
                return "";
            } else {
                return new String(obj.toString().getBytes("iso-8859-1"), "GBK");
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean dirExits(FTPClient ftp, String serverPath) {
        try {
            if (serverPath.startsWith("/")) {
                ftp.changeWorkingDirectory("/");
                if (!serverPath.endsWith("/")) {
                    serverPath += "/";
                }
                int start = 1;
                int end = serverPath.indexOf("/", start);
                boolean flag = true;
                while (flag && start < end) {
                    String subDirectory = new String(serverPath.substring(start, end).getBytes("GBK"), "iso-8859-1");
                    if (!ftp.changeWorkingDirectory(subDirectory)) {
                        if (ftp.makeDirectory(subDirectory)) {
                            ftp.changeWorkingDirectory(subDirectory);
                            System.out.println("Create Directory (" + subDirectory + ") success!");
                        }
                    }
                    start = end + 1;
                    end = serverPath.indexOf("/", start);
                }
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
