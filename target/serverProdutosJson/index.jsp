<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.ProdutoDao"%>
<%@ page import="model.Produto"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Exemplo</title>
    </head>

    <body>
        
        <%
            out.println("Consulta ao banco");
            try {
                ProdutoDao dao = new ProdutoDao();
                List<Produto> lstProd = dao.pesquisar();
                out.println("ok");               
                for (Produto p : lstProd) {
                    out.println("<p>ID: " + p.getIdProduto() + "</p>");
                    out.println("<p>Descrição: " + p.getDescricao() + "</p>");
                    out.println("<p>Quantidade: " + p.getQuantidade() + "</p>");
                    out.println("<p>Valor: " + p.getValor() + "</p>");
                }
            } catch (SQLException e) {
                out.println("<p>Erro " + e.getMessage() + "</p>");
                
            }          
        %>      

    </body>
</html>