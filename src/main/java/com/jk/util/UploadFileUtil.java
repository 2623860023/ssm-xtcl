package com.jk.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;



public class UploadFileUtil {
//方法接收的参数:@RequestParam(value="image")CommonsMultipartFile filedata,HttpServletRequest request
	public static String upload(CommonsMultipartFile fileimg,HttpServletRequest request) throws Exception{
		//获取上传图片名称
		String filename=fileimg.getOriginalFilename();
		//要给图片重命名
		String fileuuid=getUUID();
		//获取图片的后缀名
		String suffix=filename.substring(filename.lastIndexOf("."));
		//得到图片的新名称
		String newfilename=fileuuid+suffix;
		String realPath=getUrl("filereal");
		File filemk=new File(realPath);
		if(!filemk.exists()){
			filemk.mkdirs();
		}
		try {
			fileimg.transferTo(new File(filemk+"//"+newfilename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getUrl("filepath")+"/"+newfilename;
	}

	public static ResponseEntity<byte[]> downFile(String filepath, HttpServletRequest request) {

		// 获得绝对路径
		String relPath = request.getSession().getServletContext().getRealPath("")+ "/" + filepath;
		// 设置下载的响应信息
		HttpHeaders httpHeaders = new HttpHeaders();

		// 设置下载的文件类型
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		// 设置下的文件名
		httpHeaders.setContentDispositionFormData("attachment", filepath.substring(7));

		// 将文件转为 二进制数组
		byte[] fileByte = null;
		try {
			fileByte = FileUtils.readFileToByteArray(new File(relPath));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return new ResponseEntity<byte[]>(fileByte, httpHeaders, HttpStatus.CREATED);
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	   /* 获得文件路径.
	     * 
	     * @return
	     * @throws Exception
	     */
	    public static String getUrl(String key) throws Exception {
	        InputStream inputStream = null;
	        String url = "";
	        try {
	            inputStream = UploadFileUtil.class.getResourceAsStream(
	                "/jdbc.properties");
	            Properties p = new Properties();
	            p.load(inputStream);
	            url = p.getProperty(key);
	        } catch (IOException io) {
	            throw io;
	        } finally {
	            try {
	                inputStream.close();
	            } catch (Exception e) {
	                throw e;
	            }
	        }
	        return url;
	    }
}
