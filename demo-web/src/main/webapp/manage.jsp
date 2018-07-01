<%--<%@ page import="com.raycloud.wjc.web.utils.RequestUtil" %>--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%
    if (!RequestUtil.isInnerRequest(request)) {
        response.getWriter().print("权限不足!");
        return;
    }
%>--%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>违禁词管理</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/bootstrap-fileinput/4.3.1/css/fileinput.min.css" rel="stylesheet">

    <style>
        * {
            font-family: -apple-system, system-ui, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', sans-serif;
        }

        .none {
            display: none;
        }

        .pwd {
            margin-top: 20px;
            margin-bottom: 10px;
        }

        .top-bar {
            width: 550px;
            margin: 0 auto 10px;
        }

        .tab-pane {
            padding-top: 10px;
        }

        .pagination {
            margin: 0;
            vertical-align: middle;
        }

        .pagination-container {
            text-align: right;
            margin-bottom: 20px;
        }

        .pagination-container .page-input {
            width: 50px;
        }

        .form-label {
            padding-right: 0;
        }

        #form-modal .modal-dialog {
            width: 900px;
        }

        .editor {
            overflow: scroll;
            max-height: 300px;
            height: 300px;
            width: 100%;
        }

        .tip {
            border-bottom: 0;
            margin-bottom: 0;
        }

        .education-label {
            margin-right: 20px;
            font-weight: 400;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-inline pwd">
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="密码">
        </div>
    </div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#wordManage" aria-controls="wordManage" role="tab" data-toggle="tab">违禁词管理</a>
        </li>
        <li role="presentation">
            <a href="#educationConfig" aria-controls="educationConfig" role="tab" data-toggle="tab">文字教育配置</a>
        </li>
        <li role="presentation">
            <a href="#priceConfig" aria-controls="priceConfig" role="tab" data-toggle="tab">价格配置</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="wordManage">
            <div class="form-horizontal top-bar">
                <div class="form-group">
                    <div class="col-sm-6">
                        <input class="form-control" type="text" id="keyword" placeholder="请输入关键字"/>
                    </div>
                    <button type="button" class="btn btn-default" id="btn-search-word">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索
                    </button>

                    <button type="button" class="btn btn-default" id="btn-add-word">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
                    </button>

                    <button type="button" class="btn btn-primary" id="btn-import">导入违禁词</button>
                </div>
            </div>

            <table class="table table-bordered">
                <thead>
                <tr class="info">
                    <th>关键词</th>
                    <th>分类</th>
                    <th>违规描述</th>
                    <th>添加时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="word-result-body">
                </tbody>
            </table>

            <div class="form-inline pagination-container">
                <div class="form-group">
                    <ul id="word-pagination-ul"></ul>
                </div>
                <div class="form-group">
                    <select class="form-control" id="word-size-selector">
                        <option value="10">10条/页</option>
                        <option value="20">20条/页</option>
                        <option value="50">50条/页</option>
                        <option value="100">100条/页</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>跳至</label>
                    <input class="form-control page-input" type="text" id="word-page-input">
                    <label>页</label>
                </div>
            </div>
        </div>

        <div role="tabpanel" class="tab-pane" id="educationConfig">
            <div class="form-horizontal">
                <div class="form-group col-xs-3">
                    <label class="col-sm-4 control-label">平台</label>
                    <div class="col-sm-8">
                        <select class="form-control" id="education-platform-selector">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-xs-3">
                    <label class="col-sm-5 control-label">显示步骤</label>
                    <div class="col-sm-7">
                        <select class="form-control" id="education-show-step-selector">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-xs-3">
                    <label class="col-sm-4 control-label">类型</label>
                    <div class="col-sm-8">
                        <select class="form-control" id="education-type-selector">
                            <option value="">全部</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-xs-3">
                    <button type="button" class="btn btn-default" id="btn-search-education">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> 搜索
                    </button>
                    <button type="button" class="btn btn-default" id="btn-add-education">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
                    </button>
                </div>
            </div>

            <table class="table table-bordered">
                <thead>
                <tr class="info">
                    <th>平台</th>
                    <th>显示步骤</th>
                    <th>类型</th>
                    <th>内容</th>
                    <th>链接</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="education-result-body">
                </tbody>
            </table>

            <div class="form-inline pagination-container">
                <div class="form-group">
                    <ul id="education-pagination-ul"></ul>
                </div>
                <div class="form-group">
                    <select class="form-control" id="education-size-selector">
                        <option value="10">10条/页</option>
                        <option value="20">20条/页</option>
                        <option value="50">50条/页</option>
                        <option value="100">100条/页</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>跳至</label>
                    <input class="form-control page-input" type="text" id="education-page-input"/>
                    <label>页</label>
                </div>
            </div>
        </div>

        <div role="tabpanel" class="tab-pane" id="priceConfig">
            <div class="form-horizontal">
                <div class="form-group col-xs-4">
                    <label class="col-sm-5 conrol-label">数量区间</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" id="beginAmount"/>
                    </div>

                </div>

                <div class="form-group col-xs-4">
                    <div class="col-sm-2">—&nbsp;</div>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" id="endAmount"/>
                    </div>
                </div>
                <div class="form-group col-xs-2">
                    <label class="col-sm-5 control-label">单价</label>
                    <div class="col-sm-7">
                        <input class="form-control" type="text" id="price"/>
                    </div>
                </div>

                <div class="form-group col-xs-2">
                    <button type="button" class="btn btn-primary" id="btn-add-price-config">添加</button>
                </div>
            </div>
        </div>
        <table class="table table-bordered">
            <thead>
            <tr class="info">
                <th>数量区间</th>
                <th>单价</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="price-config-body">
            </tbody>
        </table>
    </div>

    <div class="modal fade" id="importModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">导入违禁词</h4>
                </div>
                <div class="modal-body">
                    <input type="file" id="import-file-input" name="wjcFile">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">完成</button>
                </div>
            </div>
        </div>
    </div>

    <!-- word-form-modal -->
    <div class="modal fade" id="word-form-modal" tabindex="-1" role="dialog" aria-labelledby="formModalLabel">
        <div class="modal-dialog" role="document">
            <form id="word-form">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"><span id="form-type">新增</span>违禁词</h4>
                    </div>
                    <div class="modal-body form-horizontal">
                        <div class="form-group">
                            <label for="keyword-input" class="col-sm-2 control-label form-label">违禁词：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="keyword-input" placeholder="请输入违禁词">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="category-selector" class="col-sm-2 control-label form-label">分类：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="category-selector">
                                </select>
                            </div>
                        </div>

                        <div id="custom-category-div" class="form-group none">
                            <label for="category-name-input" class="col-sm-2 control-label form-label">自定义分类：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="category-name-input"
                                       placeholder="请输入自定义分类名称">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="desc-editor" class="col-sm-2 control-label form-label">违规描述：</label>
                            <div class="col-sm-10">
                                <textarea class="editor" id="desc-editor"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary none" id="btn-save-add-word" data-dismiss="modal">
                            保存新增
                        </button>
                        <button type="button" class="btn btn-primary none" id="btn-save-update-word"
                                data-dismiss="modal">
                            保存修改
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- education-form-modal -->
    <div class="modal fade" id="education-form-modal" tabindex="-1" role="dialog" aria-labelledby="formModalLabel">
        <div class="modal-dialog" role="document">
            <form id="education-form">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">新增文字教育</h4>
                    </div>
                    <div class="modal-body form-horizontal">
                        <div class="form-group">
                            <label for="education-platform-div" class="col-sm-2 control-label form-label">平台：</label>
                            <div class="col-sm-10" id="education-platform-div">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="education-show-step-div" class="col-sm-2 control-label form-label">显示步骤：</label>
                            <div class="col-sm-10" id="education-show-step-div">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="education-type-div" class="col-sm-2 control-label form-label">类型：</label>
                            <div class="col-sm-10" id="education-type-div">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="education-content-input" class="col-sm-2 control-label form-label">内容：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="education-content-input"
                                       placeholder="内容不能为空">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="education-link-input" class="col-sm-2 control-label form-label">链接：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="education-link-input"
                                       placeholder="链接必须以http开头"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="btn-save-add-education">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">错误信息</h4>
            </div>
            <div id="modal-body" class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" id="tip-modal">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div id="tip-container" class="modal-header tip alert">
                <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                <strong class="modal-title" id="tip-content"></strong>
            </div>
        </div>
    </div>
</div>

<script src="//cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/twbs-pagination/1.4.1/jquery.twbsPagination.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap3-wysiwyg/0.3.3/bootstrap3-wysihtml5.all.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap3-wysiwyg/0.3.3/locales/bootstrap-wysihtml5.zh-CN.min.js"></script>
<link href="//cdn.bootcss.com/bootstrap3-wysiwyg/0.3.3/bootstrap3-wysihtml5.min.css" rel="stylesheet">
<script src="//cdn.bootcss.com/bootstrap-fileinput/4.3.1/js/fileinput.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap-fileinput/4.3.1/js/fileinput_locale_zh.min.js"></script>

<script>
    //这个需要全局可访问
    var $descEditor = $('#desc-editor');
    var wysihtml5Editor = $descEditor.wysihtml5({
        toolbar: {
            "font-styles": true, // Font styling, e.g. h1, h2, etc.
            "emphasis": true, // Italics, bold, etc.
            "lists": false, // (Un)ordered lists, e.g. Bullets, Numbers.
            "html": false, // Button which allows you to edit the generated HTML.
            "link": true, // Button to insert a link.
            "image": true, // Button to insert an image.
            "color": false, // Button to change color of font
            "blockquote": true // Blockquote
        },
        locale: "zh-CN"
    }).data("wysihtml5").editor;

    $(function () {
        //日期格式化方法
        Date.prototype.Format = function (fmt) {
            var o = {
                "M+": this.getMonth() + 1,         //月份
                "d+": this.getDate(),          //日
                "h+": this.getHours(),          //小时
                "m+": this.getMinutes(),         //分
                "s+": this.getSeconds(),         //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds()       //毫秒
            };
            if (/(y+)/.test(fmt))
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        };

        //显示提示
        var $tipContent = $("#tip-content");
        var $tipModal = $("#tip-modal");
        var $tipContainer = $("#tip-container");
        var showTip = function (content, isFail) {
            if (isFail) {
                $tipContainer.addClass("alert-danger").removeClass("alert-success");
            } else {
                $tipContainer.addClass("alert-success").removeClass("alert-danger");
            }

            $tipContent.text(content);
            $tipModal.modal("show");
            setTimeout(function () {
                $tipModal.modal("hide");
            }, 900);
        };

        var showModal = function (content) {
            $("#modal-body").text(content);
            $("#myModal").modal();
        };

        //检查返回结果是否正确
        var check = function (data) {
            if (data == null) {
                showModal("返回为空");
                return false;
            } else if (!data.success) {
                showModal(data.message);
                return false;
            }
            return true;
        };

        //违禁词管理页面
        var kfcCategoryMap;
        var $categorySelector = $('#category-selector');
        $.ajax({
            url: '/secondParty/getAllKfcCategories.json',
            type: 'get',
            success: function (data) {
                if (check(data)) {
                    kfcCategoryMap = data.data;
                    for (var id in kfcCategoryMap) {
                        var categoryOption = $("<option>");
                        categoryOption.text(kfcCategoryMap[id]);
                        categoryOption.val(id);
                        $categorySelector.append(categoryOption);
                    }

                    var $customCategoryOption = $("<option>");
                    $customCategoryOption.text("自定义");
                    $customCategoryOption.val("");
                    $categorySelector.append($customCategoryOption);
                }
            }
        });

        var $customCategoryDiv = $('#custom-category-div');
        var $categoryNameInput = $('#category-name-input');
        $categorySelector.on("change", function () {
            $categoryNameInput.val("");
            if ($(this).val()) {
                $customCategoryDiv.hide();
            } else {
                $customCategoryDiv.show();
            }
        });

        var getCategoryName = function (categoryId) {
            return kfcCategoryMap[categoryId] || "未分类";
        };

        var $wordSizeSelector = $("#word-size-selector");
        var wordPageSize = $wordSizeSelector.val();
        var $wordPagination = $('#word-pagination-ul');

        var defaultOpts = {
            first: "首页",
            prev: "上一页",
            next: "下一页",
            last: "尾页",
            visiblePages: 7,
            initiateStartPageClick: false
        };

        var rebuildWordPagination = function (pageNo, pageCount) {
            $wordPagination.twbsPagination('destroy');
            $wordPagination.twbsPagination($.extend({}, defaultOpts, {
                totalPages: pageCount,
                startPage: pageNo,
                onPageClick: function (evt, page) {
                    searchWord(page, wordPageSize);
                }
            }));
        };

        var wordList;
        var currentPageNo;
        var $password = $("#password");
        var $keyword = $("#keyword");
        var $wordResultBody = $('#word-result-body');
        var searchWord = function (pageNo, pageSize) {
            $.ajax({
                async: false,
                url: '/secondParty/queryProhibitedWords.json',
                type: 'post',
                data: {
                    pwd: $password.val(),
                    keyword: $keyword.val(),
                    pageNo: pageNo,
                    pageSize: pageSize
                },
                success: function (data) {
                    if (check(data)) {
                        $wordResultBody.empty();
                        var result = data.data;
                        wordList = result.list;
                        $.each(wordList, function (n, value) {
                            var tr = $("<tr>");
                            tr.attr("data-id", value.id);
                            tr.attr("data-word", value.keyword);
                            tr.attr("id", "tr-" + value.id);
                            tr.append($("<td>").text(value.keyword));
                            tr.append($("<td>").text(getCategoryName(value.categoryId)));
                            tr.append($("<td>").html('<a tabindex="0" role="button" data-toggle="popover" data-trigger="focus" data-html=true title="' + value.keyword + '" data-content="' + value.desc + '">查看详情</a>'));
                            tr.append($("<td>").text(new Date(value.created).Format("yyyy-MM-dd hh:mm:ss")));
                            tr.append($("<td>").html('<a class="btn-modify-word" role="button">编辑</a>' + ' | ' + '<a class="btn-delete-word" role="button">删除</a>'));
                            $wordResultBody.append(tr);
                        });

                        $('[data-toggle="popover"]').popover();

                        currentPageNo = result.pageNo;
                        rebuildWordPagination(currentPageNo, result.pageCount);
                    }
                }
            });
        };

        $("#btn-search-word").on("click", function () {
            searchWord(1, wordPageSize);
        });

        var $formType = $('#form-type');
        var $keywordInput = $('#keyword-input');
        var $wordFormModal = $("#word-form-modal");
        var $wordForm = $("#word-form");
        var $btnSaveAddWord = $('#btn-save-add-word');
        var $btnSaveUpdateWord = $('#btn-save-update-word');
        $('#btn-add-word').on("click", function () {
            $formType.text("新增");
            $wordForm.trigger("reset");
            $categorySelector.trigger("change");
            wysihtml5Editor.setValue("", true);
            $btnSaveAddWord.show();
            $btnSaveUpdateWord.hide();
            $(".wysihtml5-toolbar .btn-group a").removeClass("wysihtml5-command-active");
            $wordFormModal.modal();
        });

        $btnSaveAddWord.on("click", function () {
            $.ajax({
                url: '/secondParty/addProhibitedWord.json',
                type: 'post',
                data: {
                    pwd: $password.val(),
                    keyword: $keywordInput.val(),
                    categoryId: $categorySelector.val(),
                    categoryName: $categoryNameInput.val(),
                    desc: $descEditor.val()
                },
                success: function (data) {
                    if (check(data)) {
                        showTip("添加成功");
                        searchWord(1, wordPageSize);
                    }
                }
            });
        });

        $btnSaveUpdateWord.on("click", function () {
            $.ajax({
                url: '/secondParty/updateProhibitedWord.json',
                type: 'post',
                data: {
                    pwd: $password.val(),
                    keyword: $keywordInput.val(),
                    categoryId: $categorySelector.val(),
                    categoryName: $categoryNameInput.val(),
                    desc: $descEditor.val()
                },
                success: function (data) {
                    if (check(data)) {
                        showTip("修改成功");
                        searchWord(currentPageNo, wordPageSize);
                    }
                }
            });
        });

        var $body = $("body");
        $body.on("click", ".btn-modify-word", function () {
            $formType.text("编辑");
            var id = $(this).parents("tr").data("id");
            for (var i = 0; i < wordList.length; i++) {
                if (wordList[i].id == id) {
                    $keywordInput.val(wordList[i].keyword);
                    $categorySelector.val(wordList[i].categoryId);
                    wysihtml5Editor.setValue(wordList[i].desc, true);
                    $categorySelector.trigger("change");
                    break;
                }
            }

            $btnSaveAddWord.hide();
            $btnSaveUpdateWord.show();
            $(".wysihtml5-toolbar a").removeClass("wysihtml5-command-active");
            $wordFormModal.modal("show");
        });

        $body.on("click", ".btn-delete-word", function () {
            if (confirm("确定删除该违禁词？")) {
                var id = $(this).parents("tr").data("id");
                var keyword = $(this).parents("tr").data("word");
                $.ajax({
                    url: '/secondParty/deleteProhibitedWord.json',
                    type: 'post',
                    data: {
                        pwd: $password.val(),
                        keyword: keyword
                    },
                    success: function (data) {
                        if (check(data)) {
                            $("#tr-" + id).remove();
                        }
                    }
                });
            }
        });

        $wordSizeSelector.on("change", function () {
            wordPageSize = this.value;
            searchWord(1, wordPageSize);
        });

        $('#keyword').on('keyup', function (event) {
            if (event.keyCode == "13") {
                //回车执行查询
                searchWord(1, wordPageSize);
            }
        });

        $('#word-page-input').bind('keyup', function (event) {
            if (event.keyCode == "13") {
                //回车执行查询
                searchWord(this.value, wordPageSize);
            }
        });

        var $importFileInput = $("#import-file-input");
        $("#btn-import").on("click", function () {
            $("#importModal").modal("show");
        });

        $importFileInput.fileinput({
            language: 'zh',
            uploadUrl: '/secondParty/uploadProhibitedWord.json',
            maxFileCount: 1,
            allowedFileExtensions: ['xls'],
            previewClass: 'bg-warning',
            browseClass: 'btn btn-primary',
            uploadClass: 'btn btn-success',
            removeClass: 'btn btn-danger',
            layoutTemplates: {
                progress: '<div class="progress">\n' +
                '    <div class="progress-bar progress-bar-success progress-bar-striped text-center" role="progressbar" aria-valuenow="{percent}" aria-valuemin="0" aria-valuemax="100" style="width:{percent}%;">\n' +
                '        {percent}%\n' +
                '     </div>\n' +
                '</div>'
            },
            uploadExtraData: function () {
                return {pwd: $password.val()};
            }
        });

        $importFileInput.on('fileuploaded', function (event, obj) {
            var data = obj.response;
            if (check(data)) {
                $tipContent.text(data.data);
                showTip("文件上传成功");
            }
        });

        //文字教育配置页面

        var platformJSON = {
            "PC": "PC",
            "QN": "千牛",
            "JD": "京东"
        };

        var $educationPlatformSelector = $('#education-platform-selector');
        var $educationPlatformDiv = $('#education-platform-div');
        for (var key in platformJSON) {
            var platformOption = $("<option>");
            platformOption.text(platformJSON[key]);
            platformOption.val(key);
            $educationPlatformSelector.append(platformOption);
            $educationPlatformDiv.append('<label class="control-label education-label"><input type="checkbox" name="education-platform-checkbox" value="' + key + '"> ' + platformJSON[key] + '</label>');
        }

        var stepJSON = {
            "INDEX": "首页",
            "CHOOSE_ITEM": "选择宝贝",
            "PAY": "支付",
            "START_SCAN": "开始扫描"
        };

        var $educationShowStepSelector = $('#education-show-step-selector');
        var $educationShowStepDiv = $('#education-show-step-div');
        for (var key in stepJSON) {
            var stepOption = $("<option>");
            stepOption.text(stepJSON[key]);
            stepOption.val(key);
            $educationShowStepSelector.append(stepOption);
            $educationShowStepDiv.append('<label class="control-label education-label"><input type="radio" name="education-show-step-radio" value="' + key + '"> ' + stepJSON[key] + '</label>');
        }

        var typeJSON = {
            "1": "禁规",
            "2": "案例"
        };

        var $educationTypeSelector = $('#education-type-selector');
        var $educationTypeDiv = $('#education-type-div');
        for (var key in typeJSON) {
            var typeOption = $("<option>");
            typeOption.text(typeJSON[key]);
            typeOption.val(key);
            $educationTypeSelector.append(typeOption);
            $educationTypeDiv.append('<label class="control-label education-label"><input type="radio" name="education-type-radio" value="' + key + '"> ' + typeJSON[key] + '</label>');
        }

        var $educationSizeSelector = $("#education-size-selector");
        var educationPageSize = $educationSizeSelector.val();
        var $educationPagination = $('#education-pagination-ul');

        var rebuildEducationPagination = function (pageNo, pageCount) {
            $educationPagination.twbsPagination('destroy');
            $educationPagination.twbsPagination($.extend({}, defaultOpts, {
                totalPages: pageCount,
                startPage: pageNo,
                onPageClick: function (evt, page) {
                    searchEducation(page, educationPageSize);
                }
            }));
        };

        var educationList;
        var $educationResultBody = $('#education-result-body');
        var searchEducation = function (pageNo, pageSize) {
            $.ajax({
                async: false,
                url: '/secondParty/queryEducations.json',
                type: 'post',
                data: {
                    pwd: $password.val(),
                    platform: $educationPlatformSelector.val(),
                    showStep: $educationShowStepSelector.val(),
                    type: $educationTypeSelector.val(),
                    pageNo: pageNo,
                    pageSize: pageSize
                },
                success: function (data) {
                    if (check(data)) {
                        $educationResultBody.empty();
                        var result = data.data;
                        educationList = result.list;
                        $.each(educationList, function (n, value) {
                            var tr = $("<tr>");
                            tr.attr("data-id", value.id);
                            tr.append($("<td>").text(platformJSON[value.platform]));
                            tr.append($("<td>").text(stepJSON[value.showStep]));
                            tr.append($("<td>").text(typeJSON[value.type]));
                            tr.append($("<td>").text(value.content));
                            tr.append($("<td>").html(value.hasLink ? "<a target='_blank' href='" + value.link + "'>" + value.link + "</a>" : ""));
                            tr.append($("<td>").html('<a class="btn-delete-education" role="button">删除</a>'));
                            $educationResultBody.append(tr);
                        });

                        rebuildEducationPagination(result.pageNo, result.pageCount);
                    }
                }
            });
        };

        $("#btn-search-education").on("click", function () {
            searchEducation(1, educationPageSize);
        });

        var $educationContentInput = $('#education-content-input');
        var $educationLinkInput = $('#education-link-input');
        var $educationFormModal = $("#education-form-modal");
        var $educationForm = $("#education-form");
        var $btnSaveAddEducation = $('#btn-save-add-education');
        $('#btn-add-education').on("click", function () {
            $educationForm.trigger("reset");
            $educationPlatformDiv.find("input[type='checkbox']").eq(0).prop("checked", true);
            $educationShowStepDiv.find("input[type='radio']").eq(0).prop("checked", true);
            $educationTypeDiv.find("input[type='radio']").eq(0).prop("checked", true);
            $educationFormModal.modal("show");
        });

        var checkEducationParam = function () {
            var platforms = [];
            $educationPlatformDiv.find("input[type='checkbox']:checked").each(function () {
                platforms.push($(this).val());
            });

            if (platforms.length === 0) {
                alert("至少选择一个平台");
                return false;
            }

            var content = $educationContentInput.val();
            if (!content) {
                alert('内容不能为空');
                return false;
            }

            var showStep = $educationShowStepDiv.find("input[type='radio']:checked").val();
            var type = $educationTypeDiv.find("input[type='radio']:checked").val();

            return {content: content, platforms: platforms.join(","), showStep: showStep, type: type};
        };

        $btnSaveAddEducation.on("click", function () {
            var param = checkEducationParam();
            if (param) {
                $.ajax({
                    url: '/secondParty/addEducation.json',
                    type: 'post',
                    data: $.extend(param, {
                        pwd: $password.val(),
                        link: $educationLinkInput.val()
                    }),
                    success: function (data) {
                        if (check(data)) {
                            showTip("添加成功");
                            searchEducation(1, educationPageSize);
                        }
                    }
                });

                $educationFormModal.modal("hide");
            }
        });

        $body.on("click", ".btn-delete-education", function () {
            if (confirm("确定删除该文字教育？")) {
                var $tr = $(this).parents("tr");
                $.ajax({
                    url: '/secondParty/deleteEducation.json',
                    type: 'post',
                    data: {
                        pwd: $password.val(),
                        id: $tr.data("id")
                    },
                    success: function (data) {
                        if (check(data)) {
                            $tr.remove();
                        }
                    }
                });
            }
        });

        $educationSizeSelector.on("change", function () {
            educationPageSize = this.value;
            searchEducation(1, educationPageSize);
        });

        $('#education-page-input').bind('keyup', function (event) {
            if (event.keyCode == "13") {
                //回车执行查询
                searchEducation(this.value, educationPageSize);
            }
        });

    });
</script>
</body>
</html>
