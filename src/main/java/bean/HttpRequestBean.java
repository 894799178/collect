package bean;

import java.util.List;

/**
 * @ProjectName: collect
 * @Package: bean
 * @ClassName: HttpRequestBean
 * @Author: 一条小咸鱼
 * @Description: ${description}
 * @Date: 2019/1/30 19:51
 * @Version: 1.0
 */
public class HttpRequestBean extends  BaseHttpBean{
    /**
     * 数据集合
     */
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setDatas(List<String> datas) {
        this.list = datas;
    }


}
