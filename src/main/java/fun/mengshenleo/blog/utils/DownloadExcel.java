package fun.mengshenleo.blog.utils;

import com.alibaba.excel.EasyExcel;
import fun.mengshenleo.blog.utils.CustomCellWriteUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author mengshen
 * @date 2022/9/19 17:49
 */
public class DownloadExcel {
    public static void download(HttpServletResponse response, Class<?> t, List<?> list, String excelName) throws IOException {

        response.setCharacterEncoding("UTF-8");
        CustomCellWriteUtil customCellWriteUtil = new CustomCellWriteUtil();

        response.setHeader("Content-disposition", "attachment;filename=" + excelName + ".xlsx");
        EasyExcel
                .write(response.getOutputStream(), t)
                .registerWriteHandler(customCellWriteUtil)
                .registerWriteHandler(customCellWriteUtil.CellStyleStrategy())
                .sheet("表1")
                .doWrite(list);
    }
}
