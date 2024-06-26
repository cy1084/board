package com.min.edu.dto;

public class PageDto {

	private int page;		// 현재 페이지의 번호 0 
	private int countList;	// 페이지당 몇개(row)의 게시글을 보여줄것인지?
	private int totalCount; // 전체글의 갯수
	
	private int countPage;	// 화면에 몇개의 페이지 그룹을 보여줄것인지?
	private int totalPage;	// 게시글을 보여줄 페이지 개수
	
	private int stagePage;	//현재 그룹의 시작 페이지 번호
	private int endPage;	//현재 그룹의 마지막 페이지 번호
	
	public PageDto() {
		
	}

	public PageDto(int page, int countList, int totalCount, int countPage, int totalPage, int stagePage,
			int endPage) {
		super();
		this.page = page;
		this.countList = countList;
		this.totalCount = totalCount;
		this.countPage = countPage;
		this.totalPage = totalPage;
		this.stagePage = stagePage;
		this.endPage = endPage;
	}

	public int getPage() {
		return page;
	}
	
//	화면에서 입력 받은 page의 번호가 전체 page의 숫자보다 크다면 무조건 마지막 page로 세팅
	public void setPage(int page) {
		if(totalPage < page) {
			page = totalPage;
		}
		this.page = page;
	}

	// 한 페이지에 소속된 게시글의 개수
	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	
	// 화면에 보여질 page 그룹
	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	
	// 페이지의 총 개수
	public int getTotalPage() {
		return totalPage;
	}
	
	//bean이다 set의 형태는 값을 입력받고, 넣어주어야하는 형태는 반드시 지켜주어야함.
	//dto와 bean의 차이
	public void setTotalPage(int totalPage) {
		int totalPageResult = totalCount/countList;
		if(totalCount%countList>0) {
			totalPageResult++;
		}
		this.totalPage = totalPageResult;
	}

	
	
	//그룹의 시작번호
	public int getStagePage() {
		return stagePage;
	}

	public void setStagePage(int stagePage) {
		
		int stagePageResult = ((page-1)/countPage)*countPage+1;
		
		this.stagePage = stagePageResult;
	}

	
	
	//화면에 보이는 그룹의 끝번호
	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		int endPageResult = stagePage + countPage-1;
		if(endPageResult > totalPage) {
			endPageResult = totalPage;
		}
		
		this.endPage = endPageResult;
	}

	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	

	
	
	
}
