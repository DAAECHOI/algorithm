package com.ssafy.java.d0813.xml;

public class NewsMain {
	public static void main(String[] args) {
		INewsMgr mgr = new NewsSAXImplSAXHandler();
		
		mgr.showList();
		System.out.println();
		
		int index = 5;
		News news = mgr.search(index);
		System.out.println(index + " " + mgr.getNewsList(news.getLink()));
		System.out.println();
		
		String title = "실적";
		mgr.connectNews(title);
	}
}
