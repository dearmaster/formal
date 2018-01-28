<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
    <script src="js/jquery-2.1.1.js"></script>
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>

    <div class="audio-container">
        <EMBED src="audio/穿越时空的思恋.mp3" autostart="true" loop=20 width=0 height=0>
    </div>

    <div class="container">

        <%@ include file="frame-header.jsp"%>

        <div class="content">

            <%@ include file="frame-left-panel.jsp"%>

            <%@ include file="frame-main-blog.jsp"%>

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
                        $('.header > .nav > ul').append('<li><a href="' + item.name + '">' +  item.description + '</a></li>');
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