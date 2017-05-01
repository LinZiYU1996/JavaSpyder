package myspyder;

import java.io.IOException;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StartSpyder {

	public static void main(String[] args) throws IOException {
		/*根url，python词条页面*/
		String rooturl = "http://baike.baidu.com/link?url=y9cRcLYxzn5I12dTAXUqJJuY50B0TVvsdkeqmHetkVfkRlXGxUa0tFL53dQwpSQaF7js4yRmTwLjqXyJN-hWWK";
		Document rootdocument = Jsoup.connect(rooturl).get();
		int index=1;
		ParseHtml parseHtml = new ParseHtml();
		ConnectNet connectNet = new ConnectNet();
		Store store = new Store();
		/*放置要迭代的url*/
		List<String> urls = new ArrayList<>();
		/*放置简介字符串*/
		List<String> contents = new ArrayList<>();
		
		parseHtml.parse_a(rootdocument, urls);
		URLManager urlManager = new URLManager();
		/*纯粹用来计数*/
		int flag=1;
		/*
		 * 首先判断url集合里面是否还有可以爬取的url，然后从中按照顺序获取一个URL
		 * 然后URL管理器继续进行添加新的url，从提取出的URL获取dom对象，进行解析，存入txt文本，
		 * 循环进行，直到没有新的url可以爬取。
		 */
		while(urls!=null) {
			String url = urls.get(index-1);
			index+=1;
			urlManager.getNewURL(urls);
			Document document = connectNet.getDom(url);
			parseHtml.parse_content(document, contents);
			store.store_contents(contents);
			System.out.println("StartSpyder.main()");
			System.out.println(flag);
			flag+=1;
		}

	}

}
