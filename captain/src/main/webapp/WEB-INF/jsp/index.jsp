<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
    <script src="js/jquery-2.1.1.js"></script>
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
    <div class="container">

        <div class="header">
            <div class="sky"></div>
            <div class="nav">
                <ul>
                </ul>
            </div>
            <div class="star"></div>
        </div>

        <div class="content">

            <div class="left-frame">
                <div id="blog_owner_logo">
                </div>
                <div id="blog_owner_name">Captain</div>
                <div id="blog_actions">
                    <ul>
                        <li>浏览：12345 次</li>
                        <li>性别：男</li>
                        <li>来自：中国上海</li>
                        <li>
                            <img src="img/offline.gif"/>
                        </li>
                    </ul>
                </div>

                <div class="left_frame_menu">
                    <h5>文章列表</h5>

                    <div>
                        <ul class="blog_categories">
                        </ul>
                    </div>
                </div>

            </div>

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

        </div>

    </div>
</body>
<script type="application/javascript">
    $(document).ready(function () {
        $.ajax({
            type: "get",
            url: 'category/load',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                if (data != "") {
                    $.each(data, function (index, item) {
                        $('.header > .nav > ul').append('<li><a href="index.html">' +  item.name + '</a></li>');
                    })
                }
            },
            error: function () {
                alert('error in retrieving blog categories');
            }
        });

        $.ajax({
            type: "get",
            dataType: "json",
            url: 'blog/load',
            success: function (data) {
                if (data != "") {
                    $.each(data, function (index, item) {
                        $('#blog-list ul').append('<li><a href="javascript:displayBlog(&quot;blog_' + index + '&quot;);">' + item.subject + '</a></li>');
                        $('#blog-detail').append('<div class="blog" id="blog_' + index + '">' + item.content + '</div>');
                        $('.blog').hide();
                    });
                }
            }
        });
    });
    function displayBlog(id) {
        $('.blog').hide();
        $('#' + id).show();
    }
</script>
</html>