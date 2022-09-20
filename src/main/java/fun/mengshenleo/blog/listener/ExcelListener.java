package fun.mengshenleo.blog.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import fun.mengshenleo.blog.pojo.ApiLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mengshen
 * @date 2022/9/20 8:16
 */
public class ExcelListener extends AnalysisEventListener<ApiLog> {

    List<ApiLog> data = new ArrayList<>();

    @Override
    public void invoke(ApiLog apiLog, AnalysisContext analysisContext) {
        if (apiLog.getAccessApi() != null){
            data.add(apiLog);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }


    public List<ApiLog> getData() {
        return data;
    }

    public void setData(List<ApiLog> data) {
        this.data = data;
    }

}
