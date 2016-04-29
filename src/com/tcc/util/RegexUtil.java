package com.tcc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

public class RegexUtil {
	
	private static final Pattern regexAll = Pattern.compile("/noticias");
	private static final Pattern regexById = Pattern.compile("/noticias/([0-9]*)");
	
	public static Long matchId(String requestUri) throws ServletException{
		
		Matcher matcher = regexById.matcher(requestUri);
		if (matcher.find() &&matcher.groupCount()>0){
			String s = matcher.group(1);
			if (s != null && s.trim().length()>0){
				Long id = Long.parseLong(s);
				return id;
			}
		}
		return  null;
	}
	//Verifica se a url é no padrão /noticias/id
	public boolean matchAll(String requestUri) throws ServletException{
		Matcher matcher = regexAll.matcher(requestUri);
		if (matcher.find()){
			return true;
		}
		return false;
		
	}

}
