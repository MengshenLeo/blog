package fun.mengshenleo.blog.utils;

import java.util.List;
import java.util.Objects;

/**
 * @author renzhilong
 */
public class CommonUtils {

    /**
     * 对列表实现分页
     * @param list
     * @param pageNum
     * @param pageSize
     * @return 分页好的列表
     */
    public List<Object> getPageList(List<Object> list, Integer pageNum, Integer pageSize) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return null;
        }

        Integer count = list.size(); // 记录总数
        int pageCount = 0; // 页数,一共多少页

        if (count % pageSize == 0) {//取余计算总页数
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }

        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引

        if (!pageNum.equals(pageCount) ) {
            fromIndex = (pageNum - 1) * pageSize; //从第几个数据开始查
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }


        return list.subList(fromIndex, toIndex);
    }
}
