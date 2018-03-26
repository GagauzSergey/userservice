<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Web 1</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"

</head>

<body>
<h1 align="center">User Service</h1>
<div class="panel-body">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>

            <td class="text-center">

                <form class="button" action="user_edit.ftl" method="get">
                    <button class="btn btn-success" type="submit" name="id" value="${user.id}">Update</button>
                </form>

        </tr>
        </#list>
        </tbody>
    </table>
    <div>

</body>
</html>