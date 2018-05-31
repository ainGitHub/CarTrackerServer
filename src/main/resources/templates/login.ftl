<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Авторизация</title>
    <!-- Bootstrap core CSS-->
    <link href="/resources/static/vendor/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/resources/static/vendor/font-awesome/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="/resources/static/css/sb-admin.css" rel="stylesheet" type="text/css">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Авторизация</div>
        <div class="card-body">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Логин</label>
                    <input name="username" class="form-control" type="text" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Пароль</label>
                    <input name="password" class="form-control"  type="password" placeholder="Password">
                </div>
                <button class="btn btn-primary btn-block" type="submit">Войти</button>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="/resources/static/vendor/jquery/jquery.min.js"></script>
<script src="/resources/static/vendor/bootstrap/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="/resources/static/vendor/jquery/jquery.easing.min.js"></script>
</body>

</html>