package com.example.webshop.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*need to create overwrite function !!!*/
public class FileUploadUtility {

    //using for project upload
    private static final String ABSOLUTE_PATH= "E:\\SpringProjects\\OnlineShop\\web\\assets\\images\\";

    //using for server upload
    private static  String REAL_PATH= "";

    // @param code - will be name of the file
    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
        //get the real path
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

        // to make sure all the directory exist please create the dir
        if(!new File(ABSOLUTE_PATH).exists()){
            // creating new dir
            new File(ABSOLUTE_PATH).mkdirs();
        }

        if(!new File(REAL_PATH).exists()){
            // creating new dir
            new File(REAL_PATH).mkdirs();
        }

        try {
            //server upload
            file.transferTo(new File(REAL_PATH + code + ".jpg"));

            // project upload
            Files.copy(Paths.get(REAL_PATH + code + ".jpg"),Paths.get(ABSOLUTE_PATH + code + ".jpg"));


            // can't using twice (???)
//            file.transferTo(new File(ABSOLUTE_PATH + code + ".jpg"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}