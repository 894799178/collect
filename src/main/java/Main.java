import bean.HttpRequestBean;
import component.ChromeSeleniumComponent;
import service.ChromeSeleniumService;
import service.impl.ChromeSeleniumServiceImpl;
import utils.HttpUtils;

import java.util.List;
import java.util.UUID;

/**
 * 主入口
 * @author 一条小咸鱼
 */
public class Main {

    static  ChromeSeleniumService  chromeSeleniumService = new ChromeSeleniumServiceImpl();
    static String url = "http://localhost:8080/submitData";
    static String token = "";
    public static void main(String[] args) {
        //随机生成一个令牌~
        token= UUID.randomUUID().toString();
        ChromeSeleniumComponent.getInstance();
        System.out.println("token-->"+token);
        while (true){
            HttpRequestBean httpRequestBean = new HttpRequestBean();
            List<String> currentValidLog = chromeSeleniumService.getCurrentLog();
            if(currentValidLog.size()>0){
                httpRequestBean.setToken(token);
                httpRequestBean.setDatas(currentValidLog);
                HttpUtils.postRequest(url,httpRequestBean);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
