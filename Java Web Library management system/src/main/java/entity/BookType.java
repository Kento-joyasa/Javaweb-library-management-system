package main.java.entity;

/**
 * 图书类别实体类
 */
public class BookType {

    String typeId;
    String typeName;
    String typeDesc;

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public String getTypeName() {
        return typeName;
    }
}
