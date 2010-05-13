
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>App Engine Properties</title>
  </head>

  <body>
  <% for (Object key: System.getProperties().keySet()) { %>
<%= key %> = <%= System.getProperty((String)key) %> <br/>
  <% } %>
  </body>
</html>
