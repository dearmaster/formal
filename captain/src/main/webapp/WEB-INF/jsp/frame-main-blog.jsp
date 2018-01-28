<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main-frame">
    <div class="blogs_preview">
        <div class="blog_main_title">
            <span>文章列表</span>
        </div>
        <div class="blog_main" th:each="blog : ${blogs}">
            <div class="blog_info" th:text="${#calendars.format(blog.publishDate, 'yyyy-MM-dd HH:mm:SS')}">
                2017-11-21 15:30:29
            </div>
            <div class="blog_title">
                <a th:href="@{/blog/view(id=${blog.id})}" th:text="${blog.subject}">写给2017</a>
            </div>
        </div>

    </div>
</div>