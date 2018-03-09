package elasticsearchTest;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

public class Es6Test1 {
    private static TransportClient client;

    @Before
    public void getClient() {
        // TODO Auto-generated method stub
        try {
            Settings settings = Settings.builder().put("cluster.name", "my-esLearn").build();
            //创建client
            //@SuppressWarnings("resource")
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));



            //设置集群名称

            //写入数据
            // createDate(client);
            //搜索数据
//            GetResponse response = client.prepareGet("accounts", "person", "1").execute().actionGet();
//            //输出结果
//            System.out.println(response.getSource());

            //关闭client
            //client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取单条数据
    @Test
    public void getDataByID() {
        // TODO Auto-generated method stub
        try {


            //创建映射
            XContentBuilder mapping = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("properties")
                    //      .startObject("m_id").field("type","keyword").endObject()
                    .startObject("title").field("type", "text").endObject()
                    //，对数据按照设定规则处理，ik_max_word 是分词类型，最细粒度切割，
                    .startObject("content").field("type", "text").field("analyzer", "ik_max_word").endObject()
                    .endObject()
                    .endObject();

            //pois：索引名   cxyword：类型名（可以自己定义）
            PutMappingRequest putmap = Requests.putMappingRequest("blog1").type("article").source(mapping);
            //创建索引
            client.admin().indices().prepareCreate("blog1").execute().actionGet();  //创建
            //为索引添加映射
            client.admin().indices().putMapping(putmap).actionGet();  //映射添加进去

            //搜索数据
            GetResponse response = client.prepareGet("blog1", "article", "1").execute().actionGet();
            //输出结果
            System.out.println(response.toString());

            //关闭client
            //client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2() throws IOException {

        BulkRequestBuilder bulkRequest = client.prepareBulk();

// either use client#prepare, or use Requests# to directly build index/delete requests
        bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")  //创建索引
                .setSource(jsonBuilder()   //请求体，数据
                        .startObject()
                        .field("analyzer","ik_max_word")  //指定分词器
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                        .endObject()
                )
        );

        bulkRequest.add(client.prepareIndex("twitter", "tweet", "2")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "another post")
                        .endObject()
                )
        );

        BulkResponse bulkResponse = bulkRequest.get();
        if (bulkResponse.hasFailures()) {
            // process failures by iterating through each bulk response item
        }

        BulkItemResponse[] items = bulkResponse.getItems();  //一次发送多个请求，会返回一个响应数组。
        DocWriteResponse response = items[0].getResponse();
        String index = response.getIndex();
        System.out.println(index);
    }
}
