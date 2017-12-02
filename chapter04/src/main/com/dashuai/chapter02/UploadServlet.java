package main.com.dashuai.chapter02;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wangyishuai on 2017/12/1。
 * <p>
 * 窗体发送时，如果<form>标签没有设置 enctype 属性，则默认值就是
 * application/x-www-form-urlencoded
 * <p>
 * 如果要上传文件，则 enctype 属性要设为 multipart/from-data
 */
@WebServlet("/upload.view")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    /**
     * 如果仅仅使用 getBody方法，如下：
     * ------WebKitFormBoundaryb8EpcbcABlycVGbO
     * Content-Disposition: form-data; name="filename"; filename="ç¯çJavaè®²ä¹.pdf"
     * Content-Type: application/pdf
     * ……
     * <p>
     * <p>
     * 要取得上传的文件，基本方式就是判断文件的开始与结束区段，然后使用HttpServletRequest 的 getInputStream()
     * 取得Servlet inputStream. 它是InputStream 的子类，代表请求Body 的流对象，可以利用它来处理上传的文件区段.
     * <p>
     * 在同一个请求期间，getReader ()与getInputStream() 只能有一个被调用，若同一请求期间两者都有调用，则会抛出IllegalStateException 异常.
     * <p>
     * 在Servlet 3.0 中，其实可以使用getPart ()或getParts ()方法，协助处理文件上传
     * Tomcat 中必须设置 @MultipartConfig 注解，才能使用getPart 相关API， @MultipartConfig 注解可用来设置 Servlet 处理上传文件的相关信息，
     * <p>
     * MultipartConfig 可用的属性如下.
     * • 1. fileSizeThreshold: 整数值设置，若上传文件大小超过设置值，会先写入缓存文件，默认值为 0
     * • 2. location: 字符串设置，设置写入文件时的目录，如果设置这个属性，则缓存文件就是写到指定的目录，也可搭配Part 的write ()方法使用， 默认为空字符串.
     * • 3. maxFileSize: 限制上传文件大小，默认值为 -1L. 表示不限制大小.
     * • 4. maxRequestSize: 限制multipart/form-data 请求的个数，默认值为 -1L. 表示不限个数.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        如果设置了@MultiPartConf 的location 属性. 那么由于上传的文件名可能会有中文，所以调用setCharacterEncoding() 设置正确的编码
         */
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        /*
        如果有多个文件要上传，可以使用getParts ()方法，返回一个Collection<Part> ，包含每个上传文件的Part 对象
         */
        Part part = req.getPart("filename"); // 选择文件：<input type="file" name="filename" value=""/><br> ，上传 list-addAll的坑.md
        String filename = getFilename(part); // list-addAll的坑.md
        saveFile(filename, part);
    }

    /*
    Part 有个方便的write() 可以直接将上传文件指定文件名写入磁盘中
    write(String filename) 可指定文件名，写入的路径是 @MultipartConfig 设置的location路径.
     */
    private void saveFile(String filename, Part part) throws IOException {
        InputStream inputStream = part.getInputStream();
        OutputStream outputStream = new FileOutputStream("/Users/wangyishuai" + filename);
        byte[] bytes = new byte[1024];
        int len;
        /*
        inputStream.read(bytes);
        return the total number of bytes read into the buffer,
        or -1 if there is no more data because the end of the stream has been reached.
         */
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        inputStream.close();
        outputStream.close();
    }

    /*
    获取上传文件的文件名
    Content-Disposition: form-data; name="filename"; filename="ç¯çJavaè®²ä¹.pdf"
     */
    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
//        return header.substring(header.indexOf("filename=\""), header.lastIndexOf("\""));
//        返回 filename="list-addAll的坑.md
        return header.substring(header.indexOf("filename=\"") + "filename=\"".length(), header.lastIndexOf("\""));
    }

//    private String getBody(HttpServletRequest request) throws IOException {
//        BufferedReader bufferedReader = request.getReader();
//        String input = "";
//        StringBuilder reqBody = new StringBuilder();
//        while ((input = bufferedReader.readLine()) != null) {
//            reqBody.append(input).append("<br>");
//        }
//
//        return reqBody.toString();
//    }
}
