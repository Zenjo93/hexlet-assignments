package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import static nz.net.ultraq.thymeleaf.layoutdialect.models.extensions.IModelExtensions.findAll;


public class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        // BEGIN
        List<Map<String, String>> articles = new ArrayList<>();

        int page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;

        int offset = page == 1 ? 0 : page + 10;


        String query = "SELECT id, title, body FROM articles ORDER BY id LIMIT 10 OFFSET ?";

        try {
            // Используем PreparedStatement
            // Он позволяет подставить в запрос значения вместо знака ?
            PreparedStatement statement = connection.prepareStatement(query);
            // Указываем номер позиции в запросе (номер начинается с 1) и значение,
            // которое будет подставлено
            statement.setInt(1, offset);
            // Выполняем запрос
            // Результат выполнения представлен объектом ResultSet
            ResultSet rs = statement.executeQuery();

            // При помощи метода next() можно итерировать по строкам в результате
            // Указатель перемещается на следующую строку в результатах
            while (rs.next()) {
                articles.add(Map.of(
                                // Так можно получить значение нужного поля в текущей строке
                                "id", rs.getString("id"),
                                "title", rs.getString("title"),
                                "body", rs.getString("body")
                        )
                );
            }

        } catch (SQLException e) {
            // Если произошла ошибка, устанавливаем код ответа 500
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        request.setAttribute("page", page);
        request.setAttribute("articles", articles);

        // END
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");

        // BEGIN

        String pathInfo = request.getPathInfo();

        String[] pathParts = pathInfo.split("/");
        int articleid =  Integer.parseInt(ArrayUtils.get(pathParts, 1, null));


        String query = "SELECT title, body FROM articles WHERE id = ?";

        Map<String, String> article;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, articleid);
            ResultSet rs = statement.executeQuery();
            rs.first();
            article = Map.of("title", rs.getString("title"), "body", rs.getString("body"));

        } catch (SQLException e) {
            // Если произошла ошибка, устанавливаем код ответа 500
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        request.setAttribute("article", article);

        // END
        TemplateEngineUtil.render("articles/show.html", request, response);
    }
}
