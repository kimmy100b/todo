<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="./css/styles.css" />
        <title>ToDo Form</title>
    </head>

    <body>
        <h1 class="todo-title">할일 등록</h1>
        <form action="TodoFormServlet" method="post" class="todo-form">
            <div class="form-group"><label>어떤일인가요?</label> <input type="text" name="todo" placeholder="최대 24자까지" maxlength="20" required /></div>
            <div class="form-group"><label>누가 할일인가요?</label> <input type="text" name="name" required /></div>
            <span>우선순위를 선택하세요</span>
            <div class="form-radio form-group">
                <input type="radio" id="1" name="sequence" value="1" checked />
                <label for="1">1순위</label><br />
                <input type="radio" id="2" name="sequence" value="2" /> <label for="2">2순위</label><br />
                <input type="radio" id="3" name="sequence" value="3" />
                <label for="3">3순위</label><br />
            </div>
            <div class="form-btn">
                <div class="btn-back">
                    <a href="./Main">&lt;이전</a>
                </div>
                <div class="btn-input">
                    <input type="submit" value="제출" />
                    <input type="reset" value="내용지우기" />
                </div>
            </div>
        </form>
    </body>

    </html>