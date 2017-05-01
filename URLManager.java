package myspyder;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLManager {
	/*设置迭代顺序，从第一个开始迭代*/
	int i=0;
	public  void getNewURL(List<String> urls) throws IOException {
		/*从url集合里面获取一个并且进行解析*/
		Document document = ConnectNet.getDom(urls.get(i));
		i+=1;
		Elements links = document.select("[href*=/item]");
		/*通过迭代循环，不断往url集合里面添加新的URL*/
		for (Element link : links) {
			String url  = "https://baike.baidu.com"+link.attr("href"); 
			if(!urls.contains(url)) {
				urls.add(url);
		}
	}
	
	}
}
