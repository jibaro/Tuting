package PageRank;

import iweb2.ch2.webcrawler.CrawlData;

public class PageRank extends Rank {
    
	PageRankMatrixBuilder pageRankBuilder;
	
	public PageRank(CrawlData crawlData) {
        pageRankBuilder = new PageRankMatrixBuilder(crawlData);
        pageRankBuilder.run();     
	}
	
	@Override
	public PageRankMatrixH getH() {
		return pageRankBuilder.getH();
	}
	
}
