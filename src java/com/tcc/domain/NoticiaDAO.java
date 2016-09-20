package com.tcc.domain;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;


public class NoticiaDAO extends BaseDAO{
	public Noticia getNoticiaById(Long id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from noticia where idnoticia=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				Noticia news = createNoticia(rs);
				rs.close();
				return news;
			}
		}finally{
			if (stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return null;
	}
	public List<Noticia>findByTitulo(String name) throws SQLException{
		List<Noticia> noticias = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from noticia where(titulo) like?");
			stmt.setString(1, "%" + name.toLowerCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Noticia news = createNoticia(rs);
				noticias.add(news);
			}
			rs.close();
		}finally{
			if (stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return noticias;
		
	}
	public List<Noticia>getNoticia() throws SQLException{
		List<Noticia> noticias = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from noticia");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Noticia news = createNoticia(rs);
				noticias.add(news);
			}
			rs.close();
		}finally{
			if (stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return noticias;
	}

	public Noticia createNoticia(ResultSet rs) throws SQLException {
		Noticia news = new Noticia();
		news.setID(rs.getLong("idnoticia"));
		news.setChamada(rs.getString("chamada"));
		news.setTexto(rs.getString("textoNoticia"));
		news.setTitulo(rs.getString("titulo"));
		news.setFalaMais(rs.getLong("falaMais"));
		news.setFalaMenos(rs.getLong("falaMenos"));
		return news;
	}
	public void save(Noticia news) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			if (news.getID()==null){
				stmt = conn.prepareStatement("insert into noticia (chamada, titulo, textoNoticia) VALUES(?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
			}else{
				stmt = conn.prepareStatement("update noticia set chamada=?,titulo=?,textoNoticia=?,"
						+ "falaMais=?,falaMenos=? where idnoticia=?");
			}
			stmt.setString(1, news.getChamada());
			stmt.setString(2, news.getTitulo());
			stmt.setString(3, news.getTexto());
			
			if (news.getID()!=null){
				stmt.setLong(4, news.getID());
			}
			int count = stmt.executeUpdate();
			if (count == 0){
				throw new SQLException("Erro ao inserir noticia");
			}
			if (news.getID()== null){
				Long id = getGeneratedId(stmt);
				news.setID(id);
			}
		}finally{
			if (stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	public static Long getGeneratedId(PreparedStatement stmt) throws SQLException  {
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()){
			Long id = rs.getLong(1);
			return id;
		}
		return 0L;
	}
	
	public boolean delete(Long id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("delete from noticia where idnoticia=?");
			stmt.setLong(1, id);
			int count = stmt.executeUpdate();
			boolean ok = count > 0;
			return ok;
		}finally{
			if (stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}		
		}
	}
}
