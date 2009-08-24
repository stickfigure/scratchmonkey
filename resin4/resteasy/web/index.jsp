<%@ page import="com.caucho.loader.*, java.util.*" %>

<ol>
<%
  LinkedList loaders = new LinkedList();

  ClassLoader loader = Thread.currentThread().getContextClassLoader();

  while (loader != null) {
    loaders.addFirst(loader);
    loader = loader.getParent();
  }

  Iterator iter = loaders.iterator();

  while (iter.hasNext()) {
    loader  = (ClassLoader) iter.next();

    out.print("<li>");
    out.print(loader.toString());
    out.print(" System.identityHashCode()=");
    out.println(System.identityHashCode(loader));

    if (loader instanceof DynamicClassLoader) {
      out.print("<ul>");

      DynamicClassLoader dynamicClassLoader = (DynamicClassLoader) loader;

      String classPath = dynamicClassLoader.getLocalClassPath();
      String pathSeparator = "" + java.io.File.pathSeparatorChar;

      classPath = "<li>" + classPath.replace(pathSeparator, "\n</li><li>") + "</li>";
      out.println(classPath); 

      out.print("</ul>");
    }
  }
%>
</ol>
