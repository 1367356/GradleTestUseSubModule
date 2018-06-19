package chapter06;

import com.sun.javafx.geom.Rectangle;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.Filterable;
import com.sun.scenario.effect.ImageData;

import java.awt.*;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-15 22:08
 * 使用CompletionService,使页面元素在下载完成后立即显示出来
 **/
public class Renderer {
    private final ExecutorService executor; //执行框架

    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) {
        List<Image> images = scanForImageInfo(source);  //向图像信息渲染
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
        for (final Image image : images) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return null;
                }
            });
        }
        rederText(source);  //渲染文本

        try {
            for (int i = 0; i < images.size(); i++) {
                Future<ImageData> f=completionService.take();
                ImageData imageData=f.get();  //Future中获得结果
                rederImage(imageData);  //渲染图片
            }
        }catch (Exception e){
            System.out.println("异常");
        }
    }

    private void rederImage(ImageData imageData) {

    }

    private void rederText(CharSequence source) {

    }

    private List<Image> scanForImageInfo(CharSequence source) {
        return null;
    }
}
