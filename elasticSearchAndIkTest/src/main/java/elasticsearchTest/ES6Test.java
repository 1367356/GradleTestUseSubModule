package elasticsearchTest;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
//http://blog.csdn.net/zjcjava/article/details/78659721  下载对应版本的elasticsearch和client
public class ES6Test {
    public static void main(String[] args) {
        try{
        //设置集群名称
//        Settings settings = Settings.builder().put("cluster.name", "my-esLearn").build();
            Settings settings = Settings.builder()
                    .put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings);

           //搜索数据
            GetResponse response = client.prepareGet("blog", "article", "1").execute().actionGet();
            //输出结果
            System.out.println(response.getSourceAsString());
            //关闭client
            client.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
