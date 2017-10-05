package com.hmkcode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmkcode.MultipartRequestHandler;
import com.hmkcode.vo.FileMeta;
import java.io.File;
import java.io.FileOutputStream;

//this to be used with Java Servlet 3.0 API
@MultipartConfig 
public class FileUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// this will store uploaded files
	private static List<FileMeta> files = new LinkedList<FileMeta>();
	/***************************************************
	 * URL: /upload
	 * doPost(): upload the files and other parameters
	 ****************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
	    
		// 1. Upload File Using Java Servlet API
		//files.addAll(MultipartRequestHandler.uploadByJavaServletAPI(request));			
		
		// 1. Upload File Using Apache FileUpload
                files.removeAll(files);
		files.addAll(MultipartRequestHandler.uploadByApacheFileUpload(request));
		
		// Remove some files
		
		
		// 2. Set response type to json
		response.setContentType("application/json");
		
		// 3. Convert List<FileMeta> into JSON format
    	ObjectMapper mapper = new ObjectMapper();
    	System.out.println("peraaaaaaaaaaaaaaa1111111111");
    	// 4. Send resutl to client
    	mapper.writeValue(response.getOutputStream(), files);
        
		 
		 FileMeta getFile = files.get(0);
        InputStream input = getFile.getContent();
            File outFile = new File(getFile.getFileName());
            System.out.println(outFile.getAbsolutePath());
            FileOutputStream output = new FileOutputStream(outFile);
        int c;
            while ((c = input.read()) != -1) {
                output.write(c);
            }
	
	}
	/***************************************************
	 * URL: /upload?f=value
	 * doGet(): get file of index "f" from List<FileMeta> as an attachment
	 ****************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
		
		 // 1. Get f from URL upload?f="?"
		 String value = request.getParameter("f");
		 
		 // 2. Get the file of index "f" from the list "files"
		 FileMeta getFile = files.get(Integer.parseInt(value));
		 
		 try {		
			 	// 3. Set the response content type = file content type 
			 	response.setContentType(getFile.getFileType());
			 	
			 	// 4. Set header Content-disposition
			 	response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
			 	
			 	// 5. Copy file inputstream to response outputstream
		        InputStream input = getFile.getContent();
            File outFile = new File(getFile.getFileName());
            System.out.println(outFile.getAbsolutePath());
            FileOutputStream output = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024 * 10];

            for (int length = 0; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
            
		 }catch (IOException e) {
				e.printStackTrace();
		 }
		
	}
}
