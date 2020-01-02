package org.yunzhong.account.admin.vo;

public class RspHead {
	
	private String infcode;
	
	private String version="01";
	
	private String datatype="1";
	
	private String level="5";
	
	private String retcode;
	
	private String retmsg;
	
	private String signedmsg="";
	
	public RspHead()
	{}

	public RspHead(String infcode,String version,String datatype,String level,
			String retcode,String retmsg){
		this.setInfcode(infcode);
		this.setVersion(version);
		this.setDatatype(datatype);
		this.setLevel(level);
		this.setRetcode(retcode);
		this.setRetmsg(retmsg);
	}
	
	public RspHead(String retcode,String retmsg){
		this.setRetcode(retcode);
		this.setRetmsg(retmsg);
	}	
	
	public String getInfcode() {
		return infcode;
	}

	public void setInfcode(String infcode) {
		this.infcode = infcode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

	public String getSignedmsg() {
		return signedmsg;
	}

	public void setSignedmsg(String signedmsg) {
		this.signedmsg = signedmsg;
	}
}
