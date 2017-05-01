package myspyder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test05 {

	public static void main(String[] args) throws IOException {
		
		String url = "http://baike.baidu.com/link?url=y9cRcLYxzn5I12dTAXUqJJuY50B0TVvsdkeqmHetkVfkRlXGxUa0tFL53dQwpSQaF7js4yRmTwLjqXyJN-hWWK";
		Document document = Jsoup.connect(url).get();
		ParseHtml parseHtml = new ParseHtml();
		List<String> urls = new ArrayList<>();
		parseHtml.parse_a(document, urls);
		for (int i = 0; i < urls.size(); i++) {
			System.out.println(urls.get(i));
		}
	}

}
