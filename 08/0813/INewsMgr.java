package com.ssafy.java.d0813.xml;

import java.util.List;

public interface INewsMgr {
	
	List<News> getNewsList(String url);
	
	News search(int index);
	
	void showList();
	
	void connectNews(String title);
	
}
