package com.ziduye.modules.base.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ziduye.base.entity.BaseEntity;
import com.ziduye.modules.sys.entity.User;
import com.ziduye.utils.Const;
import com.ziduye.utils.base.Ids;

public class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	protected User createUser;	// 创建用户
	protected Date createDate;	// 创建日期
	
	protected User updateUser;	// 更新用户
	protected Date updateDate;	// 更新日期
	
	protected String dataStatus; 	// 状态标志(0:正常;1:删除;)
	protected String remarks;	// 备注
	
	public static final String DEL_FLAG_NORMAL = Const.DEL_FLAG_NORMAL;
	public static final String DEL_FLAG_DELETE = Const.DEL_FLAG_DELETE;
	
	public boolean isNormail() {
		return DEL_FLAG_NORMAL.equals(this.dataStatus) ;
	}
	
	private String genId(){
		return Ids.uuidShort();
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert(){
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord){
			setId(genId());
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate(){
		this.updateDate = new Date();
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
	
	public DataEntity() {
		super();
		this.dataStatus = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(String id) {
		super(id);
	}
}
