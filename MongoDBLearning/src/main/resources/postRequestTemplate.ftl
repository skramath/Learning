<html>
    <head><title>Post a Fruit</title></head>
    <form action="/favourite_fruit" method="post">
        <p>What is your Fav Fruit</p>
        <#list fruits as fruit>
            <p>
                <input type="radio" name="fruit" value="${fruit}">${fruit}</input>
            </p>
        </#list>
            <input type="submit" value="submit"/>

    </form>
</html>