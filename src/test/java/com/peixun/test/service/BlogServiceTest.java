package com.peixun.test.service;

import com.peixun.test.YourfirstApplication;
import com.peixun.test.entity.Blog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YourfirstApplication.class)
class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    @Test
    void addBlog() {
        Blog blog = new Blog();
        blog.setUserId(5L);
        blog.setTitle("疫情防控工作中履职不力，贵州织金县交通运输局党组书记、局长被免职");
        blog.setContent("央视网消息：据“织金发布”微信公众号9月17日消息，在织金县疫情防控工作中，织金县交通运输局主要领导存在履职不力等问题，经织金县委同意，织金县应对新冠肺炎疫情联防联控机制现将有关情况通报如下：\n" +
                "\n" +
                "高勇作为织金县交通运输局主要负责人，对疫情形势认识不足，责任压得不实，工作措施不力，不深入不具体，对交通运输保障车辆驾驶人员管理混乱，社会面管控措施执行不到位，造成严重不良影响。2022年9月16日，经织金县委常委会会议讨论决定，高勇不再担任织金县交通运输局党组书记、局长职务，其行政职务按法定程序办理。\n" +
                "\n" +
                "当前织金疫情防控歼灭战正处于关键时期，尽管疫情防控指挥部三令五申，但依然有少数党员领导干部存在麻痹思想、侥幸心理，对疫情防控严峻形势认识不够，工作推进力度有差距。全县各级党组织、广大党员干部要进一步提高政治站位，切实转变工作作风，对疫情防控各项指令必须迅速、坚决贯彻执行，集中精力把疫情“围住、捞干、扑灭”，确保全县人民生命安全和身体健康。疫情防控指挥部将持续加大追责力度，对履责不力、作风不实的从严从快处理。");
        blogService.addBlog(blog);
    }

    @Test
    void deleteBlog() {
        //逻辑删除
        int i = blogService.deleteBlog(1, 1);
        System.out.println(i);
    }

    @Test
    void updateBlog() {
        Blog blog = new Blog();
        blog.setUserId(1L);
        blog.setId(3L);
        blog.setTitle("1");
        int i = blogService.updateBlog(blog);
        System.out.println(1);
    }

    @Test
    void getBlogByUserId() {
        List<Blog> blogByUserId = blogService.getBlogByUserId(5L);
        System.out.println(blogByUserId);
    }

    @Test
    void getBlogByTitle() {
        List<Blog> blogs
                = blogService.getBlogsByTitle("疫情");
        System.out.println("blogs = " + blogs);
    }

    @Test
    void getAllBlog() {
        List<Blog> allBlog = blogService.getAllBlog();
        System.out.println(allBlog);
    }

}