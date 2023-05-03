package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        String parameter = request.getParameter("search");
        String queryString = request.getQueryString();
        PrintWriter out = response.getWriter();

        if (queryString == null || parameter == null) {
            String allCompanies = Data.getCompanies().stream().collect(Collectors.joining("\n"));
            out.println(allCompanies);
        }

        else if (queryString.contains("search=")) {
            String filteredCompanies = Data.getCompanies().stream()
                    .filter(company -> company.contains(parameter)).collect(Collectors.joining("\n"));

            if (filteredCompanies.equals("")) {
                out.println("Companies not found");
            } else {
                out.println(filteredCompanies);
            }
        }

        // END
    }
}
