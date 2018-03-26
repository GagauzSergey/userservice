<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Web 1</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
<h1 align="center">Add User</h1>
<div class="panel-body " align="center">
    <div class="col-sm-4 col-sm-offset-4">
        <form method="post">
            <div class="form-group">
                <label for="id">Id:</label>
                <input type="text" class="form-control " id="id" name="id">
            </div>
            <div class="form-group">
                <label for="firstName">First name:</label>
                <input type="text" class="form-control" id="firstName" name="firstName">
            </div>
            <div class="form-group">
                <label for="lastName">First name:</label>
                <input type="text" class="form-control" id="lastName" name="lastName">
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="text" class="form-control" id="age" name="age">
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</div>
</body>
</html>