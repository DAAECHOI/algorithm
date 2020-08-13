package com.ssafy.java.d0813.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsSAXImplSAXHandler extends DefaultHandler implements INewsMgr{
	private List<News> list;
	private News news;
	private String str;

	public NewsSAXImplSAXHandler() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse("http://rss.etnews.com/Section902.xml", this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            news = new News();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(news != null) {
	        if (qName.equals("title")) {
	            news.setTitle(str);
	        } else if (qName.equals("link")) {
	            news.setLink(str);
	        } else if (qName.equals("description")) {
	            news.setDesc(str);
	        }else if (qName.equals("item")) {
	            list.add(news);
	            news = null;
	        }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        str = String.valueOf(ch, start, length);
    }

	@Override
	public List<News> getNewsList(String url) {
		List<News> tmp = new ArrayList<>();
		for(News news : list) {
			if(news.getLink().equals(url)){
				tmp.add(news);
			}
		}
		return tmp;
	}

	@Override
	public News search(int index) {
		return list.get(index-1);
	}

	@Override
	public void showList() {
		for(News news : list) {
        	System.out.println(list.indexOf(news)+1 + " "+ news);
        }
	}

	@Override
	public void connectNews(String title) {
		for(News news : list) {
			if(news.getTitle().contains(title)){
				System.out.println(list.indexOf(news)+1 + " " + news);
			}
		}
	}

}
