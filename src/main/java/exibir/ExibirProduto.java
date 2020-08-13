package exibir;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao.ProdutoDao;
import model.Produto;

public class ExibirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter();

        String reqId = req.getParameter("id");

        ProdutoDao dao = new ProdutoDao();
        Gson gson = new Gson();

        try {
            if (reqId != null) {
                int id = Integer.parseInt(reqId);
                Produto prod = dao.pesquisarUrl(id);
                saida.println(gson.toJson(prod));
            }
            else {
                List<Produto> prods = dao.pesquisar();
                saida.println(gson.toJson(prods));
            }
        }
        catch (SQLException | NumberFormatException e) {
            saida.println("Erro: " + e.getMessage());
        }
        finally {
            saida.flush();
            saida.close();
        }

    }
    
}