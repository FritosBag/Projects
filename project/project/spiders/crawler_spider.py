from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule
from project.items import Article

class ArticleSpider(CrawlSpider):
    name = 'crawler'
    start_urls = ['https://en.wikipedia.org/wiki/Main_Page']
    rules = [Rule(LinkExtractor(), callback = 'parse_items', follow = True)] #allow = r'.*'
    handle_httpstatus_list = [800]

    def parse_items(self, response):
        article = Article()
        article['url'] = response.url
        article['title'] = response.css('title::text').extract_first()

        return article