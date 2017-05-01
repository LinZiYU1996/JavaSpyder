package myspyder;

import java.io.IOException;
import java.net.CookieHandler;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtml {
	int num=1;
	public  void parse_a(Document document,List<String> urls) throws IOException {
		/*提取出href属性里面/item以及后面的字符*/
		Elements links = document.select("[href*=/item]");
		/*迭代输出，并且加入到url集合里面*/
		for (Element link : links) {
			String url  = "https://baike.baidu.com"+link.attr("href"); 
			/*过滤掉重复的url地址*/
			if (!urls.contains(url)) {
				urls.add(url);
			}
		}
	}
	
	public void parse_content(Document document,List<String> contents ) {
		/*使用Jsoup里面的选择器，详细用法可以查看jsoup的官方文档*/
		Elements links = document.select("div.lemma-summary");
		for(Element link:links){
			contents.add(link.text());
		}
		
	}

}
