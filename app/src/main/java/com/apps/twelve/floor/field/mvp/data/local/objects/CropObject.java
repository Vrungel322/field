package com.apps.twelve.floor.field.mvp.data.local.objects;

/**
 * Created by Yaroslav on 12.05.2017.
 */

public class CropObject {

  private Long id;
  private String name;
  private Long parentId;
  private boolean isGroup;

  public CropObject(Long id, String name, Long parentId, boolean isGroup) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.isGroup = isGroup;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public boolean isGroup() {
    return isGroup;
  }

  public void setGroup(boolean group) {
    isGroup = group;
  }
}
