package elasticsearchTest;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CreateIndex {

    public void test() throws IOException {

        //创建客户端
        Settings settings = Settings.builder()
                .put("cluster.name", "my-esLearn")
                .put("client.transport.ignore_cluster_name", true)
                .build();
        //创建client
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        //创建映射
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("properties")
                //      .startObject("m_id").field("type","keyword").endObject()
                .startObject("poi_index").field("type", "integer").endObject()
                .startObject("poi_title").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .startObject("poi_address").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .startObject("poi_tags").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .startObject("poi_phone").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .startObject("poi_lng").field("type", "text").endObject()
                .startObject("poi_lat").field("type", "text").endObject()
                .endObject()
                .endObject();
        mapping = mapping;
        //pois：索引名   cxyword：类型名（可以自己定义）
        PutMappingRequest putmap = Requests.putMappingRequest("pois").type("cxyword").source(mapping);
        //创建索引
        client.admin().indices().prepareCreate("pois").execute().actionGet();
        //为索引添加映射
        client.admin().indices().putMapping(putmap).actionGet();
    }
}
