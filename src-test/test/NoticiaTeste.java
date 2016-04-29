package test;
import junit.framework.TestCase;

import java.util.List;

import com.tcc.domain.*;

public class NoticiaTeste extends TestCase {
	private NoticiaService noticiaService = new NoticiaService();
		public void testListaNoticias(){
			List<Noticia> noticias = noticiaService.getNoticias();
			assertNotNull(noticias);
			assertTrue(noticias.size()>0);
			//Noticia dois = noticiaService.findByTitulo("kk").get(0);
			Noticia um = noticiaService.getNoticiaId(1l);
		}
	}
