/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Anjali
 */

public class UploadFile {
    
    private static final String Apath="C:/Users/anjal/Documents/NetBeansProjects/WebApps/Project/SkyeMarketPortal_FinalProjectV9/src/main/webapp/resources/images/";
    private static String Rpath=null;
    private static final Logger logger = LoggerFactory.getLogger(UploadFile.class);
    
    public static void addFile(HttpServletRequest request, MultipartFile file,String imageURL) {
    Rpath=request.getSession().getServletContext().getRealPath("/images/");
      
    logger.info(Rpath);					     
        
    logger.info(Rpath);					
		
		if(!new File(Rpath).exists()) {
			new File(Rpath).mkdirs();
		}
		
		if(!new File(Apath).exists()) {
			new File(Apath).mkdirs();
		}
        try {   
            file.transferTo(new File(Rpath+imageURL));
            System.out.println(Rpath+imageURL);
            Files.copy(Paths.get(Rpath+imageURL), Paths.get(Apath+imageURL));
            System.out.println("Apath is "+Apath+imageURL);
        } catch (IOException ex) {
           ex.printStackTrace();
        }
           
     
    }
  
}
