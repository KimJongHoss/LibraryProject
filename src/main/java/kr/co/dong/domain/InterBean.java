package kr.co.dong.domain;

public class InterBean {
    private int interid;
    private int library_code;
    private String isbncode;
    private String etc;
    private String userid;
	private String username;
    private String libraryname;
    
//    싹다 생성자
	public InterBean(int interid, int library_code, String isbncode, String etc, String userid, String username,
			String libraryname) {
		super();
		this.interid = interid;
		this.library_code = library_code;
		this.isbncode = isbncode;
		this.etc = etc;
		this.userid = userid;
		this.username = username;
		this.libraryname = libraryname;
	}
    
//	default 생성자
    public InterBean() {
    	
    }
    
//    getter/setter
	public String getIsbncode() {
		return isbncode;
	}

	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}


    public int getInterid() {
        return interid;
    }

    public void setInterid(int interid) {
        this.interid = interid;
    }

    public int getLibrary_code() {
        return library_code;
    }

    public void setLibrary_code(int library_code) {
        this.library_code = library_code;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLibraryname() {
        return libraryname;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname;
    }

//    toString
    @Override
	public String toString() {
		return "InterBean [interid=" + interid + ", library_code=" + library_code + ", isbncode=" + isbncode + ", etc="
				+ etc + ", userid=" + userid + ", username=" + username + ", libraryname=" + libraryname + "]";
	}
    
}
