package org.yunzhong.account.admin.model;

public class AcctItem extends AcctBasicEntity implements Comparable<AcctItem> {
    private String osbType;
    private String itemCode;
    private String itemName;
    private Integer itemBalby;
    private Integer itemClass;
    private String itemNotes;
    private Integer itemLevel;
    private String itemFather;
    private String currType;
    private String currTypeName;
    private Integer mainAcct;
    private Integer cqAcct;

    public String getOsbType() {
        return osbType;
    }

    public void setOsbType(String osbType) {
        this.osbType = osbType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemBalby() {
        return itemBalby;
    }

    public void setItemBalby(Integer itemBalby) {
        this.itemBalby = itemBalby;
    }

    public Integer getItemClass() {
        return itemClass;
    }

    public void setItemClass(Integer itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemNotes() {
        return itemNotes;
    }

    public void setItemNotes(String itemNotes) {
        this.itemNotes = itemNotes;
    }

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getItemFather() {
        return itemFather;
    }

    public void setItemFather(String itemFather) {
        this.itemFather = itemFather;
    }

    public String getCurrType() {
        return currType;
    }

    public void setCurrType(String currType) {
        this.currType = currType;
    }
    
    public String getCurrTypeName() {
        return currTypeName;
    }

    public void setCurrTypeName(String currTypeName) {
        this.currTypeName = currTypeName;
    }

    public Integer getMainAcct() {
        return mainAcct;
    }

    public void setMainAcct(Integer mainAcct) {
        this.mainAcct = mainAcct;
    }

    public Integer getCqAcct() {
        return cqAcct;
    }

    public void setCqAcct(Integer cqAcct) {
        this.cqAcct = cqAcct;
    }

    @Override
    public int compareTo(AcctItem ai) {
        return this.itemCode.compareTo(ai.itemCode);
    }

}
