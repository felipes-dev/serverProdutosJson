package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import util.ConexaoBanco;

public class ProdutoDao {

    public List<Produto> pesquisar() throws SQLException{
        
        Connection con = new ConexaoBanco().getConnection();

        List<Produto> lista = new ArrayList<>();
        String query = "SELECT * FROM TB_PRODUTOS";

        PreparedStatement st = con.prepareStatement(query);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Produto prod = new Produto();
            
            prod.setIdProduto   ( rs.getInt   ("ID")  );
            prod.setDescricao   ( rs.getString("DESCRICAO")  );
            prod.setQuantidade  ( rs.getInt   ("QUANTIDADE") );
            prod.setValor       ( rs.getDouble("VALOR")      );
            
            lista.add(prod);            
        }   
        return lista;
    }

    public Produto pesquisarUrl(int id) throws SQLException {

        Connection con = new ConexaoBanco().getConnection();
        
        Produto prod = new Produto();
        String query = "SELECT * FROM TB_PRODUTOS WHERE ID=?";
        
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {            
            prod.setIdProduto   ( rs.getInt   ("ID")  );
            prod.setDescricao   ( rs.getString("DESCRICAO")  );
            prod.setQuantidade  ( rs.getInt   ("QUANTIDADE") );
            prod.setValor       ( rs.getDouble("VALOR")      );        
        }   
        return prod;
    }
    
}